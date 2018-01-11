package com.canadafoodguide.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


	@Configuration
	public class SpringMongoConfig extends AbstractMongoConfiguration 
	{
	    @Override
	    protected String getDatabaseName() { 
	        return "sampledb";
	    }

	    @Override
	    @Bean
	    public MongoClient mongoClient() 
	    { 

	    	//for local development machine only. For cloud we will have different setting
	     	String connectionURI = "mongodb://mongousername:mongouserpassword@localhost/sampledb";
	     	MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionURI));
	     
	     	return mongoClient;
	    }
	    
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	    
	    	
	        return new MongoTemplate(mongoClient(),getDatabaseName());
	    }
	}

