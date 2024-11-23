package com.microservice.profiles.profiles.application.internal.commandservices;

import org.springframework.stereotype.Service;
import com.microservice.profiles.profiles.domain.model.aggregates.Profile;
import com.microservice.profiles.profiles.domain.model.commands.CreateProfileCommand;
import com.microservice.profiles.profiles.domain.model.valueobjects.EmailAddress;
import com.microservice.profiles.profiles.domain.services.ProfileCommandService;
import com.microservice.profiles.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
  private final ProfileRepository profileRepository;

  public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @Override
  public Optional<Profile> handle(CreateProfileCommand command) {
    var emailAddress = new EmailAddress(command.email());
    profileRepository.findByEmail(emailAddress).ifPresent(profile -> {
      throw new IllegalArgumentException("Profile with email " + command.email() + " already exists");
    });

    var profile = new Profile(command);
    profileRepository.save(profile);
    System.out.println("Profile created and saved for username: " + command.username());

    return Optional.of(profile);
  }
}