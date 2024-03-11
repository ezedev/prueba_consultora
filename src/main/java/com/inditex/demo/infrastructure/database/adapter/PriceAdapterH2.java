package com.inditex.demo.infrastructure.database.adapter;

import com.inditex.demo.infrastructure.database.specification.PriceSpecification;
import com.inditex.demo.infrastructure.entity.PriceEntity;
import com.inditex.demo.infrastructure.mapper.PriceMapper;
import com.inditex.demo.domain.model.Price;
import com.inditex.demo.infrastructure.database.port.PricePersistence;
import com.inditex.demo.infrastructure.database.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PriceAdapterH2 implements PricePersistence {

    private final PriceRepository repository;

    private final PriceMapper mapper;

    @Override
    public List<Price> getAll() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Price> getById(Long id) {
        return Optional.ofNullable(mapper.toModel(repository.findById(id).orElse(null)));
    }

    @Override
    public Price findByProductIdAndStartDateBeforeAndEndDateAfter(Long productId, Date startDate, Date endDate) {
        return mapper.toModel(repository.findByProductIdAndStartDateBeforeAndEndDateAfter(productId, startDate, endDate));
    }
    @Override
    public List<Price> findByProductId(Long productId, Long brandId, Date date) {
        Specification<PriceEntity> spec = new PriceSpecification(productId, brandId, date);
        List<PriceEntity> priceEntities = repository.findAll(spec);
        return priceEntities.stream().map(mapper::toModel).collect(Collectors.toList());
    }
}
