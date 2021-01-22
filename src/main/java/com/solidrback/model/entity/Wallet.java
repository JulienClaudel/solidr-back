package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Wallet {
    private int walletId;
    private String userEmail;
    private String walletBalanceSymbol;
    private String walletBalanceTotal;
    private UserData userDataByUserEmail;
    private Collection<WalletHistory> walletHistoriesByWalletId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WALLET_ID", nullable = false, precision = 0)
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
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
    @Column(name = "WALLET_BALANCE_SYMBOL", nullable = true, length = 50)
    public String getWalletBalanceSymbol() {
        return walletBalanceSymbol;
    }

    public void setWalletBalanceSymbol(String walletBalanceSymbol) {
        this.walletBalanceSymbol = walletBalanceSymbol;
    }

    @Basic
    @Column(name = "WALLET_BALANCE_TOTAL", nullable = true, precision = 50)
    public String getWalletBalanceTotal() {
        return walletBalanceTotal;
    }

    public void setWalletBalanceTotal(String walletBalanceTotal) {
        this.walletBalanceTotal = walletBalanceTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (walletId != wallet.walletId) return false;
        if (userEmail != null ? !userEmail.equals(wallet.userEmail) : wallet.userEmail != null) return false;
        if (walletBalanceSymbol != null ? !walletBalanceSymbol.equals(wallet.walletBalanceSymbol) : wallet.walletBalanceSymbol != null)
            return false;
        if (walletBalanceTotal != null ? !walletBalanceTotal.equals(wallet.walletBalanceTotal) : wallet.walletBalanceTotal != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = walletId;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (walletBalanceSymbol != null ? walletBalanceSymbol.hashCode() : 0);
        result = 31 * result + (walletBalanceTotal != null ? walletBalanceTotal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "USER_EMAIL", nullable = false, insertable = false, updatable = false)
    public UserData getUserDataByUserEmail() {
        return userDataByUserEmail;
    }

    public void setUserDataByUserEmail(UserData userDataByUserEmail) {
        this.userDataByUserEmail = userDataByUserEmail;
    }

    @OneToMany(mappedBy = "walletByWalletId")
    public Collection<WalletHistory> getWalletHistoriesByWalletId() {
        return walletHistoriesByWalletId;
    }

    public void setWalletHistoriesByWalletId(Collection<WalletHistory> walletHistoriesByWalletId) {
        this.walletHistoriesByWalletId = walletHistoriesByWalletId;
    }
}
