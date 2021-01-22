package com.solidrback.repository;

import com.solidrback.model.WalletDTO;
import com.solidrback.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface WalletRepository extends JpaRepository <Wallet, Integer> {
    @Query("SELECT new com.solidrback.model.WalletDTO(" +
            "w.walletId, " +
            "w.userEmail, " +
            "w.walletBalanceSymbol, " +
            "w.walletBalanceTotal) FROM Wallet w  WHERE w.userEmail = ?1")
    Optional<WalletDTO> findByUserEmail(String userEmail);

//    @Query("SELECT new com.solidrback.model.WalletDTO(" +
//            "w.walletId, " +
//            "w.userEmail, " +
//            "w.walletBalanceSymbol, " +
//            "w.walletBalanceTotal) FROM Wallet w  WHERE w.userEmail = ?1")
//    List<WalletDTO> findAllByUserEmail(String userEmail);
}
