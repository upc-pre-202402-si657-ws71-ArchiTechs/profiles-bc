package com.microservice.profiles.profiles.interfaces.rest.transform;

import com.microservice.profiles.profiles.domain.model.commands.CreateProfileCommand;
import com.microservice.profiles.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
  public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
    return new CreateProfileCommand(resource.firstName(), resource.lastName(), resource.username(),
        resource.email(), resource.street(), resource.number(), resource.city(),
        resource.postalCode(), resource.country());
  }
}
