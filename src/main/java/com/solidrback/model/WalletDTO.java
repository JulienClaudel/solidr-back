package com.solidrback.model;

import java.util.Objects;

public class WalletDTO {
    private int walletId;
    private String userEmail;
    private String walletBalanceSymbol;
    private String walletBalanceTotal;

    public WalletDTO() {
    }

    public WalletDTO(int walletId, String userEmail, String walletBalanceSymbol, String walletBalanceTotal) {
        this.walletId = walletId;
        this.userEmail = userEmail;
        this.walletBalanceSymbol = walletBalanceSymbol;
        this.walletBalanceTotal = walletBalanceTotal;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getWalletBalanceSymbol() {
        return walletBalanceSymbol;
    }

    public void setWalletBalanceSymbol(String walletBalanceSymbol) {
        this.walletBalanceSymbol = walletBalanceSymbol;
    }

    public String getWalletBalanceTotal() {
        return walletBalanceTotal;
    }

    public void setWalletBalanceTotal(String walletBalanceTotal) {
        this.walletBalanceTotal = walletBalanceTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WalletDTO)) return false;
        WalletDTO walletDTO = (WalletDTO) o;
        return walletId == walletDTO.walletId && Objects.equals(userEmail, walletDTO.userEmail) && Objects.equals(walletBalanceSymbol, walletDTO.walletBalanceSymbol) && Objects.equals(walletBalanceTotal, walletDTO.walletBalanceTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletId, userEmail, walletBalanceSymbol, walletBalanceTotal);
    }
}
