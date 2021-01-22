package com.solidrback.configuration;

import com.solidrback.client.BinanceApiClientFactory;
import com.solidrback.client.BinanceApiRestClient;
import com.solidrback.client.domain.TimeInForce;
import com.solidrback.client.domain.account.NewOrderResponse;
import com.solidrback.client.domain.account.NewOrderResponseType;
import com.solidrback.client.domain.account.Order;
import com.solidrback.client.domain.account.request.*;
import com.solidrback.client.exception.BinanceApiException;

import java.util.List;

import static com.solidrback.client.domain.account.NewOrder.limitBuy;

public class CandleCollectClientFactory {

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("KEY", "SECRET");
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
        NewOrderResponse newOrderResponse = client.newOrder(limitBuy("BTCUSDT", TimeInForce.GTC, "10", "510.00000000").newOrderRespType(NewOrderResponseType.FULL));
        System.out.println(newOrderResponse);
    }

}

