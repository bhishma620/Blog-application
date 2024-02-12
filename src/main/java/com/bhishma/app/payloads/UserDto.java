package com.bhishma.app.payloads;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;

    @NotEmpty
    @Size(min=4,message = "Username must be min of 4 characters!!")
    private String name;

    @Email(message = "Email address is not valid!!")
    private String email;

    @NotEmpty
    @Size(min=3,max=10,message = "Password must be between 3-10 characters")

    private String password;

    @NotEmpty
    private String about;
}
