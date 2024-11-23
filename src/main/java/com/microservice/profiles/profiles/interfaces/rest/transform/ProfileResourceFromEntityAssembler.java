package com.microservice.profiles.profiles.interfaces.rest.transform;

import com.microservice.profiles.profiles.domain.model.aggregates.Profile;
import com.microservice.profiles.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
  public static ProfileResource toResourceFromEntity(Profile entity) {
    return new ProfileResource(entity.getId(), entity.getEmailAddress(),
        entity.getFullName(), entity.getStreetAddress());
  }
}
