package com.skilldistillery.app;

public class FoodTruck {
	private static int nextTruckId = 42;
	private int truckId;
	private String name;
	private String foodType;
	private int rating;
	
	public FoodTruck() {
		
	}
	
	public FoodTruck(String name, String foodType, int rating) {
		this.truckId = nextTruckId;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		FoodTruck.nextTruckId++;
	}
	
	@Override
	public String toString() {
		return "Truck ID: " + truckId + " Name: " + name + ", Food Type: " + foodType + ", Rating: "  +
				rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
