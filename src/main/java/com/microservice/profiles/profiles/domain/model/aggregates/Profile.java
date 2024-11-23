package com.microservice.profiles.profiles.domain.model.aggregates;

import jakarta.persistence.*;
import java.util.Date;
import com.microservice.profiles.profiles.domain.model.commands.CreateProfileCommand;
import com.microservice.profiles.profiles.domain.model.valueobjects.EmailAddress;
import com.microservice.profiles.profiles.domain.model.valueobjects.PersonName;
import com.microservice.profiles.profiles.domain.model.valueobjects.StreetAddress;
import com.microservice.profiles.profiles.domain.model.valueobjects.Username;
import com.microservice.profiles.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

  @Embedded
  private PersonName name;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
  EmailAddress email;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "username", column = @Column(name = "username"))})
  Username username;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "street", column = @Column(name = "address_street")),
          @AttributeOverride(name = "number", column = @Column(name = "address_number")),
          @AttributeOverride(name = "city", column = @Column(name = "address_city")),
          @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
          @AttributeOverride(name = "country", column = @Column(name = "address_country"))})
  private StreetAddress address;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  public Profile(String firstName, String lastName, String username, String email, String street, String number, String city, String postalCode, String country) {
    this.name = new PersonName(firstName, lastName);
    this.username = new Username(username);
    this.email = new EmailAddress(email);
    this.address = new StreetAddress(street, number, city, postalCode, country);
  }

  public Profile(CreateProfileCommand command) {
    this.name = new PersonName(command.firstName(), command.lastName());
    this.username = new Username(command.username());
    this.email = new EmailAddress(command.email());
    this.address = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
  }

  public Profile() {
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
    this.updatedAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public void updateName(String firstName, String lastName) {
    this.name = new PersonName(firstName, lastName);
  }

  public void updateEmail(String email) {
    this.email = new EmailAddress(email);
  }

  public void updateAddress(String street, String number, String city, String postalCode, String country) {
    this.address = new StreetAddress(street, number, city, postalCode, country);
  }

  public String getFullName() {
    return name.getFullName();
  }

  public String getEmailAddress() {
    return email.address();
  }

  public String getStreetAddress() {
    return address.getStreetAddress();
  }
}