package com.hackerrank.stocktrade.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeService{
	public ResponseEntity<Trade> sereraseall();
	public String serretaddNewTrades(List<Trade> trade);
	public ResponseEntity<Trade> serretfilteredById(Long Id);
	public ResponseEntity<List<Trade>> serretallTrades();
	public ResponseEntity<List<Trade>> serretfilteredByUserId(Long UserID);
	public ResponseEntity<List<Trade>> serretfilteredByStockTypeDate(String stocksymbol, String tradeType, Timestamp startDate, Timestamp endDate);
	public ResponseEntity<String> serretfilteredByStockDate(String stocksymbol, Timestamp startDate, Timestamp endDate);
}