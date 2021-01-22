package com.solidrback.solidrback.controller;

import com.solidrback.solidrback.model.CommentDTO;
import com.solidrback.solidrback.model.entity.Comment;
import com.solidrback.solidrback.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    /// Find all comments in the database
    @GetMapping("/")
    public List<CommentDTO> getAllComments() {
        return commentService.findAllComments();
    }

    /// Find all comments in the database by strategyId
    @GetMapping("/strategy/{id}")
    public List<CommentDTO> findAllByStrategyId(@PathVariable(value = "id") int strategyId) {
        return commentService.findAllByStrategyId(strategyId);
    }

    /// Create a new comment
    @PreAuthorize("hasRole('Member')")
    @PostMapping("/")
    public ResponseEntity<?> createSComment(@Valid @RequestBody Comment comment) {
        return ResponseEntity.ok().body(commentService.save(comment));
    }
}
