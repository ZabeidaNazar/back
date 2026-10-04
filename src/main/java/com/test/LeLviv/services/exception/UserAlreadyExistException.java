package com.test.LeLviv.services.exception;

public class UserAlreadyExistException extends Throwable {

    private static final String USER_ALREADY_EXIST_EXCEPTION_TEXT = "User with username = %s already exist.";
    private static final String USER_ALREADY_EXIST_WITH_EMAIL_AND_USERNAME_EXCEPTION_TEXT =
            "User with username = %s and email = %s already exist.";

    public UserAlreadyExistException(String username) {
        super(String.format(USER_ALREADY_EXIST_EXCEPTION_TEXT, username));
    }

    public UserAlreadyExistException(String email, String username) {
        super(String.format(USER_ALREADY_EXIST_WITH_EMAIL_AND_USERNAME_EXCEPTION_TEXT, username, email));
    }
}
