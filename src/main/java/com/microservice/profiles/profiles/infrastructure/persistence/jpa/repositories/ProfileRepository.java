package com.microservice.profiles.profiles.infrastructure.persistence.jpa.repositories;

import com.microservice.profiles.profiles.domain.model.valueobjects.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservice.profiles.profiles.domain.model.aggregates.Profile;
import com.microservice.profiles.profiles.domain.model.valueobjects.EmailAddress;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
  Optional<Profile> findByEmail(EmailAddress emailAddress);
  Optional<Profile> findByUsername(Username username);
}
