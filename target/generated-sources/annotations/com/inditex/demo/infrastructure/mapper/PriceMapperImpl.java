package com.inditex.demo.infrastructure.mapper;

import com.inditex.demo.application.dto.PriceDTO;
import com.inditex.demo.domain.model.Price;
import com.inditex.demo.infrastructure.entity.PriceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-11T04:52:55+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceEntity toEntity(Price model) {
        if ( model == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setId( model.getId() );
        priceEntity.setBrandId( model.getBrandId() );
        priceEntity.setProductId( model.getProductId() );
        priceEntity.setStartDate( model.getStartDate() );
        priceEntity.setEndDate( model.getEndDate() );
        priceEntity.setPriceList( model.getPriceList() );
        priceEntity.setPriority( model.getPriority() );
        priceEntity.setPrice( model.getPrice() );
        priceEntity.setCurrency( model.getCurrency() );

        return priceEntity;
    }

    @Override
    public Price toModel(PriceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Price price = new Price();

        price.setId( entity.getId() );
        price.setBrandId( entity.getBrandId() );
        price.setStartDate( entity.getStartDate() );
        price.setEndDate( entity.getEndDate() );
        price.setPriceList( entity.getPriceList() );
        price.setProductId( entity.getProductId() );
        price.setPriority( entity.getPriority() );
        price.setPrice( entity.getPrice() );
        price.setCurrency( entity.getCurrency() );

        return price;
    }

    @Override
    public PriceDTO toDto(Price model) {
        if ( model == null ) {
            return null;
        }

        PriceDTO priceDTO = new PriceDTO();

        priceDTO.setId( model.getId() );
        priceDTO.setBrandId( model.getBrandId() );
        priceDTO.setStartDate( model.getStartDate() );
        priceDTO.setEndDate( model.getEndDate() );
        priceDTO.setPriceList( model.getPriceList() );
        priceDTO.setProductId( model.getProductId() );
        priceDTO.setPriority( model.getPriority() );
        priceDTO.setPrice( model.getPrice() );
        priceDTO.setCurrency( model.getCurrency() );

        return priceDTO;
    }
}
