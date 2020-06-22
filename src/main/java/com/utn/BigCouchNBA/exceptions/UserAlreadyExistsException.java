package com.utn.BigCouchNBA.exceptions;

public class UserAlreadyExistsException extends RecordExistsException {


    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public String getMessage() {
        return "User Already Exist!!";
    }
}
