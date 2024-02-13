package com.bhishma.app.payloads;

import com.bhishma.app.entities.Category;
import com.bhishma.app.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String Content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

    }

