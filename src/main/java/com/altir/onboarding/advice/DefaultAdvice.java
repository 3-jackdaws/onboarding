package com.altir.onboarding.advice;

import com.altir.onboarding.api.error.ApiErrorDTO;
import com.altir.onboarding.exception.OrganizationAlreadyExistsException;
import com.altir.onboarding.exception.OrganizationNotFoundException;
import com.altir.onboarding.exception.UserAlreadyExistsException;
import com.altir.onboarding.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {

    private static final String PARAMETER_FORMAT_INVALID = "Parameter format is invalid: [%s]";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info(ex.getMessage());
        return buildErrorResponseDto(HttpStatus.BAD_REQUEST,
                PARAMETER_FORMAT_INVALID.formatted(buildBadParamsMessage(ex)));
    }

    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity<ApiErrorDTO> handleBadRequestException(Exception e) {
        log.error(e.getMessage(), e);
        return buildErrorResponseDto(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            OrganizationNotFoundException.class})
    public ResponseEntity<ApiErrorDTO> handleNotFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return buildErrorResponseDto(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler({
            UserAlreadyExistsException.class,
            OrganizationAlreadyExistsException.class})
    public ResponseEntity<ApiErrorDTO> handleAlreadyExistsException(Exception e) {
        log.error(e.getMessage(), e);
        return buildErrorResponseDto(HttpStatus.CONFLICT, e.getMessage());
    }

    private <T> ResponseEntity<T> buildErrorResponseDto(HttpStatus status, String message) {
        var error = new ApiErrorDTO()
                .error(status.getReasonPhrase())
                .message(message);
        return ResponseEntity
                .status(status)
                .body((T) error);
    }

    private String buildBadParamsMessage(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .map(FieldError::getField)
                .collect(Collectors.joining(", "));
    }
}
