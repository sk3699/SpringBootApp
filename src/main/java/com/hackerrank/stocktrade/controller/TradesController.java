package com.hackerrank.stocktrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.stocktrade.service.TradeService;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {
    
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(value = "/erase",
			method = RequestMethod.DELETE)
	private void deleteAllTrades() {
		tradeService.eraseall();
	}
	
	@RequestMapping(value = "/trades",
			method = RequestMethod.POST)
	private void addNewTrades() {
		
	}
	
	@RequestMapping(value = "/trades/{id}",
			method = RequestMethod.GET)
	private void filteredById() {
		
	}
	
	@RequestMapping(value = "/trades",
			method = RequestMethod.GET)
	private void allTrades() {
		
	}
	
	@RequestMapping(value = "/trades/users/{userID}",
			method = RequestMethod.GET)
	private void filteredByUserId() {
		
	}
	
	@RequestMapping(value = "/trades/stocks/{stockSymbol}?type={tradeType}&start={startDate}&end={endDate}",
			method = RequestMethod.GET)
	private void filteredByStockTypeDate() {
		
	}
	
	@RequestMapping(value = "/stocks/{stockSymbol}/price?start={startDate}&end={endDate}",
			method = RequestMethod.GET)
	private void filteredByStockDate() {
		
	}
}
