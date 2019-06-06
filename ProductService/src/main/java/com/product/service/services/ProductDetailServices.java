package com.product.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.service.model.ProductModel;

@Service
public interface ProductDetailServices {

	public List<ProductModel> getProducts();
	public Optional<ProductModel> getProductById(int empid);
	public ProductModel addNewProduct(ProductModel emp);
	public ProductModel updateProduct(ProductModel emp);
	public void deleteProductById(int empid);
	public void deleteAllProducts();

}
