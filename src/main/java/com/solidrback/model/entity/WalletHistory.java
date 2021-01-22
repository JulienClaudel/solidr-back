package com.solidrback.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "WALLET_HISTORY", schema = "dbo", catalog = "solidr")
public class WalletHistory {
    private int walletHistoryId;
    private int walletId;
    private LocalDate walletHistoryDate;
    private String walletHistorySymbol;
    private String walletHistoryTotal;
    private Wallet walletByWalletId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WALLET_HISTORY_ID", nullable = false, precision = 0)
    public int getWalletHistoryId() {
        return walletHistoryId;
    }

    public void setWalletHistoryId(int walletHistoryId) {
        this.walletHistoryId = walletHistoryId;
    }

    @Basic
    @Column(name = "WALLET_ID", nullable = false, precision = 0)
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    @Basic
    @Column(name = "WALLET_HISTORY_DATE", nullable = false)
    public LocalDate getWalletHistoryDate() {
        return walletHistoryDate;
    }

    public void setWalletHistoryDate(LocalDate walletHistoryDate) {
        this.walletHistoryDate = walletHistoryDate;
    }

    @Basic
    @Column(name = "WALLET_HISTORY_SYMBOL", nullable = true, length = 50)
    public String getWalletHistorySymbol() {
        return walletHistorySymbol;
    }

    public void setWalletHistorySymbol(String walletHistorySymbol) {
        this.walletHistorySymbol = walletHistorySymbol;
    }

    @Basic
    @Column(name = "WALLET_HISTORY_TOTAL", nullable = true, precision = 50)
    public String getWalletHistoryTotal() {
        return walletHistoryTotal;
    }

    public void setWalletHistoryTotal(String walletHistoryTotal) {
        this.walletHistoryTotal = walletHistoryTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletHistory that = (WalletHistory) o;
        return Objects.equals(walletHistoryId, that.walletHistoryId) &&
                Objects.equals(walletId, that.walletId) &&
                Objects.equals(walletHistoryDate, that.walletHistoryDate) &&
                Objects.equals(walletHistorySymbol, that.walletHistorySymbol) &&
                Objects.equals(walletHistoryTotal, that.walletHistoryTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletHistoryId, walletId, walletHistoryDate, walletHistorySymbol, walletHistoryTotal);
    }

    @ManyToOne
    @JoinColumn(name = "WALLET_ID", referencedColumnName = "WALLET_ID", nullable = false, insertable = false, updatable = false)
    public Wallet getWalletByWalletId() {
        return walletByWalletId;
    }

    public void setWalletByWalletId(Wallet walletByWalletId) {
        this.walletByWalletId = walletByWalletId;
    }
}
