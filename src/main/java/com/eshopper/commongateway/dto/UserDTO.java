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
}