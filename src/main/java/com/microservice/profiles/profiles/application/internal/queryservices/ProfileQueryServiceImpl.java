package com.microservice.profiles.profiles.application.internal.queryservices;

import com.microservice.profiles.profiles.domain.model.queries.GetProfileByUsernameQuery;
import org.springframework.stereotype.Service;
import com.microservice.profiles.profiles.domain.model.queries.GetAllProfilesQuery;
import com.microservice.profiles.profiles.domain.model.aggregates.Profile;
import com.microservice.profiles.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.microservice.profiles.profiles.domain.model.queries.GetProfileByIdQuery;
import com.microservice.profiles.profiles.domain.services.ProfileQueryService;
import com.microservice.profiles.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
  private final ProfileRepository profileRepository;

  public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @Override
  public Optional<Profile> handle(GetProfileByEmailQuery query) {
    return profileRepository.findByEmail(query.emailAddress());
  }

  @Override
  public Optional<Profile> handle(GetProfileByIdQuery query) {
    return profileRepository.findById(query.profileId());
  }

  @Override
  public Optional<Profile> handle(GetProfileByUsernameQuery query) {
    return profileRepository.findByUsername(query.username());
  }

  @Override
  public List<Profile> handle(GetAllProfilesQuery query) {
    return profileRepository.findAll();
  }
}
