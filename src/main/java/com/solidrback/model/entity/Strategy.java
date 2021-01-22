package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Strategy {
    private int strategyId;
    private String userEmail;
    private int statusId;
    private String strategyLabel;
    private String strategyDescription;
    private String strategySymbol1;
    private String strategySymbol2;
    private String strategyPrime;
    private LocalDate strategyCreationDate;
    private LocalDate strategyUpdateDate;
    private String strategyIcon;
    private String strategyProfitability;
    private Collection<Comment> commentsByStrategyId;
    private UserData userDataByUserEmail;
    private Status statusByStatusId;
    private Collection<UserSubscribeStrat> userSubscribeStratsByStrategyId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STRATEGY_ID", nullable = false, precision = 0)
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
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
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "STRATEGY_LABEL", nullable = false, length = 50)
    public String getStrategyLabel() {
        return strategyLabel;
    }

    public void setStrategyLabel(String strategyLabel) {
        this.strategyLabel = strategyLabel;
    }

    @Basic
    @Column(name = "STRATEGY_DESCRIPTION", nullable = true)
    public String getStrategyDescription() {
        return strategyDescription;
    }

    public void setStrategyDescription(String strategyDescription) {
        this.strategyDescription = strategyDescription;
    }

    @Basic
    @Column(name = "STRATEGY_SYMBOL1", nullable = true, length = 50)
    public String getStrategySymbol1() {
        return strategySymbol1;
    }

    public void setStrategySymbol1(String strategySymbol1) {
        this.strategySymbol1 = strategySymbol1;
    }

    @Basic
    @Column(name = "STRATEGY_SYMBOL2", nullable = true, length = 50)
    public String getStrategySymbol2() {
        return strategySymbol2;
    }

    public void setStrategySymbol2(String strategySymbol2) {
        this.strategySymbol2 = strategySymbol2;
    }

    @Basic
    @Column(name = "STRATEGY_PRIME", nullable = true, precision = 50)
    public String getStrategyPrime() {
        return strategyPrime;
    }

    public void setStrategyPrime(String strategyPrime) {
        this.strategyPrime = strategyPrime;
    }

    @Basic
    @Column(name = "STRATEGY_CREATION_DATE", nullable = false)
    public LocalDate getStrategyCreationDate() {
        return strategyCreationDate;
    }

    public void setStrategyCreationDate(LocalDate strategyCreationDate) {
        this.strategyCreationDate = strategyCreationDate;
    }

    @Basic
    @Column(name = "STRATEGY_UPDATE_DATE", nullable = false)
    public LocalDate getStrategyUpdateDate() {
        return strategyUpdateDate;
    }

    public void setStrategyUpdateDate(LocalDate strategyUpdateDate) {
        this.strategyUpdateDate = strategyUpdateDate;
    }

    @Basic
    @Column(name = "STRATEGY_ICON", nullable = true)
    public String getStrategyIcon() {
        return strategyIcon;
    }

    public void setStrategyIcon(String strategyIcon) {
        this.strategyIcon = strategyIcon;
    }

    @Basic
    @Column(name = "STRATEGY_PROFITABILITY", nullable = true)
    public String getStrategyProfitability() {
        return strategyProfitability;
    }

    public void setStrategyProfitability(String strategyProfitability) {
        this.strategyProfitability = strategyProfitability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Strategy strategy = (Strategy) o;
        return Objects.equals(strategyId, strategy.strategyId) &&
                Objects.equals(userEmail, strategy.userEmail) &&
                Objects.equals(statusId, strategy.statusId) &&
                Objects.equals(strategyLabel, strategy.strategyLabel) &&
                Objects.equals(strategyDescription, strategy.strategyDescription) &&
                Objects.equals(strategySymbol1, strategy.strategySymbol1) &&
                Objects.equals(strategySymbol2, strategy.strategySymbol2) &&
                Objects.equals(strategyCreationDate, strategy.strategyCreationDate) &&
                Objects.equals(strategyUpdateDate, strategy.strategyUpdateDate) &&
                Objects.equals(strategyPrime, strategy.strategyPrime) &&
                Objects.equals(strategyIcon, strategy.strategyIcon) &&
                Objects.equals(strategyProfitability, strategy.strategyProfitability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strategyId, userEmail, statusId, strategyLabel, strategyDescription, strategySymbol1, strategySymbol2, strategyCreationDate, strategyUpdateDate, strategyPrime, strategyIcon, strategyProfitability);
    }

    @OneToMany(mappedBy = "strategyByStrategyId")
    public Collection<Comment> getCommentsByStrategyId() {
        return commentsByStrategyId;
    }

    public void setCommentsByStrategyId(Collection<Comment> commentsByStrategyId) {
        this.commentsByStrategyId = commentsByStrategyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "USER_EMAIL", nullable = false, insertable = false, updatable = false)
    public UserData getUserDataByUserEmail() {
        return userDataByUserEmail;
    }

    public void setUserDataByUserEmail(UserData userDataByUserEmail) {
        this.userDataByUserEmail = userDataByUserEmail;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false, insertable = false, updatable = false)
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @OneToMany(mappedBy = "strategyByStrategyId")
    public Collection<UserSubscribeStrat> getUserSubscribeStratsByStrategyId() {
        return userSubscribeStratsByStrategyId;
    }

    public void setUserSubscribeStratsByStrategyId(Collection<UserSubscribeStrat> userSubscribeStratsByStrategyId) {
        this.userSubscribeStratsByStrategyId = userSubscribeStratsByStrategyId;
    }
}
