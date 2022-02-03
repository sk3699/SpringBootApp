package com.hackerrank.stocktrade;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.TimeZone;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repo.TradeRepo;
import com.hackerrank.stocktrade.repo.UserRepo;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
    private void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
    }
    /*
    @Component
    class DemoRunner implements CommandLineRunner{
    	
    	//@Autowired
    	private UserRepo userRepository;
    	@Autowired
    	private TradeRepo tradeRepository;
		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			User u1 = new User( "Briana Ortiz");
			User u2 = new User( "Amy Palmer");
			//userRepository.saveAll(Arrays.asList(u1,u2));
			Trade t1 = new Trade("buy", u2, "B", 11, (float) 174.82, Timestamp.valueOf("2018-12-28 13:18:48"));
			Trade t2 = new Trade("buy", u2, "AA", 11, (float) 174.82, Timestamp.valueOf("2018-12-29 09:47:43"));
			Trade t3 = new Trade("buy", u1, "B", 20, (float) 155.32, Timestamp.valueOf("2019-01-01 11:19:01"));
			Trade t4 = new Trade("buy", u2, "AA", 11, (float) 174.82, Timestamp.valueOf("2019-01-01 12:02:03"));
			Trade t5 = new Trade("buy", u1, "AA", 11, (float) 174.82, Timestamp.valueOf("2019-01-02 15:31:49"));
			Trade t6 = new Trade("buy", u1, "B", 20, (float) 155.32, Timestamp.valueOf("2019-01-02 15:42:18"));
			tradeRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
			
		}
    	
    }*/
}
