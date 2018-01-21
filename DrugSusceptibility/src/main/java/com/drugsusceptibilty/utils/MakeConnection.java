package com.drugsusceptibilty.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MakeConnection {

	public static MongoDatabase createConnection(){
		
		MongoClient databaseClient = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = databaseClient.getDatabase("DrugSusceptibility");
		return db;
	}
	
	
}
