package com.drugsusceptibilty.logic;

import java.awt.List;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.drugsusceptibilty.utils.MakeConnection;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class MapReduceQuery{
	String[] drugsTested = {"Alcohol consumption","Cannabis consumption","Cocaine consumption", "Caffiene consumption", "Nicotine consumption"};
	ArrayList<Float> WeightedAverages=new ArrayList<>();
	String gender="";
	int lower_ascore=0;
	int lower_escore=0;
	int lower_oscore=0;
	
	public void Mapper(String gender, String Edu, int a_score, int o_score, int e_score) {
	
		this.lower_ascore=a_score;
		this.lower_oscore=o_score;
		this.lower_escore=e_score;
		this.gender=gender;
	
	MongoCollection<Document> dbcoll = MakeConnection.createConnection().getCollection("TestDrugs");
	
	String[] drugsTested = {"Alcohol consumption","Cannabis consumption","Cocaine consumption", "Caffiene consumption", "Nicotine consumption"};
	
	
	String[] Score= {"Ascore", "Oscore", "Escore"};
	for(int j=0;j<drugsTested.length;j++) {
	for (int i = 0; i < Score.length; i++) {
		Bson filter = Filters.eq(drugsTested[j], "CL6");
			
		String map =  "function(){emit(this.Gender,{score:this."+ Score[i]+ ",count:1});}";
		String reduce = "function(key, values){var count=0; var n={count:0,score:0};for(var i=0; i<values.length;i++){n.score+=values[i].score;n.count+=values[i].count;}return n;}";
		
		String finalizeFunction = "function(key,values){var avg=0.0; avg=values.score/values.count;return avg}";
		MapReduceIterable out = dbcoll.mapReduce(map,reduce).finalizeFunction(finalizeFunction).filter(filter);
		for (Object o:out) {
			String string;
			string = o.toString();
			String[] parts = string.split("=");
			String avg = parts[2].replaceAll("}}", "");
			try {
				WeightedAverages.add(Float.parseFloat(avg));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		  
	}
	makeDecision(j, WeightedAverages);
	WeightedAverages.clear();
	}
	
	}
	
	public void makeDecision(int drug, ArrayList<Float> averages) {
		int y=0;
		if(gender.equals("Female")) {
		for(int n1=0; n1<averages.size();n1++) {
	
			if(n1%2==0) {
					if(lower_ascore < averages.get(n1) && averages.get(n1)<=lower_ascore+2) {
						y++;
				}
					
					if(lower_oscore < averages.get(n1) && averages.get(n1)<=lower_oscore+2) {
						y++;
				}
					
					if(lower_escore < averages.get(n1) && averages.get(n1)<=lower_escore+2) {
						y++;
				}
			}
		}

	}else {
		for(int k=0; k<averages.size();k++) {
			if(k%2!=0) {
				if(lower_ascore < averages.get(k) && averages.get(k)<=lower_ascore+2) {
					y++;
			}
				
				if(lower_oscore < averages.get(k) && averages.get(k)<=lower_oscore+2) {
					y++;
			}
				
				if(lower_escore < averages.get(k) && averages.get(k)<=lower_escore+2) {
					y++;
			}
		}
		}
	}
		if(y>=2) {
			System.out.println("You are susceptible to "+drugsTested[drug]);
		}else {
			System.out.println("Not susceptible to "+drugsTested[drug]);
		}
	}
	}