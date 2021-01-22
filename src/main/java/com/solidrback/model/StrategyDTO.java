package com.solidrback.model;

import java.time.LocalDate;
import java.util.Objects;

public class StrategyDTO {
    private int strategyId;
    private String userEmail;
    private int statusId;
    private String strategyLabel;
    private String strategyDescription;
    private String strategySymbol1;
    private String strategySymbol2;
    private LocalDate strategyCreationDate;
    private LocalDate strategyUpdateDate;
    private String strategyPrime;
    private String strategyIcon;
    private String strategyProfitability;

    public StrategyDTO() {
    }

    public StrategyDTO(int strategyId, String userEmail, int statusId, String strategyLabel, String strategyDescription, String strategySymbol1, String strategySymbol2, String strategyPrime, LocalDate strategyCreationDate, LocalDate strategyUpdateDate, String strategyIcon, String strategyProfitability) {
        this.strategyId = strategyId;
        this.userEmail = userEmail;
        this.statusId = statusId;
        this.strategyLabel = strategyLabel;
        this.strategyDescription = strategyDescription;
        this.strategySymbol1 = strategySymbol1;
        this.strategySymbol2 = strategySymbol2;
        this.strategyCreationDate = strategyCreationDate;
        this.strategyUpdateDate = strategyUpdateDate;
        this.strategyPrime = strategyPrime;
        this.strategyIcon = strategyIcon;
        this.strategyProfitability = strategyProfitability;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStrategyLabel() {
        return strategyLabel;
    }

    public void setStrategyLabel(String strategyLabel) {
        this.strategyLabel = strategyLabel;
    }

    public String getStrategyDescription() {
        return strategyDescription;
    }

    public void setStrategyDescription(String strategyDescription) {
        this.strategyDescription = strategyDescription;
    }

    public String getStrategySymbol1() {
        return strategySymbol1;
    }

    public void setStrategySymbol1(String strategySymbol1) {
        this.strategySymbol1 = strategySymbol1;
    }

    public String getStrategySymbol2() {
        return strategySymbol2;
    }

    public void setStrategySymbol2(String strategySymbol2) {
        this.strategySymbol1 = strategySymbol2;
    }

    public LocalDate getStrategyCreationDate() {
        return strategyCreationDate;
    }

    public void setStrategyCreationDate(LocalDate strategyCreationDate) {
        this.strategyCreationDate = strategyCreationDate;
    }

    public LocalDate getStrategyUpdateDate() {
        return strategyUpdateDate;
    }

    public void setStrategyUpdateDate(LocalDate strategyUpdateDate) {
        this.strategyUpdateDate = strategyUpdateDate;
    }

    public String getStrategyPrime() {
        return strategyPrime;
    }

    public void setStrategyPrime(String strategyPrime) {
        this.strategyPrime = strategyPrime;
    }

    public String getStrategyIcon() {
        return strategyIcon;
    }

    public void setStrategyIcon(String strategyIcon) {
        this.strategyIcon = strategyIcon;
    }

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
        StrategyDTO that = (StrategyDTO) o;
        return Objects.equals(strategyId, that.strategyId) &&
                Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strategyId, userEmail);
    }
}
