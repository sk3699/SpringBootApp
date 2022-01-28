package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeService{
	public void eraseall();
	public Trade retaddNewTrades();
	public Optional<Trade> retfilteredById();
	public List<Trade> retallTrades();
	public Optional<Trade> retfilteredByUserId();
	public List<Trade> retfilteredByStockTypeDate();
	public void retfilteredByStockDate();
}