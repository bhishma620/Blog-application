package com.bhishma.app.controllers;

import com.bhishma.app.entities.Post;
import com.bhishma.app.payloads.PostDto;
import com.bhishma.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")

public class PostController {


    @Autowired
    PostService postService;

    //create

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
    PostDto createdPost=this.postService.createPost(postDto,userId,categoryId);

    return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }


    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){

        List<PostDto> postDtos=this.postService.getPostByUser(userId);

        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);

    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){

        List<PostDto> postDtos=this.postService.getPostByCategory(categoryId);

        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);

    }

}
