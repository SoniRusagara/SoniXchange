package com.soniXchange.service;

import com.soniXchange.model.Coin;
import com.soniXchange.model.User;
import com.soniXchange.model.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId);
    Watchlist createWatchList(User user);
    Watchlist findById(Long id);
    Coin addItemToWatchlist(Coin coin, User user);
    
}
