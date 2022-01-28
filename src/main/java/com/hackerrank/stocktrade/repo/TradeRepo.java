package com.hackerrank.stocktrade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hackerrank.stocktrade.model.Trade;

public abstract class TradeRepo implements JpaRepository<Trade, Long>{
	
}