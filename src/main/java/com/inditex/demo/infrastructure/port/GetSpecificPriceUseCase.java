package com.inditex.demo.infrastructure.port;

import com.inditex.demo.application.dto.PriceDTO;

import java.util.Date;

@FunctionalInterface
public interface GetSpecificPriceUseCase {

    PriceDTO execute(Long productId, Long brandId, Date date);

}
