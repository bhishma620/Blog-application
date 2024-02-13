package com.bhishma.app.controllers;


import com.bhishma.app.config.Appconstant;
import com.bhishma.app.entities.Post;
import com.bhishma.app.payloads.ApiResponse;
import com.bhishma.app.payloads.PostDto;
import com.bhishma.app.payloads.PostResponse;
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

    //create post

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
    PostDto createdPost=this.postService.createPost(postDto,userId,categoryId);

    return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }


    //get allPost of a userid
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){

        List<PostDto> postDtos=this.postService.getPostByUser(userId);

        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);

    }


    //get all posts of a category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){

        List<PostDto> postDtos=this.postService.getPostByCategory(categoryId);

        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);

    }


    //get all posts

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value="pageNumber",defaultValue = Appconstant.PAGE_NUMBER,required = false)Integer pageNumber,
            @RequestParam(value="pageSize",defaultValue = Appconstant.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(value="sortBy",defaultValue = Appconstant.SORT_BY,required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = Appconstant.SORT_DIR,required = false)String sortDir){
        PostResponse posts=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);

        return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);

    }

    //get a single post

    @GetMapping("/posts/{postId}")

    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
       PostDto post=this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(post,HttpStatus.OK);
    }


    //delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
      return new ApiResponse("Post Deleted Successfully",true);
    }


    //update post

    @PutMapping ("posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto ,@PathVariable Integer postId){
        PostDto post=this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(post,HttpStatus.OK);
    }

    //search
    @GetMapping("posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> seachPostByTitle(@PathVariable String keywords){

        List<PostDto>postDtos=this.postService.searchPosts(keywords);

        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
    }

}
