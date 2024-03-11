package com.inditex.demo.application.usecases;

import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.infrastructure.database.port.PricePersistence;
import com.inditex.demo.infrastructure.mapper.PriceMapper;
import com.inditex.demo.infrastructure.port.GetSpecificPriceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetSpecificPrice implements GetSpecificPriceUseCase {

    private final PricePersistence pricePort;

    private final PriceMapper mapper;

    @Override
    public PriceDTO execute(Long productId, Long brandId, Date date) {
        List<PriceDTO> priceDTOList = pricePort.findByProductId(productId, brandId, date)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return priceDTOList.stream().findFirst().orElse(null);
    }
}
