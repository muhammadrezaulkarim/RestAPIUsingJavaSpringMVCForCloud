package com.canadafoodguide.spring.dao;

import java.util.List;

import com.canadafoodguide.spring.model.Foods;

public interface FoodsDao {
 
	public List<Foods> getAllFoods();
	
	public List<Foods> getFoodsByFgid(Foods food);
	
	public boolean insertFood(Foods food);
	
	public boolean updateFood(Foods food);
	
	public boolean deleteFood(Foods food);
	
	public boolean deleteFoodsByFgids(List<String> fgids);
	
}
