package com.bhishma.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(length = 10000)
    private String content;

    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade=CascadeType.ALL)
    private Set<Comment> comments=new HashSet<>();

}
