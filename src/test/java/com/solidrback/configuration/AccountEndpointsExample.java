package com.solidrback.configuration;

import com.solidrback.client.BinanceApiClientFactory;
import com.solidrback.client.BinanceApiRestClient;
import com.solidrback.client.domain.account.Account;
import com.solidrback.client.domain.account.Trade;

import java.util.List;

/**
 * Examples on how to get account information.
 */
public class AccountEndpointsExample {

  public static void main(String[] args) {
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("zQPGUczadeCjgdkmgkg6pz2HzuikG04GR1GHOD8D4Mrk3H32Gq2FgTSe3xxb1L0q", "m8Cb6PGYExkemoHiQogKBjz3et7QiydzMfBCzLE55UGUugqvK0UjHMUtF8DQiILq");
    BinanceApiRestClient client = factory.newRestClient();

    // Get account balances
    Account account = client.getAccount(60_000L, System.currentTimeMillis());
    System.out.println(account.getBalances());
    System.out.println(account.getAssetBalance("BTC"));

    // Get list of trades
    List<Trade> myTrades = client.getMyTrades("BTCUSDT");
    System.out.println(myTrades);

    // Get withdraw history
    System.out.println(client.getWithdrawHistory("BTC"));

    // Get deposit history
    System.out.println(client.getDepositHistory("BTC"));

    // Get deposit address
    System.out.println(client.getDepositAddress("BTC"));

    // Withdraw
    client.withdraw("BTC", "0x123", "0.1", null, null);
  }
}
