package com.inditex.demo.infrastructure.mapper;

import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.domain.model.Price;
import com.inditex.demo.infrastructure.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceEntity toEntity(Price model);

    Price toModel(PriceEntity entity);

    PriceDTO toDto(Price model);
}
