package com.mvc.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.service.FoodService;
import com.mvc.util.RedisUtil;

@Controller
@RequestMapping("/")
@SessionAttributes({ "foodId", "foodNumber" })
public class MvcController {
	@Resource
	private FoodService foodService;

	/**
	 * 初始化菜品数量
	 * 
	 * @param foodId
	 * @param foodNumber
	 * @return
	 */
	@RequestMapping("/init.do")

	public String init(@RequestParam("foodId") String foodId, @RequestParam("foodNumber") String foodNumber,
			Model model) {
		System.out.println("进入控制器");
		boolean flag = foodService.intoRedis(foodId, foodNumber);
		if (flag) {
			model.addAttribute("foodId", foodId);
			model.addAttribute("foodNumber", foodNumber);
			return "redirect:index.jsp";
		} else {
			return "redirect:init.jsp";
		}

	}

	/**
	 * 当点击点餐时
	 * 
	 * @param foodId
	 * @param model
	 * @return
	 */
	@RequestMapping("/click.do")

	public  String click(@RequestParam("foodId") final String foodId, Model model) {
		System.out.println("进入点餐 控制器");
		String foodNumber = null;

		synchronized (this){
			
		 foodService.editFoodNumber(foodId);
		 
		}
		foodNumber = RedisUtil.get(foodId);
		model.addAttribute("foodId", foodId);
		model.addAttribute("foodNumber", foodNumber);
		return "redirect:index.jsp";

	}

	/**
	 * 当点击增加菜品数量时
	 * 
	 * @param foodId
	 * @param model
	 * @return
	 */
	@RequestMapping("/save.do")
	public String save(@RequestParam("foodId") String foodId, Model model) {
		System.out.println("进入增加控制器");
		String foodNumber = null;
		synchronized (this){
			
		foodService.saveFoodNumber(foodId);
		
		}
		foodNumber = RedisUtil.get(foodId);
		model.addAttribute("foodId", foodId);
		model.addAttribute("foodNumber", foodNumber);
		return "redirect:index.jsp";
	}

}
