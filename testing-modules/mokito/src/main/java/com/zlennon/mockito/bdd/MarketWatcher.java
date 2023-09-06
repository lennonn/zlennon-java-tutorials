package com.zlennon.mockito.bdd;


import com.zlennon.mockito.bdd.dto.Stock;

public interface MarketWatcher {
   Stock getQuote(String symbol);
}
