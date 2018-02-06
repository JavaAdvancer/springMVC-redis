package com.mvc.dao;

import com.mvc.util.RedisUtil;

public class FoodDao {
	/**
	 * 初始化菜品，并将菜品编号和菜品数量以key-value的方式存放到redis中 去
	 * 
	 */
	public boolean intoRedis(String foodId, String foodNumber) {
		boolean flag = false;
		try {
			RedisUtil.set(foodId, foodNumber);
			flag = true;

		} catch (Exception e) {
			System.out.println("存放失败！");
		}
		return flag;
	}
	 
	/**
	 * 当点击下单时，修改 redis中 菜品value值
	 */
	public  void editFoodNumber(String foodId){
	   String number = RedisUtil.get(foodId);
	   String  foodNumber=null;
		 if(null != number){
			 if(Integer.parseInt(number)==0){
				foodNumber=0+""; 
			 }else{
				foodNumber= (Integer.parseInt(number)-1)+""; 
			 }
			 RedisUtil.set(foodId, foodNumber);
		 }
		
	}
	/**
	 * 当点击增加按钮时调用此方法来增加redis里菜品数量
	 * @param foodId
	 */
	public void saveFoodNumber(String foodId){
		String  number=RedisUtil.get(foodId);
		if(null != number){
			String foodNumber=(Integer.parseInt(number)+1)+"";
			RedisUtil.set(foodId, foodNumber);
		}
	}
	
}
