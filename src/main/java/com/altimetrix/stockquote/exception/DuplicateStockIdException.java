package com.altimetrix.stockquote.exception;

public class DuplicateStockIdException extends RuntimeException {
  public DuplicateStockIdException(String message) {
    super(message);
  }
}
