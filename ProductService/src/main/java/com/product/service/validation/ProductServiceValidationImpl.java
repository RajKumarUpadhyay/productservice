package com.product.service.validation;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.product.service.model.ProductModel;

@Component
public class ProductServiceValidationImpl implements ProductServiceValidation {

	@Override
	public boolean validateProductService(ProductModel productModel) {
		
		if(Objects.nonNull(productModel.getVendorUID()) && !productModel.getVendorUID().isEmpty())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean validateProductVendorId(int vendorId) {
		
		if(Objects.nonNull(vendorId))
		{
			return true;
		}
		return false;
	}
}
