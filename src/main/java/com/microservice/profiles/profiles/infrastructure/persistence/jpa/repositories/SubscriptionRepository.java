package com.microservice.profiles.profiles.infrastructure.persistence.jpa.repositories;

import com.microservice.profiles.profiles.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    @Override
    Optional<Subscription> findById(Long aLong);
}
