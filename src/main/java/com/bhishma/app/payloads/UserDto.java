package com.bhishma.app.payloads;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String about;
}
