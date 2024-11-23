package com.microservice.profiles.profiles.interfaces.rest.transform;

import com.microservice.profiles.profiles.domain.model.aggregates.Subscription;
import com.microservice.profiles.profiles.interfaces.rest.resources.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {
    public static SubscriptionResource toResourceFromEntity(Subscription entity){
        return new SubscriptionResource(entity.getId(),entity.getNameSubscription().subscriptionName(), entity.getDescription(), entity.getPrice());
    }
}
