package com.product.service.validation;

import com.product.service.model.ProductModel;

public interface ProductServiceValidation {
	
	public boolean validateProductService(ProductModel productModel);
	public boolean validateProductVendorId(int vendorId);
}
