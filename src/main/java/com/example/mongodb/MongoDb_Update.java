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
public class MongoDb_Update {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(">>>>>>>>>>>>>>>>> MongoDb Update Document Example");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Mongo Version : " + mongoClient.getVersion());
		System.out.println("Mongo Address : " + mongoClient.getAddress());

		System.out.println("Database Name : " + mongoClient.getDatabaseNames());
		DB db = mongoClient.getDB("Student");

		Set<String> collectionNames = db.getCollectionNames();
		System.out.println("Collection Names : " + collectionNames);

		DBCollection collection = db.getCollection("Info");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("$set", new BasicDBObject().append("age", 5));
		System.out.println(newDocument);

		BasicDBObject searchQuery = new BasicDBObject().append("age", 26);
		System.out.println(searchQuery);

		//collection.update(searchQuery, newDocument, false, true);

		System.out.println("Data Update SuccessFully");

	}
}