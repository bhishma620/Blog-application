package com.bhishma.app.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Table(name="categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "title")
    private String categoryTitle;

    @Column(name = "description",length = 100)
    private String categoryDescription;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> posts;
}
