package com.microservice.profiles.profiles.interfaces.rest.transform;

import com.microservice.profiles.profiles.domain.model.commands.CreateSubscriptionCommand;
import com.microservice.profiles.profiles.interfaces.rest.resources.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {
    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource){
        return new CreateSubscriptionCommand(resource.nameSubscription(),resource.description(),resource.price());
    }
}
