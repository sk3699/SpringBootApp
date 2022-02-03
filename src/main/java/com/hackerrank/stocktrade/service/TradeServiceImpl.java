package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<Trade> serretfilteredByUserId(Long userID) {
		// TODO Auto-generated method stub
		return traderepoimpl.retfilteredByUserId(userID);
	}

	@Override
	public List<Trade> serretfilteredByStockTypeDate() {
		// TODO Auto-generated method stub
		return traderepoimpl.retfilteredByStockTypeDate();
	}

	@Override
	public void serretfilteredByStockDate() {
		// TODO Auto-generated method stub
		
		
	}
	
}