package com.microservice.profiles.profiles.domain.model.queries;

import com.microservice.profiles.profiles.domain.model.valueobjects.Username;

public record GetProfileByUsernameQuery(Username username) {
}
