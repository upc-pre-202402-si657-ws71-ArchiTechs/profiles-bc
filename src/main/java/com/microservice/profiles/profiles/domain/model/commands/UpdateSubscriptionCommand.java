package com.microservice.profiles.profiles.domain.model.commands;

public record UpdateSubscriptionCommand(Long id,String nameSubscription,String description, Double price) {
}
