package com.inditex.demo.infrastructure.database.repository;

import com.inditex.demo.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {
    PriceEntity findByProductIdAndStartDateBeforeAndEndDateAfter(Long productId, Date startDate, Date endDate);
}
