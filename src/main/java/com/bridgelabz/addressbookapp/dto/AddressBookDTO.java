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
    @Pattern(regexp = "[0-9]{10}", message = "Invalid Phone number")
    public String phoneNumber;

    @Pattern(regexp = "[a-zA-Z0-9]+[.+-]{0,1}[0-9a-zA-Z]*@[a-z0-9]+[.][a-z]{2,4}[.a-z]{0,4}", message = "Invalid Email")
    public String email;
    @NotEmpty(message="address cannot be empty")
    public String address;
    @NotEmpty(message="city cannot be empty")
    public String city;
    @NotEmpty(message="state cannot be empty")
    public String state;
    @NotNull(message = "zip cannot be null")
    public int zip;

}
