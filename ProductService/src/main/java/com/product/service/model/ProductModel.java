package com.product.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_MODEL")
public class ProductModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name = "VENDOR_UID",unique = true)
	private String vendorUID;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "DIETARY_FLAG")
	@Enumerated(EnumType.STRING)
	private DietaryFlags dietaryFlags;
	@Column(name = "NUMBER_OF_VIEW")
	private int numberOfView;

	public static ProductModel getProductModel()
	{
		return	new ProductModel();
	}

	/**
	 * @return the vendorUID
	 */
	public String getVendorUID() {
		return vendorUID;
	}
	/**
	 * @param vendorUID the vendorUID to set
	 */
	public void setVendorUID(String vendorUID) {
		this.vendorUID = vendorUID;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the dietaryFlags
	 */
	public DietaryFlags getDietaryFlags() {
		return dietaryFlags;
	}
	/**
	 * @param dietaryFlags the dietaryFlags to set
	 */
	public void setDietaryFlags(DietaryFlags dietaryFlags) {
		this.dietaryFlags = dietaryFlags;
	}
	/**
	 * @return the numberOfView
	 */
	public int getNumberOfView() {
		return numberOfView;
	}
	/**
	 * @param numberOfView the numberOfView to set
	 */
	public void setNumberOfView(int numberOfView) {
		this.numberOfView = numberOfView;
	}
	@Override
	public String toString() {
		return "ProductModel [vendorUID=" + vendorUID + ", ID=" + ID + ", title=" + title + ", description="
				+ description + ", price=" + price + ", image=" + image + ", dietaryFlags=" + dietaryFlags
				+ ", numberOfView=" + numberOfView + "]";
	}



}
