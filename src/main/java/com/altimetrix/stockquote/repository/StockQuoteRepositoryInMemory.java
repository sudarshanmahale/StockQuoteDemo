package com.altimetrix.stockquote.repository;

import com.altimetrix.stockquote.dto.StockDetails;
import com.altimetrix.stockquote.exception.DefaultCapacityOverloaded;
import com.altimetrix.stockquote.exception.DuplicateStockIdException;
import com.altimetrix.stockquote.exception.StockNotFoundException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class StockQuoteRepositoryInMemory implements StockQuoteRepository {

  public static final int DEFAULT_CAPICITY = 10;
  private final Map<String, StockDetails> stockDetailsMap = new HashMap<>();

  @Override
  public StockDetails addStockDetails(final StockDetails stockDetails) {
    final String stockQuote = stockDetails.getStockQuote();
    if (stockDetailsMap.size() == DEFAULT_CAPICITY) {
      log.info("{} Default capacity overloaded can not add.", stockDetails);
      throw new DefaultCapacityOverloaded("Default capacity overloaded can not add.");
    } else if (stockDetailsMap.containsKey(stockQuote)) {
      throw new DuplicateStockIdException("Found Duplicate Stock Id");
    }
    stockDetailsMap.put(stockDetails.getStockQuote(), stockDetails);
    log.info("{} added successfully", stockDetails);
    return stockDetails;
  }

  public StockDetails getStockDetails(final String stockQuote) {

    if (!stockDetailsMap.containsKey(stockQuote)) {
      throw new StockNotFoundException("Stock Details not found for Stock Id " + stockQuote);
    } else {
      return stockDetailsMap.get(stockQuote);
    }

  }

}
