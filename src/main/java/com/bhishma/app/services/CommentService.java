package com.bhishma.app.services;

import com.bhishma.app.entities.Comment;
import com.bhishma.app.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentID);
}
