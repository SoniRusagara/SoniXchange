package com.soniXchange.service;

import com.soniXchange.model.Coin;
import com.soniXchange.model.User;
import com.soniXchange.model.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;
    Watchlist createWatchList(User user);
    Watchlist findById(Long id) throws Exception;
    Coin addItemToWatchlist(Coin coin, Us