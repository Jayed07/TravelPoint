package com.travelpoint.model.binding;

import com.travelpoint.model.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword"
)
public class UserRegistrationBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegistrationBindingModel() {
    }

    @NotEmpty(message = "Username cannot be empty.")
    @Size(min = 3, message = "Username must be minimum 3 characters long.")
    public String getUsername() {
        return username;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotEmpty(message = "Email cannot be empty.")
    @Email(message = "Invalid email.")
    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 5, max = 20, message = "Password must be between 3 and 20 characters long.")
    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotEmpty(message = "Password cannot be empty.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
