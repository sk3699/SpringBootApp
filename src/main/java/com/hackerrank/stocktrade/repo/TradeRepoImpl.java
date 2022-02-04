package com.hackerrank.stocktrade.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;

public class TradeRepoImpl{
	
	@Autowired
	private TradeRepo traderepo;
	@Autowired
	private UserRepo userrepo;
	
	public ResponseEntity<Trade> eraseall() {
		traderepo.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public String retaddNewTrades(List<Trade> trade) {
		// TODO Auto-generated method stub
		Map<Long, HttpStatus> map= new HashMap<Long, HttpStatus>();
		String s = "";
		for(Trade t : trade) {
			Optional<Trade> tr= traderepo.findById(t.getId());
			if(!tr.isPresent()) {
				userrepo.save(t.getUser());
				traderepo.saveAndFlush(t);
				map.put(t.getId(), HttpStatus.CREATED);
				//return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				map.put(t.getId(), HttpStatus.BAD_REQUEST);
			}
		}
		s = map.toString();
		//return (ResponseEntity<Map<Long, HttpStatus>>) map;
		return s;
	}

	public ResponseEntity<Trade> retfilteredById(Long id) {
		// TODO Auto-generated method stub
		if(traderepo.findById(id).isPresent()) {
			return new ResponseEntity<>(traderepo.findById(id).get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<List<Trade>> retallTrades() {
		// TODO Auto-generated method stub
		if(traderepo.count()> 0) {
			return new ResponseEntity<>(traderepo.findAll(Sort.by(Sort.Direction.ASC, "id")), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<List<Trade>> retfilteredByUserId(Long userID) {
		//System.out.println("No.Of user obj's "+userrepo.findAll().toString());
		Optional<User> u = userrepo.findById(userID);
		if(u.isPresent()) { //&& t.isPresent()
			List<Trade> t  = traderepo.findAllByUser(u.get());
			//return new ResponseEntity.of(t, HttpStatus.OK);
			return new ResponseEntity<>(t, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Trade>> retfilteredByStockTypeDate(String stocksymbol, String tradeType, Timestamp startDate, Timestamp endDate) {
		// TODO Auto-generated method stub
		List<Trade> tl = traderepo.findAllBySymbolAndType(stocksymbol, tradeType);
		List<Trade> retTL = new ArrayList<Trade>();
		if(traderepo.findAllBySymbol(stocksymbol).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		for(Trade t : tl) {
			if(t.getTimestamp().after(startDate) && t.getTimestamp().before(endDate) && t.getSymbol().equalsIgnoreCase(stocksymbol)) {
				retTL.add(t);
			}
		}
		return new ResponseEntity<>(retTL, HttpStatus.OK);
	}

	public ResponseEntity<String> retfilteredByStockDate(String stocksymbol, Timestamp startDate, Timestamp endDate) {
		// TODO Auto-generated method stub
		//List<Trade> t2 = traderepo.findAllBySymbol(stocksymbol);
		//JSONObject jsonObject= new JSONObject(); 
		String s = "";
		Float high = traderepo.highest(stocksymbol,startDate,endDate);
		Float low = traderepo.lowest(stocksymbol,startDate,endDate);
		if(traderepo.findAllBySymbol(stocksymbol).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		s+="{ \n   StockSymbol: "+ stocksymbol+"\n"+
			"   highest: "+high+",\n"+
			"   lowest: "+low+",\n";
		
		/*for(Trade t : t2) {
			if(t.getTimestamp().after(startDate) && t.getTimestamp().before(endDate)) {
				System.out.println("t: "+t.getPrice());
				if(t.getPrice().equals(high)) {
					s += "  highest: "+high+",\n";
				}else if(t.getPrice().equals(low)) {
					s += "  lowest: "+low+",\n";
				}
			}
		}*/
		s+="}";
		if(!s.contains("StockSymbol")) {
			s = "{\n message: There are no trades in given data range \n}";
		}
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
}