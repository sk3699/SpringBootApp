package com.hackerrank.stocktrade.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;

@Repository
public interface TradeRepo extends JpaRepository<Trade, Long>{
	public List<Trade> findAllByUser(User user);
	public List<Trade> findAllBySymbolAndType(String stocksymbol, String tradeType);
	//public boolean findAllBySymbol(String symbol);
	public List<Trade> findAllBySymbol(String stocksymbol);
	@Query(value = "SELECT max(price) FROM Trade WHERE symbol = :stocksymbol AND timestamp < :endDate AND timestamp > :startDate")
	public Float highest(@Param("stocksymbol") String stocksymbol, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
	@Query(value = "SELECT min(price) FROM Trade WHERE symbol = :stocksymbol AND timestamp < :endDate AND timestamp > :startDate")
	public Float lowest(@Param("stocksymbol") String stocksymbol, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
}