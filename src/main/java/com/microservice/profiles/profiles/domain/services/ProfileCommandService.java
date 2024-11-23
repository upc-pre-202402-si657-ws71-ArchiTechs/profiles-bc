package com.microservice.profiles.profiles.domain.services;

import com.microservice.profiles.profiles.domain.model.aggregates.Profile;
import com.microservice.profiles.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
  Optional<Profile> handle(CreateProfileCommand command);
}