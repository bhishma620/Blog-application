package com.bhishma.app.controllers;

import com.bhishma.app.payloads.ApiResponse;
import com.bhishma.app.payloads.CommentDto;
import com.bhishma.app.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CommentController {

    @Autowired
    CommentService commentService;

    //create comments

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){

       CommentDto createdComment= this.commentService.createComment(commentDto,postId);

       return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);

    }


    //delete comment
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse>createComment(@PathVariable Integer commentId){

      this.commentService.deleteComment(commentId);

        return new ResponseEntity<>(new ApiResponse("Comment Deleted Successfully",true),HttpStatus.OK);

    }


}
