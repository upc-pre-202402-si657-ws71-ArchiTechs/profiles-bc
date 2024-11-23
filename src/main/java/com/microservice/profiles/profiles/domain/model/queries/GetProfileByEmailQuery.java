package com.microservice.profiles.profiles.domain.model.queries;

import com.microservice.profiles.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}