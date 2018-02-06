package com.mvc.entity;

/**
 * 菜品的实体类
 * 
 * @author 23006
 *
 */
public class FoodEntity {
	private String foodId;
	private String foodNumber;

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodNumber() {
		return foodNumber;
	}

	public void setFoodNumber(String foodNumber) {
		this.foodNumber = foodNumber;
	}

	public FoodEntity(String foodId, String foodNumber) {
		super();
		this.foodId = foodId;
		this.foodNumber = foodNumber;
	}

	public FoodEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
