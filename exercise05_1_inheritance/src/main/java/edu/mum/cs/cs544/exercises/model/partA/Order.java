package edu.mum.cs.cs544.exercises.model.partA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="`Order`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> orderLineList = new ArrayList();
	
	public Order() {}

	public Order(Date date, Customer customer) {
		super();
		//this.orderid = orderid;
		this.date = date;
		this.customer = customer;
		customer.addOrder(this);
		//addOrderLine(orderLine);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLine() {
		return orderLineList;
	}

	public void setOrderLine(List<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLineList.add(orderLine);
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderId + ", date=" + date + ", customer=" + customer + ", orderLine=" + orderLineList
				+ "]";
	}

}
