package com.altimetrix.stockquote.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StockDetails {

  @NotBlank(message = "Stock Quote cannot be empty")
  private String stockQuote;

  @NotBlank(message = "Company Name cannot be empty")
  private String companyName;

  private LocalDate date;

  @DecimalMin(value = "0.0", inclusive = false)
  @Digits(integer = 5, fraction = 2)
  private BigDecimal price;

  private String currency;
}
