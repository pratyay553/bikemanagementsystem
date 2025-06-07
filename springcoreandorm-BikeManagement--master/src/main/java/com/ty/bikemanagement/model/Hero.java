package com.ty.bikemanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
@Component
public class Hero implements Bike{
	@Id
	
	private int id;

	private String model;

	private int no_of_gears;

	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNo_of_gears() {
		return no_of_gears;
	}

	public void setNo_of_gears(int no_of_gears) {
		this.no_of_gears = no_of_gears;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hero(int id, String model, int no_of_gears, double price) {
		super();
		this.id = id;
		this.model = model;
		this.no_of_gears = no_of_gears;
		this.price = price;
	}

	public Hero() {
		super();
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", model=" + model + ", no_of_gears=" + no_of_gears + ", price=" + price + "]";
	}
	
	
	
	
	

}
