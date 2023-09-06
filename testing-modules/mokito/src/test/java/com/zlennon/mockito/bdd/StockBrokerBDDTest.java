package com.zlennon.mockito.bdd;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import com.zlennon.mockito.bdd.dto.Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class StockBrokerBDDTest {
	@Mock MarketWatcher marketWatcher;
	@Mock Portfolio portfolio;

	StockBroker broker;

	@Before public void setUp() {
		broker = new StockBroker(marketWatcher);
	}
	
	@Test
	public void should_sell_a_stock_when_price_increases_by_ten_percent() throws Exception {
		Stock aCorp = new Stock("FB", "FaceBook", new BigDecimal(11.20));
		//Given a customer previously bought  stocks at $10.00/per share
		given(portfolio.getAvgPrice(isA(Stock.class))).willReturn(
				new BigDecimal("10.00"));
		given(marketWatcher.getQuote(eq("FB"))).willReturn(
				aCorp);
		
		//when the  stock price becomes $11.00
		broker.perform(portfolio, aCorp);
		
		//then the stocks  are sold
		verify(portfolio).sell(aCorp,10);
	}
}
