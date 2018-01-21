package com.drugsusceptibilty.connectionToDB;
import org.bson.Document;

import com.drugsusceptibilty.utils.MakeConnection;
import com.drugsusceptibilty.utils.MakeConnection;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.*;
import java.io.*;


public class connectionToMongoDB {

	public void importData() throws FileNotFoundException {

		try {
			int n=0;
		
			MongoCollection<Document> aCollection = MakeConnection.createConnection().getCollection("TestDrugs");

		try (BufferedReader in = new BufferedReader(new FileReader("dataset/Narcos.csv"));) {

		String line;

		while ((line = in.readLine()) != null) {

			if(n<=500) {
		String[] var = line.split(",");

		Document aDoc = new Document();

		//Loading demographics
		aDoc.append("Age", var[0]);
		aDoc.append("Gender", var[1]);
		aDoc.append("Education", var[2]);
		aDoc.append("Country", var[3]);
		aDoc.append("Ethnicity", var[4]);
	
		//Loading personality trait factors
		aDoc.append("Nscore", var[5]);
		aDoc.append("Escore", var[6]);
		aDoc.append("Oscore", var[7]);
		aDoc.append("Ascore", var[8]);
		aDoc.append("Cscore", var[9]);
		aDoc.append("Impulsive", var[10]);

		//Loading drugs
		aDoc.append("Alcohol consumption", var[11]);
		aDoc.append("Amphetamines consumption", var[12]);
		aDoc.append("Amylnitrite consumption", var[13]);
		aDoc.append("Benzodiazepine consumption", var[14]);
		aDoc.append("Caffiene consumption", var[15]);
		aDoc.append("Cannabis consumption", var[16]);
		aDoc.append("Chocolate consumption", var[17]);
		aDoc.append("Cocaine consumption", var[18]);
		aDoc.append("Crack consumption", var[19]);
		aDoc.append("Ecstasy consumption", var[20]);
		aDoc.append("Heroin consumption", var[21]);
		aDoc.append("Ketamine consumption", var[22]);
		aDoc.append("Legal highs consumption", var[23]);
		
		aCollection.insertOne(aDoc);
		n++;
		
		}else {
				break;
			}
		}

		}
		
		}

		catch (Exception e) {

		e.printStackTrace();

		System.out.println(e.toString());

		}

		}
	

	

	
}
