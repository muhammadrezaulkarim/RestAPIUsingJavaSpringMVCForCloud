package com.canadafoodguide.spring.service;

import java.util.List;

import com.canadafoodguide.spring.dao.FoodsDaoImpl;
import com.canadafoodguide.spring.model.Foods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FoodsService")
public class FoodsServiceImpl implements FoodsService{
	
	@Autowired
	private FoodsDaoImpl foodsDao;
	
	public List<Foods> getAllFoods()
	{
		return foodsDao.getAllFoods();
	}
	
	public List<Foods> getFoodsByFgid(Foods food)
	{
		return foodsDao.getFoodsByFgid(food);
	}
	
	public boolean insertFood(Foods food)
	{
		return foodsDao.insertFood(food);
	}
	
	public boolean updateFood(Foods food)
	{
		return foodsDao.updateFood(food);
	}
	
	public boolean deleteFood(Foods food)
	{
		return foodsDao.deleteFood(food);
	}
	
	public boolean deleteFoodsByFgids(List<String> fgids)
	{
		return foodsDao.deleteFoodsByFgids(fgids);
	}

}