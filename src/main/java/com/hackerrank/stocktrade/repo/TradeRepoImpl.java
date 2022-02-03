package com.hackerrank.stocktrade.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.stocktrade.model.Trade;

public class TradeRepoImpl{
	
	@Autowired
	private TradeRepo traderepo;
	
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
			return new ResponseEntity<>(traderepo.findById(id).get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Trade>> retallTrades() {
		// TODO Auto-generated method stub
		if(traderepo.count()> 0) {
			return new ResponseEntity<>(traderepo.findAll(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Trade> retfilteredByUserId(Long userID) {
		// TODO Auto-generated method stub
		return ResponseEntity.of(traderepo.findById(userID));
	}

	public List<Trade> retfilteredByStockTypeDate() {
		// TODO Auto-generated method stub
		return traderepo.findAll();
	}

	public void retfilteredByStockDate() {
		// TODO Auto-generated method stub
		
		
	}
}