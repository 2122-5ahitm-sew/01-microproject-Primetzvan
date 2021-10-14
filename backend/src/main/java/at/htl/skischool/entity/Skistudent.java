package at.htl.skischool.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class Skistudent extends Person {

  @JsonbProperty("registration_date")
  @JsonbDateFormat("yyyy-MM-dd")
  public Instant registrationDate;

  public Skistudent(String firstname, String lastname, int age) {
    super(firstname, lastname, age);
    this.registrationDate = Instant.now();
  }

  public Skistudent(Long id, String firstname, String lastname, int age) {
    super(id, firstname, lastname, age);
    this.registrationDate = Instant.now();
  }

  public Skistudent() {
  }

  public Instant getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Instant registrationDate) {
    this.registrationDate = registrationDate;
  }

  @Override
  public String toString() {
    return "Person mit der " +
      "id " + super.getId() + '\'' +
      ", namens " + super.getFirstname() +
      " " + super.getLastname() +
      ", mit dem alter " + super.getAge() +
      "\n";
  }

}
