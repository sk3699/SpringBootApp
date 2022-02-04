package com.hackerrank.stocktrade.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	private ResponseEntity<List<Trade>> filteredByUserId(@PathVariable(value = "userID") Long UserID) {
		ResponseEntity<List<Trade>> tr = tradeServiceimpl.serretfilteredByUserId(UserID);
		return tr;
	}
	
	@RequestMapping(value = "/trades/stocks/{stockSymbol}",
			method = RequestMethod.GET)
	private ResponseEntity<List<Trade>> filteredByStockTypeDate(@PathVariable(value = "stockSymbol") String stocksymbol,@RequestParam(value = "tradeType") String tradeType, @RequestParam(value = "startDate") Timestamp startDate, @RequestParam(value = "endDate") Timestamp endDate) {
		ResponseEntity<List<Trade>> trls= tradeServiceimpl.serretfilteredByStockTypeDate(stocksymbol,tradeType,startDate,endDate);
		return trls;
	}
	
	@RequestMapping(value = "/stocks/{stockSymbol}/price",
			method = RequestMethod.GET)
	private ResponseEntity<String> filteredByStockDate(@PathVariable(value = "stockSymbol") String stocksymbol, @RequestParam(value = "startDate") Timestamp startDate, @RequestParam(value = "endDate") Timestamp endDate) {
		return tradeServiceimpl.serretfilteredByStockDate(stocksymbol, startDate, endDate);
	}
}
