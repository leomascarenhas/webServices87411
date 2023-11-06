package ca.vanier.customersapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Customer {
    
    @Id
    @GeneratedValue
    @ToString.Exclude
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    // public Long getId() {
    //     return id;
    // }
    // public void setId(Long id) {
    //     this.id = id;
    // }
    // public String getFirstName() {
    //     return firstName;
    // }
    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }
    // public String getLastName() {
    //     return lastName;
    // }
    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }
    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }

}
