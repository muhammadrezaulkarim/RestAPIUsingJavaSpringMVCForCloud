package com.canadafoodguide.spring.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.canadafoodguide.spring.config.SpringMongoConfig;
import com.canadafoodguide.spring.model.Foods;


@Repository("FoodsDao")
@Transactional
@SuppressWarnings("unchecked")
public class FoodsDaoImpl implements FoodsDao {

	private MongoOperations mongoOperations;
	
	 
	public FoodsDaoImpl()
	{
		mongoOperations = loadMongoConfiguration();
	}
	   private MongoOperations loadMongoConfiguration() {
	        @SuppressWarnings("resource")
	        ApplicationContext applicationContext = 
	                 new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
	        
	        return mongoOperation;
	    }
	
	
	public List<Foods> getAllFoods(){
		
		List<Foods> listFood = mongoOperations.findAll(Foods.class);
		
		return listFood == null ? new ArrayList<Foods>() : listFood;
	}
 
	public List<Foods> getFoodsByFgid(Foods food) {
		
		Criteria criteria = Criteria.where("fgid").is(food.getFgid());
		
		Query query = new Query(criteria);
		
		List<Foods> listFood = mongoOperations.find(query, Foods.class, "client");
		
		return listFood == null ? new ArrayList<Foods>() : listFood;
	}
	
	
 
	public boolean insertFood(Foods food) {
		
		try{
			mongoOperations.save(food, "foods");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
 
	public boolean updateFood(Foods food) {
		try{
			mongoOperations.save(food, "foods");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
 
	public boolean deleteFood(Foods food) {
		try{
			mongoOperations.remove(food, "foods");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
 
	public boolean deleteFoodsByFgids(List<String> fgids) {
		
		Criteria criteria = Criteria.where("fgid").in(fgids);
		
		Query query = new Query(criteria);
		
		try{
			mongoOperations.remove(query, Foods.class, "foods");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
 
	
	
}