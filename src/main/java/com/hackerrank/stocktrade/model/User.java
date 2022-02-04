package com.hackerrank.stocktrade.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    public User() {
    }
    
    /*public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }*/
    
    public User(String string) {
		// TODO Auto-generated constructor stub
    	this.name = string;
	}

	public User(long l, String string) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
