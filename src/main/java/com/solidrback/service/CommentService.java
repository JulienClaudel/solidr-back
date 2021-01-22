package com.solidrback.solidrback.service;

import com.solidrback.solidrback.model.CommentDTO;
import com.solidrback.solidrback.model.entity.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAllByStrategyId(int strategyId);

    List<CommentDTO> findAllComments();

    Comment save(Comment comment);
}
