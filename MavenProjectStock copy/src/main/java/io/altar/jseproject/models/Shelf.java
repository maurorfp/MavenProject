package io.altar.jseproject.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = Shelf.GET_ALL_SHELFS, query ="SELECT p FROM Shelf p")
})


public class Shelf extends Entity_ implements Serializable {
	
	public static final String GET_ALL_SHELFS = "getAllShelfs";
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Product product;
	private int capacity;
	private float dailyPrice;
	
	
	public Shelf() {}

//	public Shelf(int capacity, float dailyPrice) {
//		this.capacity = capacity;
//		this.dailyPrice = dailyPrice;
//	}
//
//	public Shelf(int capacity, long productId, float dailyPrice) {
//		this.productId = productId;
//		this.capacity = capacity;
//		this.dailyPrice = dailyPrice;






	@Override
	public String toString() {
		return "Shelf [capacity=" + capacity + ", productId=" + product + ", dailyPrice=" + dailyPrice
				+ "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
