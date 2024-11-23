package com.microservice.profiles.profiles.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.microservice.profiles.profiles.domain.model.valueobjects.NameSubsCription;
import com.microservice.profiles.shared.domain.model.entities.AuditableModel;

@Getter
@Setter
@Entity
public class Subscription extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "subscriptionName", column = @Column(name = "name"))
    private NameSubsCription nameSubscription;
    private String description;
    private Double price;
    public Subscription() {
    }
    public Subscription(String nameSubscription, String description, Double price) {
        this.nameSubscription = new NameSubsCription(nameSubscription);
        this.description = description;
        this.price = price;

    }
}
