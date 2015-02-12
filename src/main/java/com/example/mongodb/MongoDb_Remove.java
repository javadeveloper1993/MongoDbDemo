package com.example.mongodb;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author Maulik
 * 
 */
public class MongoDb_Remove {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(">>>>>>>>>>>>>>>>> MongoDb Remove Document Example");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Mongo Version : " + mongoClient.getVersion());
		System.out.println("Mongo Address : " + mongoClient.getAddress());

		System.out.println("Database Name : " + mongoClient.getDatabaseNames());
		DB db = mongoClient.getDB("Student");

		Set<String> collectionNames = db.getCollectionNames();
		System.out.println("Collection Names : " + collectionNames);

		DBCollection collection = db.getCollection("Info");

		BasicDBObject removeDocument = new BasicDBObject();
		removeDocument.put("age", 50);
		
		//collection.remove(removeDocument);
		System.out.println("Data Remove SuccessFully");

	}
}