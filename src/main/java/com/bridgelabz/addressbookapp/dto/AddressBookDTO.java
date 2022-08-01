package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name is Invalid")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last name is Invalid")
    public String lastName;
    @Pattern(regexp ="(91-)?[0-9]{10}",message="Phone number is not valid")
    public String phoneNumber;

    @NotEmpty(message="email cannot be empty")
    public String email;
    @NotEmpty(message="address cannot be empty")
    public String address;
    @NotEmpty(message="city cannot be empty")
    public String city;
    @NotEmpty(message="state cannot be empty")
    public String state;
    @NotNull(message="zip cannot be empty")
    public int zip;

    public AddressBookDTO(String firstName, String lastName, String phoneNumber, String email,
                          String address, String city, String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
