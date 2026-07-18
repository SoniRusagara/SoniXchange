package com.soniXchange.service;

import java.util.List;

import com.soniXchange.model.Coin;

public interface CoinService {
    List<Coin> getCoinList(int page) throws Exception ;

    String getMarketChart(String coinId, int days);

    String getCoinDetails(String coinId);

    Coin findById(String coinId);

    String searchCoin(String keyword);

    String getTop50CoinsByMarketCapRank();

    String getTradingCoins();
}
