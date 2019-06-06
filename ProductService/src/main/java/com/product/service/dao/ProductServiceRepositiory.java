package com.product.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.service.model.ProductModel;


@Repository
public interface ProductServiceRepositiory extends JpaRepository<ProductModel, Integer>  {

}
