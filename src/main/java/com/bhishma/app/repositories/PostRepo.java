package com.bhishma.app.repositories;

import com.bhishma.app.entities.Category;
import com.bhishma.app.entities.Post;
import com.bhishma.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);

}
