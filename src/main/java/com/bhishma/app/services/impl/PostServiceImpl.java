package com.bhishma.app.services.impl;

import com.bhishma.app.entities.Category;
import com.bhishma.app.entities.Post;
import com.bhishma.app.entities.User;
import com.bhishma.app.exceptions.ResourceNotFoundException;
import com.bhishma.app.payloads.CategoryDto;
import com.bhishma.app.payloads.PostDto;
import com.bhishma.app.repositories.CategoryRepo;
import com.bhishma.app.repositories.PostRepo;
import com.bhishma.app.repositories.UserRepo;
import com.bhishma.app.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ","user id",userId));

        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","Category id",categoryId));

        Post post=this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post createdPost= this.postRepo.save(post);
        return this.modelMapper.map(createdPost,PostDto.class);

    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

     Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","post id",postId));

     post.setTitle(postDto.getTitle());
     post.setContent(postDto.getContent());
     post.setImageName(postDto.getImageName());

    Post updatedPost=  this.postRepo.save(post);

    return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","post id",postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {

        List<Post>posts=this.postRepo.findAll();

        List<PostDto>postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {

        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","post id",postId));

        PostDto postdto=this.modelMapper.map(post,PostDto.class);

        return postdto;

    }


    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","category id",categoryId));

     List<Post>posts=   this.postRepo.findByCategory(category);

     List<PostDto>postDtos=   posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ","user id",userId));

        List<Post>posts=   this.postRepo.findByUser(user);

        List<PostDto>postDtos=   posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {

        return null;
    }

}
