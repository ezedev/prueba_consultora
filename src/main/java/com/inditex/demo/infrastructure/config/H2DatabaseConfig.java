package com.inditex.demo.infrastructure.config;

import javax.annotation.PostConstruct;

import com.inditex.demo.infrastructure.database.repository.PriceRepository;
import com.inditex.demo.infrastructure.entity.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class H2DatabaseConfig {

    @Autowired
    private PriceRepository priceRepository;

    @PostConstruct
    public void init() {
        insertPrices();
    }

    private void insertPrices() {
        List<PriceEntity> prices = new ArrayList<>();

        PriceEntity price1 = new PriceEntity(1L, createDate("2020-06-14-00.00.00"), createDate("2020-12-31-23.59.59"), 1, 35455L, 0, new BigDecimal("35.50"), "EUR");
        PriceEntity price2 = new PriceEntity(1L, createDate("2020-06-14-15.00.00"), createDate("2020-06-14-18.30.00"), 2, 35455L, 1, new BigDecimal("25.45"), "EUR");
        PriceEntity price3 = new PriceEntity( 1L, createDate("2020-06-15-00.00.00"), createDate("2020-06-15-11.00.00"), 3, 35455L, 1, new BigDecimal("30.50"), "EUR");
        PriceEntity price4 = new PriceEntity(1L, createDate("2020-06-15-16.00.00"), createDate("2020-12-31-23.59.59"), 4, 35455L, 1, new BigDecimal("38.95"), "EUR");

        prices.add(price1);
        prices.add(price2);
        prices.add(price3);
        prices.add(price4);

        priceRepository.saveAll(prices);
    }

    private Date createDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Error parsing date: " + dateString, e);
        }
    }

}
