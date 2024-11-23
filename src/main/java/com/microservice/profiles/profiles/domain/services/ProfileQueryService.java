package com.microservice.profiles.profiles.domain.services;

import com.microservice.profiles.profiles.domain.model.aggregates.Profile;
import com.microservice.profiles.profiles.domain.model.queries.GetAllProfilesQuery;
import com.microservice.profiles.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.microservice.profiles.profiles.domain.model.queries.GetProfileByIdQuery;
import com.microservice.profiles.profiles.domain.model.queries.GetProfileByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
  Optional<Profile> handle(GetProfileByEmailQuery query);
  Optional<Profile> handle(GetProfileByIdQuery query);
  Optional<Profile> handle(GetProfileByUsernameQuery query);
  List<Profile> handle(GetAllProfilesQuery query);
}
