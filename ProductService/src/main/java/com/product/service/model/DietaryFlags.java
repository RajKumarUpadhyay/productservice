package com.product.service.model;

public enum DietaryFlags {

	VEGAN("vegan"),
	LACTOSE_FREE("lactose_free");
	
	private final String levelCode;

    public String getLevelCode() {
		return levelCode;
	}

	private DietaryFlags(String levelCode) {
        this.levelCode = levelCode;
    }
}
