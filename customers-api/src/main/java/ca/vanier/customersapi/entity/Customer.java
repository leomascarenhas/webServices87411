package ca.vanier.customersapi.entity;

import ca.vanier.addresses.entity.CustomerAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(cascade=CascadeType.ALL)
    // import from new lib
    private List<CustomerAddress> addresses;

}
