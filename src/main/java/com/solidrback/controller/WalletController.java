package com.solidrback.controller;

import com.solidrback.client.domain.account.AssetBalance;
import com.solidrback.exception.ResourceNotFoundException;
import com.solidrback.model.WalletDTO;
import com.solidrback.model.entity.Wallet;
import com.solidrback.repository.WalletRepository;
import com.solidrback.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    WalletService walletService;

    @Autowired
    private WalletRepository walletRepository;

    // Get all wallets from database
    @GetMapping("/")
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    // Get all wallets from Binance
    @GetMapping("/binancewallet")
    public List<AssetBalance> getBinanceBalances() {
        return walletService.getBalances();
    }

    // Find one by id
    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWalletbyId(@PathVariable(value = "id") int walletId) throws ResourceNotFoundException {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new ResourceNotFoundException("Wallet not found for this id::" + walletId));
        return ResponseEntity.ok().body(wallet);
    }

    // Find wallet by Email
    @GetMapping("/wallet/{email}")
    public ResponseEntity<WalletDTO> findByUserEmail(@PathVariable(value = "email") String userEmail) throws ResourceNotFoundException {
        WalletDTO wallet = walletRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found ::" + userEmail));
        return ResponseEntity.ok().body(wallet);
    }
//    @GetMapping("/wallet/{email}")
//    public List<WalletDTO> findAllByUserEmail(@PathVariable(value = "email") String userEmail) {
//        List<WalletDTO> wallets = walletService.findAllWalletByUserEmail(userEmail);
//        return wallets;
//    }

    @PostMapping("/")
    public Wallet createWallet(@Valid @RequestBody Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable(value = "id") int walletId, @Valid @RequestBody Wallet walletDetails) throws ResourceNotFoundException {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow( () -> new ResourceNotFoundException("Wallet not found for this id::" + walletId));

        wallet.setWalletBalanceTotal(wallet.getWalletBalanceTotal());
        final Wallet updateWallet = walletRepository.save(wallet);
        return ResponseEntity.ok(updateWallet);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteWallet(@PathVariable( value = "id") int walletId) throws ResourceNotFoundException {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new ResourceNotFoundException("Wallet not found for this id::" + walletId));

        walletRepository.delete(wallet);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
