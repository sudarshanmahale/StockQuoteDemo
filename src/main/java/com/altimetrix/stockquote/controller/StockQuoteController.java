package com.altimetrix.stockquote.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.altimetrix.stockquote.dto.StockDetails;
import com.altimetrix.stockquote.exception.DuplicateStockIdException;
import com.altimetrix.stockquote.exception.StockNotFoundException;
import com.altimetrix.stockquote.service.StockQuoteService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stock")
@Slf4j

public class StockQuoteController {

  @Autowired
  private StockQuoteService stockQuoteService;

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> addStockDetails(@RequestBody @Valid StockDetails stockDetails) {
    log.info("Processing add details for {}", stockDetails);
    try {
      stockQuoteService.addStockDetails(stockDetails);
    } catch (DuplicateStockIdException dsie) {
      return new ResponseEntity<>(dsie.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(stockDetails, HttpStatus.CREATED);
  }

  @GetMapping(path = "/{stockQuote}")
  public ResponseEntity<Object> getStockDetails(@PathVariable String stockQuote) {
    log.info("Processing get details for {}", stockQuote);
    try {
      return new ResponseEntity<>(stockQuoteService.getStockDetails(stockQuote), HttpStatus.OK);
    } catch (StockNotFoundException dsie) {
      return new ResponseEntity<>(dsie.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

}
