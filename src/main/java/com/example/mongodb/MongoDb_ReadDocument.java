package com.example.mongodb;

import java.net.UnknownHostException;
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
public class MongoDb_ReadDocument {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(">>>>>>>>>>>>>>>>> MongoDb Get Document Example");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Mongo Version : " + mongoClient.getVersion());
		System.out.println("Mongo Address : " + mongoClient.getAddress());

		System.out.println("Database Name : " + mongoClient.getDatabaseNames());

		DB db = mongoClient.getDB("Student");

		Set<String> collectionNames = db.getCollectionNames();
		System.out.println("Collection Names : " + collectionNames);

		DBCollection collection = db.getCollection("Info");
		BasicDBObject search = new BasicDBObject();
		BasicDBObject search1 = new BasicDBObject();
		search1.put("$gt", 18);
		search.put("age", search1);

		BasicDBObject projection = new BasicDBObject();
		projection.put("age", true);
		projection.put("_id", false);
		DBCursor find = collection.find(search, projection);
		while (find.hasNext()) {
			System.out.println(find.next());
		}
		System.out.println("Data Get SuccessFully");

	}
}