package com.solidrback.service;

import com.solidrback.model.CommentDTO;
import com.solidrback.model.entity.Comment;
import com.solidrback.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<CommentDTO> findAllByStrategyId(int strategyId) {
        return commentRepository.findAllByStrategyId(strategyId);
    }

    @Override
    public List<CommentDTO> findAllComments() {
        return commentRepository.findAllComments();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
