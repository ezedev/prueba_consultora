package com.inditex.demo.infrastructure.database.port;

import com.inditex.demo.domain.model.Price;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PricePersistence {

    List<Price> getAll();

    Optional<Price> getById(Long id);

    Price findByProductIdAndStartDateBeforeAndEndDateAfter(Long productId, Date startDate, Date endDate);

    List<Price> findByProductId(Long productId, Long brandId, Date date);

}
