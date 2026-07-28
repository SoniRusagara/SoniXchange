package com.soniXchange.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch;
import org.springframework.stereotype.Service;

import com.soniXchange.model.Coin;
import com.soniXchange.model.User;
import com.soniXchange.model.Watchlist;
import com.soniXchange.repository.WatchlistRepository;

@Service
public class WatchlistServiceImpl implements WatchlistService{

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Override
    public Watchlist findUserWatchlist(Long userId) throws Exception {
        Watchlist watchlist = watchlistRepository.findByUserId(userId);
        if(watchlist == null){
            throw new Exception("Watchlist not found");

        }
        return watchlist;
    }

    @Override
    public Watchlist createWatchList(User user) {
        Watchlist watchlist = new Watchlist();
        watchlist.setUser(user);

        return watchlistRepository.save(watchlist);
    }

    @Override
    public Watchlist findById(Long id) throws Exception{
        Optional<Watchlist> watchListOptional = watchlistRepository.findById(id);
        if(watchListOptional.isEmpty()){
            throw new Exception("Watchlist not found");
        }

        return watchListOptional.get();
    }

    @Override
    public Coin addItemToWatchlist(Coin coin, User user) throws Exception{
        Watchlist watchlist = findUserWatchlist(user.getId());
        
        if(watchlist.getCoins().contains(coin)){
            watchlist.getCoins().remove(coin);
        } else watchlist.getCoins().add(coin);
        
        watchlistRepository.save(watchlist);
        return coin;
        
    }
    
}
