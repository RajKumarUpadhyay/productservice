/**
 * 
 */
package com.product.service.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.model.ProductModel;
import com.product.service.services.ProductDetailServices;
import com.product.service.validation.ProductServiceValidationImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productService")
@Api(value = "Product Service API's")
public class ProductServiceController {
	final static Logger logger = LoggerFactory.getLogger(ProductServiceController.class);
	
	@Autowired
	ProductServiceValidationImpl productServiceValidationImpl;
	@Autowired
	ProductDetailServices service;

	@ApiOperation(notes="Get all products from database.", value = "")
	@RequestMapping(value = "/products/all", method = RequestMethod.GET)
	public List<ProductModel> getProducts() {
		logger.info(this.getClass().getSimpleName() + " - Get all Products service is invoked.");
		return service.getProducts();
	}

	@ApiOperation(notes="Get product by ID from database.", value = "")
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ProductModel getProductById(@PathVariable int id) throws Exception {
		logger.info(this.getClass().getSimpleName() + " - Get Product details by id is invoked.");

		Optional<ProductModel> product = service.getProductById(id);
		if (!product.isPresent())
			throw new Exception("Could not find Product with id- " + id);

		return product.get();
	}

	@ApiOperation(notes="Create/Add product into the database.", value = "Accept product attributes as an input object")
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public ProductModel createProduct(@RequestBody ProductModel newproduct) {
		logger.info(this.getClass().getSimpleName() + " - Create new Product method is invoked.");
		return service.addNewProduct(newproduct);
	}

	@ApiOperation(notes="update product by ID into the database if exist otherwise update same product.", value = "Accept product id as an argument")
	@RequestMapping(value= "/product/update/{id}", method= RequestMethod.PUT)
	public ProductModel updateProduct(@RequestBody ProductModel updproduct, @PathVariable int id) throws Exception {
		logger.info(this.getClass().getSimpleName() + " - Update product details by id is invoked.");

		Optional<ProductModel> product =  service.getProductById(id);
		if (!product.isPresent())
			throw new Exception("Could not find product with id- " + id);

		/* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
		 * if that variable is not coming in the @RequestBody annotation object. */    
		if(updproduct.getDescription() == null || updproduct.getDescription().isEmpty())
			updproduct.setDescription(product.get().getDescription());
		if(updproduct.getVendorUID() == null || updproduct.getVendorUID().isEmpty())
			updproduct.setVendorUID(product.get().getVendorUID());
		if(updproduct.getNumberOfView() == 0)
			updproduct.setNumberOfView(product.get().getNumberOfView());

		updproduct.setID(id);
		return service.updateProduct(updproduct);
	}

	@ApiOperation(notes="Delete product by ID from the database.", value = "Accept product ID as an input ")
	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable int id) throws Exception {
		logger.info(this.getClass().getSimpleName() + " - Delete Product by id is invoked.");

		Optional<ProductModel> product = service.getProductById(id);
		if (!product.isPresent())
			throw new Exception("Could not find Product with id- " + id);

		service.deleteProductById(id);
	}
	
	@ApiOperation(notes="Delete all product from the database.", value = "")
	@RequestMapping(value = "/product/deleteall", method = RequestMethod.DELETE)
	public void deleteAll() {
		logger.info(this.getClass().getSimpleName() + " - Delete all Product is invoked.");
		service.deleteAllProducts();
	}
}
