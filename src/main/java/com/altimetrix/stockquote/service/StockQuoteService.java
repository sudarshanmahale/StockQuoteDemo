package com.altimetrix.stockquote.service;

import com.altimetrix.stockquote.dto.StockDetails;
import com.altimetrix.stockquote.repository.StockQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockQuoteService {

  @Autowired
  private StockQuoteRepository stockQuoteRepository;

  public StockDetails addStockDetails(final StockDetails stockDetails) {

    return stockQuoteRepository.addStockDetails(stockDetails);

  }

  public StockDetails getStockDetails(final String stockQuote) {
    return stockQuoteRepository.getStockDetails(stockQuote);
  }

}
