package com.hackerrank.stocktrade.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
public class Trade implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    
    public Trade() {
    }
    
   /* public Trade(Long id, String type, User user, String symbol, Integer quantity, Float price, Timestamp timestamp) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }*/
    
    public Trade(String string, User u2, String string2, int i, float f, Timestamp valueOf) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public Integer getShares() {
        return this.shares;
    }
    
    public void setShares(Integer shares) {
        this.shares = shares;
    }
    
    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public Timestamp getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
