package com.project.finals;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsersDTO {

    Integer Id;

    @NotBlank(message = "Enter your first name")
    String firstName;

    @NotBlank(message = "Enter your last name")
    String lastName;

    @NotBlank(message = "Enter your email")
    @Email(message = "Invalid email format")
    String email;

    String phone;

    @NotBlank(message = "Enter you full address")
    String address;


    public UsersDTO() {}
    public UsersDTO(Integer Id, String firstName, String lastName, String email, String phone, String address) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
