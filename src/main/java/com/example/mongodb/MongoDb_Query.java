package com.example.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * @author Maulik
 * 
 */
public class MongoDb_Query {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(">>>>>>>>>>>>>>>>> MongoDb Query Document Example");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Mongo Version : " + mongoClient.getVersion());
		System.out.println("Mongo Address : " + mongoClient.getAddress());

		System.out.println("Database Name : " + mongoClient.getDatabaseNames());
		DB db = mongoClient.getDB("Student");

		Set<String> collectionNames = db.getCollectionNames();
		System.out.println("Collection Names : " + collectionNames);

		DBCollection collection = db.getCollection("Info");

		// Get Document Where Sport Like Cricket,Football
		BasicDBObject sportQuery = new BasicDBObject();
		List<String> sport = new ArrayList<String>();
		sport.add("Cricket");
		sport.add("Football");
		sportQuery.put("sports", new BasicDBObject("$in", sport));

		DBCursor find = collection.find(sportQuery);
		while (find.hasNext()) {
			System.out.println(find.next());
		}
		System.out.println("Data Get SuccessFully");

	}
}