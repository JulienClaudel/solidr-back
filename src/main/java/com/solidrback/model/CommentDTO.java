package com.solidrback.solidrback.model;

import java.time.LocalDate;
import java.util.Objects;

public class CommentDTO {
    private int commentId;
    private int strategyId;
    private int statusId;
    private String userEmail;
    private Integer commentScore;
    private String commentMemberIp;
    private String commentDescription;
    private LocalDate commentCreationDate;
    private LocalDate commentUpdateDate;

    public CommentDTO() {
    }

    public CommentDTO(int commentId, int strategyId, int statusId, String userEmail, Integer commentScore, String commentMemberIp, String commentDescription, LocalDate commentCreationDate, LocalDate commentUpdateDate) {
        this.commentId = commentId;
        this.strategyId = strategyId;
        this.statusId = statusId;
        this.userEmail = userEmail;
        this.commentScore = commentScore;
        this.commentMemberIp = commentMemberIp;
        this.commentDescription = commentDescription;
        this.commentCreationDate = commentCreationDate;
        this.commentUpdateDate = commentUpdateDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    public String getCommentMemberIp() {
        return commentMemberIp;
    }

    public void setCommentMemberIp(String commentMemberIp) {
        this.commentMemberIp = commentMemberIp;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    public LocalDate getCommentCreationDate() {
        return commentCreationDate;
    }

    public void setCommentCreationDate(LocalDate commentCreationDate) {
        this.commentCreationDate = commentCreationDate;
    }

    public LocalDate getCommentUpdateDate() {
        return commentUpdateDate;
    }

    public void setCommentUpdateDate(LocalDate commentUpdateDate) {
        this.commentUpdateDate = commentUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO that = (CommentDTO) o;
        return commentId == that.commentId && strategyId == that.strategyId && userEmail.equals(that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, strategyId, userEmail);
    }
}
