package com.demo.apiDemo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseProductRepository extends JpaRepository<BaseProduct, Long> {

    List<BaseProduct> findAll();

    Optional<BaseProduct> findByBaseProductId(Long baseProductId);

}
