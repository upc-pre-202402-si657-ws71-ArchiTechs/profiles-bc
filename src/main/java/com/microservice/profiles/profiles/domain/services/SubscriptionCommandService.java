package com.microservice.profiles.profiles.domain.services;

import com.microservice.profiles.profiles.domain.model.aggregates.Subscription;
import com.microservice.profiles.profiles.domain.model.commands.CreateSubscriptionCommand;
import com.microservice.profiles.profiles.domain.model.commands.DeleteSubscriptionCommand;
import com.microservice.profiles.profiles.domain.model.commands.UpdateSubscriptionCommand;


import java.util.List;
import java.util.Optional;


public interface SubscriptionCommandService {
    Long handle(CreateSubscriptionCommand command);
    Optional<Subscription> handle(UpdateSubscriptionCommand command);
    void handle(DeleteSubscriptionCommand command);
}
