package com.code.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int product_id;
	@Column(name = "product_name")
	private String product_name;
	@Column(name = "product_desc")
	private String product_description;
	@Column(name = "price")
	private double price;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetails> orderdetails;
	
	public Product() {
		this.product_id = 0;
		this.product_name = null;
		this.product_description = null;
		this.price = 0;
		this.category = null;
	}

	public Product(String product_name, String product_description, double price, Category category) {
		//super();
	//	this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.price = price;
		this.category = category;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void addProducts(OrderDetails orderDetail) {
		if(orderdetails == null)
			orderdetails = new ArrayList<OrderDetails>();
		
		orderdetails.add(orderDetail);
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_description + ", price=" + price + ", category=" + category + "]";
	}
	
		
	
}
