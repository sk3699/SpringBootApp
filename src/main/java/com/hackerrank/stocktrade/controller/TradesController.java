package com.hackerrank.stocktrade.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeServiceImpl;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {
    
	@Autowired
	private TradeServiceImpl tradeServiceimpl;
	
	@RequestMapping(value = "/erase",
			method = RequestMethod.DELETE)
	private void deleteAllTrades() {
		tradeServiceimpl.sereraseall();
	}
	
	@RequestMapping(value = "/trades",
			method = RequestMethod.POST)
	private String addNewTrades(@RequestBody List<Trade> trade) {
		return tradeServiceimpl.serretaddNewTrades(trade);
	}
	
	@RequestMapping(value = "/trades/{id}",
			method = RequestMethod.GET)
	private ResponseEntity<Trade> filteredById(@PathVariable(value = "id") Long Id) {
		//Trade tr = new Trade();
		return tradeServiceimpl.serretfilteredById(Id);
	}
	
	@RequestMapping(value = "/trades",
			method = RequestMethod.GET)
	private ResponseEntity<List<Trade>> allTrades() {
		//ResponseEntity<List<Trade>> ls= new ArrayList<Trade>(); //List<Trade> ls= new ArrayList<Trade>();
		return tradeServiceimpl.serretallTrades();
		//return ls;
	}
	
	@RequestMapping(value = "/trades/users/{userID}",
			method = RequestMethod.GET)
	private ResponseEntity<Trade> filteredByUserId(@PathVariable(value = "userID") Long UserID) {
		ResponseEntity<Trade> tr = tradeServiceimpl.serretfilteredByUserId(UserID);
		return tr;
	}
	
	@RequestMapping(value = "/trades/stocks/{stockSymbol}?type={tradeType}&start={startDate}&end={endDate}",
			method = RequestMethod.GET)
	private List<Trade> filteredByStockTypeDate() {
		List <Trade> trls= tradeServiceimpl.serretfilteredByStockTypeDate();
		return trls;
	}
	
	@RequestMapping(value = "/stocks/{stockSymbol}/price?start={startDate}&end={endDate}",
			method = RequestMethod.GET)
	private void filteredByStockDate() {
		tradeServiceimpl.serretfilteredByStockDate();
	}
}
