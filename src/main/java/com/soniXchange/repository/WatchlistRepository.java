package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long>{

    Watchlist findByUserId(Long userId);
    
}
