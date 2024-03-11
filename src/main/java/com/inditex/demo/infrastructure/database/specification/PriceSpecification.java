package com.inditex.demo.infrastructure.database.specification;

import com.inditex.demo.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class PriceSpecification implements Specification<PriceEntity> {

    private Long productId;
    private Long brandId;
    private Date date;

    public PriceSpecification(Long productId, Long brandId, Date date) {
        this.productId = productId;
        this.brandId = brandId;
        this.date = date;
    }

    @Override
    public Predicate toPredicate(Root<PriceEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(
                criteriaBuilder.equal(root.get("productId"), productId),
                criteriaBuilder.equal(root.get("brandId"), brandId),
                criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), date),
                criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), date)
        );
    }
}
