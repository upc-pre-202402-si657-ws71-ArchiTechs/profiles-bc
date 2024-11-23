package com.microservice.profiles.profiles.domain.services;

import com.microservice.profiles.profiles.domain.model.aggregates.Subscription;
import com.microservice.profiles.profiles.domain.model.queries.GetAllSubscriptionsQuery;
import com.microservice.profiles.profiles.domain.model.queries.GetSubscriptionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SubscriptionQueryService {
    Optional<Subscription> handle(GetSubscriptionByIdQuery query);
    List<Subscription> handle(GetAllSubscriptionsQuery query);
}
