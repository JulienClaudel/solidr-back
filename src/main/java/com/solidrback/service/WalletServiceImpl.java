package com.solidrback.service;


import com.solidrback.client.BinanceApiClientFactory;
import com.solidrback.client.BinanceApiRestClient;
import com.solidrback.client.domain.account.Account;
import com.solidrback.client.domain.account.AssetBalance;
import com.solidrback.model.entity.Wallet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {


    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("zQPGUczadeCjgdkmgkg6pz2HzuikG04GR1GHOD8D4Mrk3H32Gq2FgTSe3xxb1L0q", "m8Cb6PGYExkemoHiQogKBjz3et7QiydzMfBCzLE55UGUugqvK0UjHMUtF8DQiILq");
    BinanceApiRestClient client = factory.newRestClient();

    // Get account balances
    Account account = client.getAccount(60_000L, System.currentTimeMillis());

    @Override
    public List<AssetBalance> getBalances() {
        return account.getBalances();
    }

    @Override
    public AssetBalance getAssetBalance(String symbol) {
        return account.getAssetBalance(symbol);
    }

    @Override
    public List<Wallet> findAll() {
        return null;
    }

    @Override
    public List<Wallet> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Wallet> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Wallet> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Wallet wallet) {

    }

    @Override
    public void deleteAll(Iterable<? extends Wallet> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Wallet> S save(S s) {
        return null;
    }

    @Override
    public <S extends Wallet> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Wallet> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Wallet> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Wallet> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Wallet getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Wallet> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Wallet> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Wallet> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Wallet> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Wallet> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Wallet> boolean exists(Example<S> example) {
        return false;
    }
}
