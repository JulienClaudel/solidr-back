package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "USER_SUBSCRIBE_STRAT", schema = "dbo", catalog = "solidr")
@IdClass(UserSubscribeStratPK.class)
public class UserSubscribeStrat {
    private int strategyId;
    private String userEmail;
    private double primeSolidr;
    private double primeExpert;
    private LocalDate subscribeStratStartDate;
    private LocalDate subscribeStratEndDate;
    private String amountAffect1;
    private String symbolAffect1;
    private String amountAffect2;
    private String symbolAffect2;
    private Strategy strategyByStrategyId;
    private UserData userDataByUserEmail;

    @Id
    @Column(name = "STRATEGY_ID", nullable = false, precision = 0)
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    @Id
    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "PRIME_SOLIDR", nullable = false, precision = 0)
    public double getPrimeSolidr() {
        return primeSolidr;
    }

    public void setPrimeSolidr(double primeSolidr) {
        this.primeSolidr = primeSolidr;
    }

    @Basic
    @Column(name = "PRIME_EXPERT", nullable = false, precision = 0)
    public double getPrimeExpert() {
        return primeExpert;
    }

    public void setPrimeExpert(double primeExpert) {
        this.primeExpert = primeExpert;
    }

    @Basic
    @Column(name = "SUBSCRIBE_STRAT_START_DATE", nullable = false)
    public LocalDate getSubscribeStratStartDate() {
        return subscribeStratStartDate;
    }

    public void setSubscribeStratStartDate(LocalDate subscribeStratStartDate) {
        this.subscribeStratStartDate = subscribeStratStartDate;
    }

    @Basic
    @Column(name = "SUBSCRIBE_STRAT_END_DATE", nullable = true)
    public LocalDate getSubscribeStratEndDate() {
        return subscribeStratEndDate;
    }

    public void setSubscribeStratEndDate(LocalDate subscribeStratEndDate) {
        this.subscribeStratEndDate = subscribeStratEndDate;
    }

    @Basic
    @Column(name = "AMOUNT_AFFECT1", nullable = true)
    public String getAmountAffect1() {
        return amountAffect1;
    }

    public void setAmountAffect1(String amountAffect1) {
        this.amountAffect1 = amountAffect1;
    }

    @Basic
    @Column(name = "SYMBOL_AFFECT1", nullable = true)
    public String getSymbolAffect1() {
        return symbolAffect1;
    }

    public void setSymbolAffect1(String symbolAffect1) {
        this.symbolAffect1 = symbolAffect1;
    }

    @Basic
    @Column(name = "AMOUNT_AFFECT2", nullable = true)
    public String getAmountAffect2() {
        return amountAffect2;
    }

    public void setAmountAffect2(String amountAffect2) {
        this.amountAffect2 = amountAffect2;
    }

    @Basic
    @Column(name = "SYMBOL_AFFECT2", nullable = true)
    public String getSymbolAffect2() {
        return symbolAffect2;
    }

    public void setSymbolAffect2(String symbolAffect2) {
        this.symbolAffect2 = symbolAffect2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSubscribeStrat that = (UserSubscribeStrat) o;
        return Objects.equals(strategyId, that.strategyId) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(primeSolidr, that.primeSolidr) &&
                Objects.equals(primeExpert, that.primeExpert) &&
                Objects.equals(subscribeStratStartDate, that.subscribeStratStartDate) &&
                Objects.equals(subscribeStratEndDate, that.subscribeStratEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strategyId, userEmail, primeSolidr, primeExpert, subscribeStratStartDate, subscribeStratEndDate);
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
    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "USER_EMAIL", nullable = false, insertable = false, updatable = false)
    public UserData getUserDataByUserEmail() {
        return userDataByUserEmail;
    }

    public void setUserDataByUserEmail(UserData userDataByUserEmail) {
        this.userDataByUserEmail = userDataByUserEmail;
    }
}
