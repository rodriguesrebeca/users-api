package com.exercise.userapi.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationException extends RuntimeException {
    private final List<String> validationErrors;

    public ValidationException(List<String> validationErrors) {
        super(validationErrors.stream().collect(Collectors.joining(";")));
        this.validationErrors = validationErrors;
    }

    public ValidationException(String validationErrorMessage) {
        super(validationErrorMessage);
        validationErrors = List.of(validationErrorMessage);
    }
}
