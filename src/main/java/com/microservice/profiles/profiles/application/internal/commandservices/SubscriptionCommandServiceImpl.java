package com.microservice.profiles.profiles.application.internal.commandservices;

import com.microservice.profiles.profiles.domain.model.aggregates.Subscription;
import com.microservice.profiles.profiles.domain.model.commands.CreateSubscriptionCommand;
import com.microservice.profiles.profiles.domain.model.commands.DeleteSubscriptionCommand;
import com.microservice.profiles.profiles.domain.model.commands.UpdateSubscriptionCommand;
import com.microservice.profiles.profiles.domain.model.valueobjects.NameSubsCription;
import com.microservice.profiles.profiles.domain.services.SubscriptionCommandService;
import com.microservice.profiles.profiles.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionCommandServiceImpl implements SubscriptionCommandService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionCommandServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Long handle(CreateSubscriptionCommand command) {
        var subscription = new Subscription(command.nameSubscription(),command.description(),command.price());
        try{
            subscriptionRepository.save(subscription);

        } catch (Exception e) {
            throw new IllegalArgumentException("Error while creating subscription: " + e.getMessage());
        }
        return subscription.getId();
    }

    @Override
    public Optional<Subscription> handle(UpdateSubscriptionCommand command) {
        var result = subscriptionRepository.findById(command.id());
        if (result.isEmpty())
            throw new IllegalArgumentException("Subscription with id " + command.id() + " not found");
        var subscriptionToUpdate = result.get();
        try {
            NameSubsCription nameRecord=new NameSubsCription(command.nameSubscription());
            subscriptionToUpdate.setNameSubscription(nameRecord);
            subscriptionToUpdate.setDescription(command.description());
            subscriptionToUpdate.setPrice(command.price());
            subscriptionRepository.save(subscriptionToUpdate);
            return Optional.of(subscriptionToUpdate);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating subscription: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteSubscriptionCommand command) {
        var result = subscriptionRepository.findById(command.subscriptionId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Subscription with id " + command.subscriptionId() + " not found");
        try {
            subscriptionRepository.delete(result.get());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting subscription: " + e.getMessage());
        }
    }
}
