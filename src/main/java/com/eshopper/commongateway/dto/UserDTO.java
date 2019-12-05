package com.eshopper.commongateway.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String password;
    private Boolean active;
    private Integer roleId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private Integer postalCode;
    private String email;
    private Integer phone1;
    private Integer phone2;
    private Date registrationDate;

    @Override
    public String toString() {
        return "UserDTO{" +
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