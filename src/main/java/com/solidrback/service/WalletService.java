package com.solidrback.service;

import com.solidrback.client.domain.account.AssetBalance;
import com.solidrback.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface WalletService extends JpaRepository<Wallet, Integer> {


    public List<AssetBalance> getBalances();

    public AssetBalance getAssetBalance(String symbol);
}
