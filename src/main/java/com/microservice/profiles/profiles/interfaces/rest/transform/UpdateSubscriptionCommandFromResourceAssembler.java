package com.microservice.profiles.profiles.interfaces.rest.transform;

import com.microservice.profiles.profiles.domain.model.commands.UpdateSubscriptionCommand;
import com.microservice.profiles.profiles.interfaces.rest.resources.UpdateSubscriptionResource;

public class UpdateSubscriptionCommandFromResourceAssembler {
    public static UpdateSubscriptionCommand toCommandFromResource(Long subscriptionId, UpdateSubscriptionResource resource){
        return new UpdateSubscriptionCommand(subscriptionId, resource.nameSubscription(), resource.description(), resource.price());
    }
}
