package com.canadafoodguide.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.canadafoodguide.spring.dao.Servings_per_dayDaoImpl;
import com.canadafoodguide.spring.model.Servings_per_day;

import org.springframework.stereotype.Service;

@Service("Servings_per_dayService")
public class Servings_per_dayServiceImpl implements Servings_per_dayService {
	@Autowired
	Servings_per_dayDaoImpl servings_per_dayDao;
	 
	public List<Servings_per_day> getAllServings()
	{
		return servings_per_dayDao.getAllServings();
	}
	public List<Servings_per_day> getServingsGenderAge(String gender, String age)
	{
		return servings_per_dayDao.getServingsGenderAge(gender, age);
	}
	public List<Servings_per_day> getServingsByFgid(String fgid)
	{
		return servings_per_dayDao.getServingsByFgid(fgid);
	}
	public List<Servings_per_day> getServingsByGender(String gender)
	{
		return servings_per_dayDao.getServingsByGender(gender);
	}
	public List<Servings_per_day> getServingsByAgeGroup(String ageGroup)
	{
		return servings_per_dayDao.getServingsByAgeGroup(ageGroup);
	}
	public boolean insertServing(Servings_per_day singleServingOfADay)
	{
		return servings_per_dayDao.insertServing(singleServingOfADay);
	}
	public boolean updateServing(Servings_per_day singleServingOfADay)
	{
		return servings_per_dayDao.updateServing(singleServingOfADay);
	}
	
	public boolean deleteServing(Servings_per_day singleServingOfADay)
	{
		return servings_per_dayDao.deleteServing(singleServingOfADay);
	}
	public boolean deleteServingByGenderAge(String gender, String age)
	{
		return servings_per_dayDao.deleteServingByGenderAge(gender, age);
	}
	public boolean deleteServingByFgId(String fgid)
	{
		 return servings_per_dayDao.deleteServingByFgId(fgid);
	}
	
	public List<String> getDistinctAgeGroups()
	{
		return servings_per_dayDao.getDistinctAgeGroups();
	}

}
