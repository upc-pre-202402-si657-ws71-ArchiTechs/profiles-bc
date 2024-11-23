package com.microservice.profiles.profiles.domain.model.commands;

public record CreateSubscriptionCommand(String nameSubscription,String description, Double price) {
}
