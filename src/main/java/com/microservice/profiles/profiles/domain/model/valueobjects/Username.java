package com.microservice.profiles.profiles.domain.model.valueobjects;

public record Username(String username) {
    public Username(){
        this(null);
    }
    public Username {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
    }
}
