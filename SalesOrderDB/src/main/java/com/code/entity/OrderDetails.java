package com.code.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_details_id")
	private int order_details_id;
	@Column(name = "qty")
	private int qty;
	@ManyToOne
//	@JoinColumns({@JoinColumn(name = "product_id", referencedColumnName = "product_id"),@JoinColumn(name = "price", referencedColumnName = "price")})
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;
	//private double price;
	@JoinColumn(name = "amount")
	private double amount;
	
	public OrderDetails() {
		this.order_details_id = 0;
		this.qty = 0;
		this.product = null;
		this.order = null;
		this.amount = 0;
	}

	public OrderDetails(int qty, Product product, Orders order, double amount) {
		//super();
		this.qty = qty;
		this.product = product;
		this.order = order;
		this.amount = amount;
	}

	public int getOrder_details_id() {
		return order_details_id;
	}

	public void setOrder_details_id(int order_details_id) {
		this.order_details_id = order_details_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDetails [order_details_id=" + order_details_id + ", qty=" + qty + ", product=" + product
				+ ", order=" + order + ", amount=" + amount + "]";
	}
	
	
	
	
	
}
