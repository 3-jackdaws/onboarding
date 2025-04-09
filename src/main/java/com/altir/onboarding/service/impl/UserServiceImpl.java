package com.altir.onboarding.service.impl;

import com.altir.onboarding.exception.UserAlreadyExistsException;
import com.altir.onboarding.exception.UserNotFoundException;
import com.altir.onboarding.mapper.UserMapper;
import com.altir.onboarding.mapper.UserPatchMapper;
import com.altir.onboarding.model.User;
import com.altir.onboarding.repository.UserRepository;
import com.altir.onboarding.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MongoTemplate mongoTemplate;
    private final UserPatchMapper userPatchMapper;

    @Override
    public User getUserById(String id) {
        log.info("Getting user by id: " + id);

        return userRepository.findById(id)
                .map(userMapper::toModel)
                .orElseThrow(() -> new UserNotFoundException("User with id: [%s] not found".formatted(id)));
    }

    @Override
    public List<User> getUsers(String firstName, String lastName) {
        Criteria criteria = new Criteria();

        if (!StringUtils.isBlank(firstName)) {
            criteria.and("firstName").regex(firstName, "i");
        }
        if (!StringUtils.isBlank(lastName)) {
            criteria.and("lastName").regex(lastName, "i");
        }

        MatchOperation match = Aggregation.match(criteria);
        SortOperation sort = sort(Sort.Direction.ASC, "id");

        Aggregation aggregation = Aggregation.newAggregation(match, sort);

        return mongoTemplate.aggregate(aggregation, "users", User.class).getMappedResults();
    }

    @Override
    public User createUser(User user) {
        existingCheck(user);

        return userMapper.toModel(
                userRepository.save(
                        userMapper.toEntity(user)));
    }

    private void existingCheck(User user) {
        userRepository.findAllByEmail(user.getEmail())
                .ifPresent(existingUser -> {
                    throw new UserAlreadyExistsException("A user with this Email Address: [$s] already exists.".formatted(user.getEmail()));
                });
    }

    @Override
    public User patchUser(String id, User updates) {
        User user = getUserById(id);
        userPatchMapper.copyNonNullFields(user, updates);

        return userMapper.toModel(
                userRepository.save(
                        userMapper.toEntity(user)));
    }

    @Override
    public void deleteUser(String id) {
        getUserById(id);
        log.info("Deleting user by id: " + id);
        userRepository.deleteById(id);
    }
}