package com.mvc.service;

import javax.annotation.Resource;

import com.mvc.dao.FoodDao;

public class FoodService{
	@Resource
	private FoodDao foodDao;

	public boolean intoRedis(String foodId, String foodNumber) {
		return foodDao.intoRedis(foodId, foodNumber);
	}

	public void editFoodNumber(String foodId) {
		foodDao.editFoodNumber(foodId);
	}
	
	public void saveFoodNumber(String  foodId){
		foodDao.saveFoodNumber(foodId);
	}
}
