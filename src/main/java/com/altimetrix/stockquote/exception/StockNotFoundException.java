package com.altimetrix.stockquote.exception;

public class StockNotFoundException extends RuntimeException{
  public StockNotFoundException(String message) {
    super(message);
  }
}
