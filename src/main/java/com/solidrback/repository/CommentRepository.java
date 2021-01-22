package com.solidrback.repository;

import com.solidrback.model.CommentDTO;
import com.solidrback.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT new com.solidrback.model.CommentDTO(" +
            "c.commentId, " +
            "c.strategyId, " +
            "c.statusId, " +
            "c.userEmail, " +
            "c.commentScore, " +
            "c.commentMemberIp, " +
            "c.commentDescription, " +
            "c.commentCreationDate, " +
            "c.commentUpdateDate) FROM Comment c  WHERE c.strategyId = ?1 ORDER BY c.commentCreationDate DESC")
    List<CommentDTO> findAllByStrategyId(int strategyId);

    @Query("SELECT new com.solidrback.model.CommentDTO(" +
            "c.commentId, " +
            "c.strategyId, " +
            "c.statusId, " +
            "c.userEmail, " +
            "c.commentScore, " +
            "c.commentMemberIp, " +
            "c.commentDescription, " +
            "c.commentCreationDate, " +
            "c.commentUpdateDate) FROM Comment c")
    List<CommentDTO> findAllComments();
}
