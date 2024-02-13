package com.bhishma.app.services.impl;

import com.bhishma.app.entities.Comment;
import com.bhishma.app.entities.Post;
import com.bhishma.app.exceptions.ResourceNotFoundException;
import com.bhishma.app.payloads.CommentDto;
import com.bhishma.app.repositories.CommentRepo;
import com.bhishma.app.repositories.PostRepo;
import com.bhishma.app.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
  private   CommentRepo commentRepo;

  @Autowired
  private PostRepo postRepo;

  @Autowired
  private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","post id",postId));

        Comment comment=this.modelMapper.map(commentDto,Comment.class);

        comment.setPost(post);

        Comment savedComment=this.commentRepo.save(comment);
        return this.modelMapper.map(comment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentID) {

        Comment comment=this.commentRepo.findById(commentID).orElseThrow(()->new ResourceNotFoundException("Comment ","comment id",commentID));

        this.commentRepo.delete(comment);
    }
}
