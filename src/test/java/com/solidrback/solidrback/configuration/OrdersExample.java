package com.solidrback.solidrback.configuration;

import com.solidrback.solidrback.client.BinanceApiClientFactory;
import com.solidrback.solidrback.client.BinanceApiRestClient;
import com.solidrback.solidrback.client.domain.TimeInForce;
import com.solidrback.solidrback.client.domain.account.NewOrderResponse;
import com.solidrback.solidrback.client.domain.account.NewOrderResponseType;
import com.solidrback.solidrback.client.domain.account.Order;
import com.solidrback.solidrback.client.domain.account.request.*;
import com.solidrback.solidrback.client.exception.BinanceApiException;

import java.util.List;

import static com.solidrback.solidrback.client.domain.account.NewOrder.limitBuy;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class OrdersExample {

  public static void main(String[] args) {
    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("zQPGUczadeCjgdkmgkg6pz2HzuikG04GR1GHOD8D4Mrk3H32Gq2FgTSe3xxb1L0q", "m8Cb6PGYExkemoHiQogKBjz3et7QiydzMfBCzLE55UGUugqvK0UjHMUtF8DQiILq");
    BinanceApiRestClient client = factory.newRestClient();

    // Getting list of open orders
    List<Order> openOrders = client.getOpenOrders(new OrderRequest("BTCUSDT"));
    System.out.println("Open orders list : " + openOrders);

    // Getting list of all orders with a limit of 10
    List<Order> allOrders = client.getAllOrders(new AllOrdersRequest("BTCUSDT").limit(10));
    System.out.println("orders list with limit 10 : " +allOrders);

    // Get status of a particular order
    Order order = client.getOrderStatus(new OrderStatusRequest("BTCUSDT", 352629L));
    System.out.println("status of the order N°352629L : " +order);

    // Canceling an order
    try {
      CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest("BTCUSDT", 352629L));
      System.out.println("trying to cancel the order N°352629L : " + cancelOrderResponse);
    } catch (BinanceApiException e) {
      System.out.println("trying to cancel the order N°352629L : " + e.getError().getMsg());
    }
    /*
    // Placing a test LIMIT order
    client.newOrderTest(limitBuy("BTCUSDT", TimeInForce.GTC, "1000", "40000.00000000"));

    // Placing a test MARKET order -- update
    client.newOrderTest(marketBuy("BTCUSDT", "1000"));*/

    // Placing a real LIMIT order
    NewOrderResponse newOrderResponse = client.newOrder(limitBuy("BTCUSDT", TimeInForce.GTC, "0.01", "9000.00000000").newOrderRespType(NewOrderResponseType.FULL));
    System.out.println(newOrderResponse);
  }

}
