package com.canadafoodguide.spring.utility;

import java.util.List;

public class AgeGroupExtractor
{

	public static String extractAgeGroup(List<String> ageGroups, String age)
	{
		int [][] ageGroupMinandMaxAge=new int[ageGroups.size()][2];
		
		for(int i=0;i<ageGroups.size();i++)
		{
			String textualRepofAges=ageGroups.get(i);
			textualRepofAges=textualRepofAges.replaceAll(" to "," ");
			
			int plusSymbolIndex=textualRepofAges.indexOf("+");
			
			if(plusSymbolIndex > -1)
			{
				textualRepofAges=textualRepofAges.substring(0, plusSymbolIndex); // 71+, remove the + character
			}
			
			textualRepofAges=textualRepofAges.trim();
			
			String [] minMaxAgeRange=textualRepofAges.split(" ");
			
			if(minMaxAgeRange.length==2) // example: 2 to 5
			{
				ageGroupMinandMaxAge[i][0]=Integer.parseInt(minMaxAgeRange[0]);
				ageGroupMinandMaxAge[i][1]=Integer.parseInt(minMaxAgeRange[1]);
			}
			else if(minMaxAgeRange.length==1)  // example: 75+
			{
				ageGroupMinandMaxAge[i][0]=Integer.parseInt(minMaxAgeRange[0]);
				ageGroupMinandMaxAge[i][1]=Integer.parseInt(minMaxAgeRange[0]);
			}
		}
		
		int ageNum=Integer.parseInt(age);
		
		for(int i=0;i<ageGroups.size();i++)
		{
			if(ageGroupMinandMaxAge[i][0]==ageGroupMinandMaxAge[i][1] & ageNum>= ageGroupMinandMaxAge[i][0]) // example: 71+
				return ageGroups.get(i);  // return the corresponding textual description
			else if( ageNum>= ageGroupMinandMaxAge[i][0] &&  ageNum<= ageGroupMinandMaxAge[i][1])  // example: 2 to 5
				return ageGroups.get(i);  // return the corresponding textual description
		}
		
		return new String(" "); // if no match found
	}
}