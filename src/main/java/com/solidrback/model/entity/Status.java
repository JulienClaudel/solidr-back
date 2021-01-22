package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Status {
    private int statusId;
    private String statusLabel;
    private String statusDescription;
    private Collection<Comment> commentsByStatusId;
    private Collection<Strategy> strategiesByStatusId;
    private Collection<Trade> tradesByStatusId;
    private Collection<UserData> userDataByStatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "STATUS_LABEL", nullable = false, length = 50)
    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Basic
    @Column(name = "STATUS_DESCRIPTION", nullable = false, length = 100)
    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (statusId != status.statusId) return false;
        if (statusLabel != null ? !statusLabel.equals(status.statusLabel) : status.statusLabel != null) return false;
        if (statusDescription != null ? !statusDescription.equals(status.statusDescription) : status.statusDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (statusLabel != null ? statusLabel.hashCode() : 0);
        result = 31 * result + (statusDescription != null ? statusDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<Comment> getCommentsByStatusId() {
        return commentsByStatusId;
    }

    public void setCommentsByStatusId(Collection<Comment> commentsByStatusId) {
        this.commentsByStatusId = commentsByStatusId;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<Strategy> getStrategiesByStatusId() {
        return strategiesByStatusId;
    }

    public void setStrategiesByStatusId(Collection<Strategy> strategiesByStatusId) {
        this.strategiesByStatusId = strategiesByStatusId;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<Trade> getTradesByStatusId() {
        return tradesByStatusId;
    }

    public void setTradesByStatusId(Collection<Trade> tradesByStatusId) {
        this.tradesByStatusId = tradesByStatusId;
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<UserData> getUserDataByStatusId() {
        return userDataByStatusId;
    }

    public void setUserDataByStatusId(Collection<UserData> userDataByStatusId) {
        this.userDataByStatusId = userDataByStatusId;
    }
}
