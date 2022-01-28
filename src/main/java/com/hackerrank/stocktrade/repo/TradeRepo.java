package com.hackerrank.stocktrade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.model.Trade;

@Repository
public interface TradeRepo extends JpaRepository<Trade, Long>{
	
}