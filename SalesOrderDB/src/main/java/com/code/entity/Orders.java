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
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_id;
	@Column(name = "order_date")
	private String order_date;
	@Column(name = "total_amount")
	private double total_amount;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_id;
	
	/*@ManyToMany
	@JoinTable(name = "orderdetails", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id"), inverseJoinColumns = {@JoinColumn(name = "")})
	private List<Product> products;*/
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetails> orderdetails;
	public Orders() {
		//super();
		this.order_id = 0;
		this.order_date = null;
		this.total_amount = 0;
		this.user_id = null;
		this.orderdetails = null;
	}
	
	public Orders(String order_date, double total_amount, User user_id) {
		//super();
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.user_id = user_id;
		//this.orderdetails = orderdetails;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
	public void addOrders(OrderDetails orderDetail) {
		if(orderdetails == null)
			orderdetails = new ArrayList<OrderDetails>();
		
		orderdetails.add(orderDetail);
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_date=" + order_date + ", total_amount=" + total_amount
				+ ", user_id=" + user_id + ", orderdetails=" + orderdetails + "]";
	}
	
	

}
