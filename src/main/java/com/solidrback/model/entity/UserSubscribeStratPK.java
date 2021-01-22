package com.solidrback.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserSubscribeStratPK implements Serializable {
    private int strategyId;
    private String userEmail;

    @Column(name = "STRATEGY_ID", nullable = false, precision = 0)
    @Id
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    @Id
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSubscribeStratPK that = (UserSubscribeStratPK) o;
        return Objects.equals(strategyId, that.strategyId) &&
                Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strategyId, userEmail);
    }
}
