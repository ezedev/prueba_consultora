package com.inditex.demo.application.service;

import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.application.usecases.GetSpecificPrice;
import com.inditex.demo.domain.model.Price;
import com.inditex.demo.infrastructure.database.port.PricePersistence;
import com.inditex.demo.infrastructure.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetSpecificPriceUseCaseTest {

    @InjectMocks
    GetSpecificPrice getSpecificPrice;

    @Mock
    PricePersistence pricePort;

    @Mock
    PriceMapper priceMapper;

    @Test
    void testExecute_WithNotFoundPrice() {
        Long productId = 35455L;
        Long brandId = 1L;
        Date date = new Date();
        List<Price> priceEntities = new ArrayList<>();
        when(pricePort.findByProductId(productId, brandId, date)).thenReturn(priceEntities);

        PriceDTO result = getSpecificPrice.execute(productId, brandId, date);

        assertNull(result);
    }
}
