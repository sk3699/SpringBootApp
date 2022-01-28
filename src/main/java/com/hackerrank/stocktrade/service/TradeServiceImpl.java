package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repo.TradeRepo;

public class TradeServiceImpl implements TradeService{
	
	@Autowired
	private TradeRepo traderepo;

	@Override
	public void eraseall() {
		traderepo.deleteAll();
	}

	@Override
	public Trade retaddNewTrades() {
		// TODO Auto-generated method stub
		return traderepo.saveAndFlush(null);
	}

	@Override
	public Optional<Trade> retfilteredById() {
		// TODO Auto-generated method stub
		return traderepo.findById(null);
	}

	@Override
	public List<Trade> retallTrades() {
		// TODO Auto-generated method stub
		return traderepo.findAll();
	}

	@Override
	public Optional<Trade> retfilteredByUserId() {
		// TODO Auto-generated method stub
		return traderepo.findOne(null);
	}

	@Override
	public List<Trade> retfilteredByStockTypeDate() {
		// TODO Auto-generated method stub
		return traderepo.findAll();
	}

	@Override
	public void retfilteredByStockDate() {
		// TODO Auto-generated method stub
		
		
	}
	
}