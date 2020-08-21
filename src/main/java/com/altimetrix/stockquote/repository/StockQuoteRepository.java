package com.altimetrix.stockquote.repository;

import com.altimetrix.stockquote.dto.StockDetails;


public interface StockQuoteRepository {

  StockDetails addStockDetails(final StockDetails stockDetails);

  StockDetails getStockDetails(final String stockQuote);
}
