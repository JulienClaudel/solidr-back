package com.solidrback.solidrback.model;

import java.time.LocalDate;
import java.util.Objects;

public class UserSubscribeStratDTO {
    private int strategyId;
    private String userEmail;
    private double primeSolidr;
    private double primeExpert;
    private String amountAffect1;
    private String symbolAffect1;
    private String amountAffect2;
    private String symbolAffect2;
    private LocalDate subscribeStratStartLocalDate;
    private LocalDate subscribeStratEndLocalDate;
    private String strategyLabel;
    private String userUsername;

    public UserSubscribeStratDTO() {
    }

    public UserSubscribeStratDTO(int strategyId, String strategyLabel, String userEmail, String userUsername, double primeSolidr,
                                 double primeExpert, LocalDate subscribeStratStartLocalDate, LocalDate subscribeStratEndLocalDate,
                                 String amountAffect1, String symbolAffect1, String amountAffect2, String symbolAffect2) {
        this.strategyId = strategyId;
        this.strategyLabel = strategyLabel;
        this.userEmail = userEmail;
        this.userUsername = userUsername;
        this.primeSolidr = primeSolidr;
        this.primeExpert = primeExpert;
        this.subscribeStratStartLocalDate = subscribeStratStartLocalDate;
        this.subscribeStratEndLocalDate = subscribeStratEndLocalDate;
        this.amountAffect1 = amountAffect1;
        this.symbolAffect1 = symbolAffect1;
        this.amountAffect2 = amountAffect2;
        this.symbolAffect2 = symbolAffect2;
    }

    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getPrimeSolidr() {
        return primeSolidr;
    }

    public void setPrimeSolidr(double primeSolidr) {
        this.primeSolidr = primeSolidr;
    }

    public double getPrimeExpert() {
        return primeExpert;
    }

    public void setPrimeExpert(double primeExpert) {
        this.primeExpert = primeExpert;
    }

    public LocalDate getSubscribeStratStartLocalDate() {
        return subscribeStratStartLocalDate;
    }

    public void setSubscribeStratStartLocalDate(LocalDate subscribeStratStartLocalDate) {
        this.subscribeStratStartLocalDate = subscribeStratStartLocalDate;
    }

    public LocalDate getSubscribeStratEndLocalDate() {
        return subscribeStratEndLocalDate;
    }

    public void setSubscribeStratEndLocalDate(LocalDate subscribeStratEndLocalDate) {
        this.subscribeStratEndLocalDate = subscribeStratEndLocalDate;
    }

    public String getStrategyLabel() {
        return strategyLabel;
    }

    public void setStrategyLabel(String strategyLabel) {
        this.strategyLabel = strategyLabel;
    }

    public String getAmountAffect1() {
        return amountAffect1;
    }

    public void setAmountAffect1(String amountAffect1) {
        this.amountAffect1 = amountAffect1;
    }

    public String getSymbolAffect1() {
        return symbolAffect1;
    }

    public void setSymbolAffect1(String symbolAffect1) {
        this.symbolAffect1 = symbolAffect1;
    }

    public String getAmountAffect2() {
        return amountAffect2;
    }

    public void setAmountAffect2(String amountAffect2) {
        this.amountAffect2 = amountAffect2;
    }

    public String getSymbolAffect2() {
        return symbolAffect2;
    }

    public void setSymbolAffect2(String symbolAffect2) {
        this.symbolAffect2 = symbolAffect2;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSubscribeStratDTO that = (UserSubscribeStratDTO) o;
        return strategyId == that.strategyId && userEmail.equals(that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strategyId, userEmail);
    }
}
