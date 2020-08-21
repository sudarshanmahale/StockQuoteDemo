package com.altimetrix.stockquote.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.altimetrix.stockquote.service.StockQuoteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StockQuoteControllerTest {
  private MockMvc mockMvc;

  @Autowired
  private StockQuoteService stockQuoteService;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void prepareMockMvc(){
    this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  public void addStockDetailsTest() throws Exception {
    this.mockMvc.perform(post("/v1/stock").contentType(MediaType.APPLICATION_JSON)
        .content("{\n"
            + "  \"stockQuote\":\"HCL12\",\n"
            + "  \"companyName\":\"HCL Tec\",\n"
            + "  \"date\":\"2018-11-12\",\n"
            + "  \"price\":20.2,\n"
            + "  \"currency\":\"Test\"\n"
            + "}")).andExpect(status().isCreated());

  }
}
