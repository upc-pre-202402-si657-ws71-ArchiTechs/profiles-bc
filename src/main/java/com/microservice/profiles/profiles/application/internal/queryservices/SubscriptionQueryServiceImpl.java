package com.microservice.profiles.profiles.application.internal.queryservices;

import com.microservice.profiles.profiles.domain.model.aggregates.Subscription;
import com.microservice.profiles.profiles.domain.model.queries.GetAllSubscriptionsQuery;
import com.microservice.profiles.profiles.domain.model.queries.GetSubscriptionByIdQuery;
import com.microservice.profiles.profiles.domain.services.SubscriptionQueryService;
import com.microservice.profiles.profiles.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByIdQuery query) {
        return subscriptionRepository.findById(query.subscriptionId());
    }

    @Override
    public List<Subscription> handle(GetAllSubscriptionsQuery query) {
        return subscriptionRepository.findAll();
    }
}
