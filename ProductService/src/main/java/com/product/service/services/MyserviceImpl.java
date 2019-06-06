package com.product.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.service.dao.ProductServiceRepositiory;
import com.product.service.model.ProductModel;

@Service
public class MyserviceImpl implements ProductDetailServices {

	@Autowired
	ProductServiceRepositiory dao;

	@Override
	public List<ProductModel> getProducts() {
		return dao.findAll();
	}
	@Override
	public Optional<ProductModel> getProductById(int productid) {
		return dao.findById(productid);
	}
	@Override
	public ProductModel addNewProduct(ProductModel productModel) {
		return dao.save(productModel);
	}
	@Override
	public ProductModel updateProduct(ProductModel productModel) {
		return dao.save(productModel);
	}
	@Override
	public void deleteProductById(int productid) {
		dao.deleteById(productid);
	}
	@Override
	public void deleteAllProducts() {
		dao.deleteAll();
	}
}
