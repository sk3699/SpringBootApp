package com.hackerrank.stocktrade.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repo.TradeRepoImpl;

@Service
public class TradeServiceImpl implements TradeService{
	
	@Autowired
	private TradeRepoImpl traderepoimpl;

	@Override
	public ResponseEntity<Trade> sereraseall() {
		return traderepoimpl.eraseall();
	}

	@Override
	public String serretaddNewTrades(List<Trade> trade) {
		// TODO Auto-generated method stub
		return traderepoimpl.retaddNewTrades(trade);
	}

	@Override
	public ResponseEntity<Trade> serretfilteredById(Long Id) {
		// TODO Auto-generated method stub
		return traderepoimpl.retfilteredById(Id);
	}

	@Override
	public ResponseEntity<List<Trade>> serretallTrades() {
		// TODO Auto-generated method stub
		return traderepoimpl.retallTrades();
	}

	@Override
	public ResponseEntity<List<Trade>> serretfilteredByUserId(Long userID) {
		// TODO Auto-generated method stub
		return traderepoimpl.retfilteredByUserId(userID);
	}

	@Override
	public ResponseEntity<List<Trade>> serretfilteredByStockTypeDate(String stocksymbol, String tradeType, Timestamp startDate, Timestamp endDate) {
		// TODO Auto-generated method stub
		return traderepoimpl.retfilteredByStockTypeDate(stocksymbol, tradeType, startDate, endDate);
	}

	@Override
	public ResponseEntity<String> serretfilteredByStockDate(String stocksymbol, Timestamp startDate, Timestamp endDate) {
		// TODO Auto-generated method stub
		//List<Trade> t = traderepoimpl.retfilteredByStockDate(stocksymbol, startDate, endDate);
		return traderepoimpl.retfilteredByStockDate(stocksymbol, startDate, endDate);
	}
	
}