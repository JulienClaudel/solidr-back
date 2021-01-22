package com.solidrback.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Comment {
    private int commentId;
    private int strategyId;
    private int statusId;
    private String userEmail;
    private Integer commentScore;
    private String commentMemberIp;
    private String commentDescription;
    private LocalDate commentCreationDate;
    private LocalDate commentUpdateDate;
    private Strategy strategyByStrategyId;
    private Status statusByStatusId;
    private UserData userDataByUserEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", nullable = false, precision = 0)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "STRATEGY_ID", nullable = false, precision = 0)
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    @Basic
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "COMMENT_SCORE", nullable = true)
    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    @Basic
    @Column(name = "COMMENT_MEMBER_IP", nullable = false, length = 50)
    public String getCommentMemberIp() {
        return commentMemberIp;
    }

    public void setCommentMemberIp(String commentMemberIp) {
        this.commentMemberIp = commentMemberIp;
    }

    @Basic
    @Column(name = "COMMENT_DESCRIPTION", nullable = true, length = 200)
    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    @Basic
    @Column(name = "COMMENT_CREATION_DATE", nullable = false)
    public LocalDate getCommentCreationDate() {
        return commentCreationDate;
    }

    public void setCommentCreationDate(LocalDate commentCreationDate) {
        this.commentCreationDate = commentCreationDate;
    }

    @Basic
    @Column(name = "COMMENT_UPDATE_DATE", nullable = false)
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
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) &&
                Objects.equals(strategyId, comment.strategyId) &&
                Objects.equals(statusId, comment.statusId) &&
                Objects.equals(userEmail, comment.userEmail) &&
                Objects.equals(commentScore, comment.commentScore) &&
                Objects.equals(commentMemberIp, comment.commentMemberIp) &&
                Objects.equals(commentDescription, comment.commentDescription) &&
                Objects.equals(commentCreationDate, comment.commentCreationDate) &&
                Objects.equals(commentUpdateDate, comment.commentUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, strategyId, statusId, userEmail, commentScore, commentMemberIp, commentDescription, commentCreationDate, commentUpdateDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STRATEGY_ID", referencedColumnName = "STRATEGY_ID", nullable = false, insertable = false, updatable = false)
    public Strategy getStrategyByStrategyId() {
        return strategyByStrategyId;
    }

    public void setStrategyByStrategyId(Strategy strategyByStrategyId) {
        this.strategyByStrategyId = strategyByStrategyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false, insertable = false, updatable = false)
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "USER_EMAIL", nullable = false, insertable = false, updatable = false)
    public UserData getUserDataByUserEmail() {
        return userDataByUserEmail;
    }

    public void setUserDataByUserEmail(UserData userDataByUserEmail) {
        this.userDataByUserEmail = userDataByUserEmail;
    }
}
