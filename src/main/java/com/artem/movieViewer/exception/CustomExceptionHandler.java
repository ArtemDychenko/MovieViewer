package com.artem.movieViewer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleInvalidArgument(MethodArgumentNotValidException exception) {
        var reason = exception.getBindingResult().getFieldError().getDefaultMessage();
        if (reason == null) {
            reason = "invalidFields";
        }

        var message = switch (reason) {
            case "invalidEmail" -> "Email is wrong";
            case "invalidPassword" -> "Password is wrong";
            default -> {
                reason = "invalidFields";
                yield "Fields are empty";
            }
        };
        return new ErrorResponse(reason, message);
    }

    @ExceptionHandler(CustomResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(CustomResponseStatusException exception) {
        return new ResponseEntity<>(exception.getErrorResponse(), exception.getStatusCode());
    }
}
