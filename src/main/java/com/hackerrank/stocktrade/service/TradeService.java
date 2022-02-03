package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeService{
	public ResponseEntity<Trade> sereraseall();
	public String serretaddNewTrades(List<Trade> trade);
	public ResponseEntity<Trade> serretfilteredById(Long Id);
	public ResponseEntity<List<Trade>> serretallTrades();
	public ResponseEntity<Trade> serretfilteredByUserId(Long UserID);
	public List<Trade> serretfilteredByStockTypeDate();
	public void serretfilteredByStockDate();
}