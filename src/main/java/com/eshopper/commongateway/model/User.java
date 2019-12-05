package com.eshopper.commongateway.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "active")
    @NonNull
    private Boolean active;

    @Column(name = "roleid")
    @NonNull
    private Integer roleId;

    @Column(name = "firstname")
    @NonNull
    private String firstName;

    @Column(name = "middlename")
    @NonNull
    private String middleName;

    @Column(name = "lastname")
    @NonNull
    private String lastName;

    @Column(name = "birthdate")
    @NonNull
    private Date birthdate;

    @Column(name = "address1")
    @NonNull
    private String address1;

    @Column(name = "address2")
    @NonNull
    private String address2;

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "state")
    @NonNull
    private String state;

    @Column(name = "country")
    @NonNull
    private String country;

    @Column(name = "postalcode")
    @NonNull
    private Integer postalCode;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "phone1")
    @NonNull
    private Integer phone1;

    @Column(name = "phone2")
    @NonNull
    private Integer phone2;

    @Column(name = "registrationdate")
    @NonNull
    private Date registrationDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roleId=" + roleId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                ", email='" + email + '\'' +
                ", phone1=" + phone1 +
                ", phone2=" + phone2 +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
