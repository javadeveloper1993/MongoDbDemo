package com.example.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author Maulik
 * 
 */
public class MongoDb_Insert {

	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Mongo Version : " + mongoClient.getVersion());
		System.out.println("Mongo Address : " + mongoClient.getAddress());

		System.out.println("Database Name : " + mongoClient.getDatabaseNames());

		DB db = mongoClient.getDB("Student");

		Set<String> collectionNames = db.getCollectionNames();
		System.out.println("Collection Names : " + collectionNames);

		DBCollection collection = db.getCollection("Info");

		// Insert Document Into Collection
		Info femateDatainfo = getStudentInfo(true);
		Info maleDataInfo = getStudentInfo1(true);

		// First Way
		ObjectMapper mapper = new ObjectMapper();
		DBObject dbObject = mapper.convertValue(
				createDBObject(femateDatainfo, true), BasicDBObject.class);
		//collection.insert(dbObject);
		System.out.println("dbObject :: " + dbObject);
		System.out.println("Data Inserted Sucessfully...!!!");

		// Second Way
		BasicDBObject insertData = mapper.convertValue(
				getInfoCollectionDocument(maleDataInfo, true),
				BasicDBObject.class);
		//collection.insert(insertData);
		System.out.println("BasicDbObject :: " + insertData);
		System.out.println("Data Inserted Sucessfully...!!!");
	}

	private static Info getStudentInfo(boolean isDisplaySport) {
		Info info = new Info();
		info.setTitle("Mrs");
		info.setFirstName("Megha");
		info.setMiddleName("PravinBhai");
		info.setLastName("Patel");
		info.setGender("Female");
		info.setBirthDate(new Date(1993, 5, 28));
		Address address = new Address();
		address.setPostalAddress("01/B,Nathala Socieaty");
		address.setCity("Dwarka");
		address.setCountry("India");
		address.setPinCode("354511");
		info.setAddress(address);
		info.setBirthDate(new Date(1198, 8, 25));
		info.setAge(36);
		info.setEmailId("megha98@gmail.com");
		info.setSkypeId("megha01");
		if (isDisplaySport) {
			List<String> sportList = new ArrayList<String>();
			sportList.add("Carrom");
			info.setSports(sportList);
		}
		return info;
	}

	private static Info getStudentInfo1(boolean isDisplaySport) {
		Info info = new Info();
		info.setTitle("Mr");
		info.setFirstName("Paresh");
		info.setMiddleName("RameshBhai");
		info.setLastName("Soni");
		info.setGender("Male");
		info.setBirthDate(new Date(1993, 5, 28));
		Address address = new Address();
		address.setPostalAddress("501/C,Maharaj Socieaty");
		address.setCity("Porbandar");
		address.setCountry("India");
		address.setPinCode("386541");
		info.setAddress(address);
		info.setAge(26);
		info.setEmailId("paresh004@gmail.com");
		info.setSkypeId("paresh004");
		if (isDisplaySport) {
			List<String> sportList = new ArrayList<String>();
			sportList.add("Cricket");
			sportList.add("Football");
			sportList.add("Hockey");
			info.setSports(sportList);
		}
		return info;
	}

	private static DBObject createDBObject(Info info, boolean isDisplaySport) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
		builder.append("title", info.getTitle());
		builder.append("firstName", info.getFirstName());
		builder.append("middleName", info.getMiddleName());
		builder.append("lastName", info.getLastName());
		builder.append("gender", info.getGender());
		builder.append("birthDate", info.getBirthDate());
		builder.append("address", info.getAddress());
		builder.append("age", info.getAge());
		builder.append("emailId", info.getEmailId());
		builder.append("skypeId", info.getSkypeId());
		if (isDisplaySport) {
			builder.append("sports", info.getSports());
		}
		return builder.get();
	}

	private static BasicDBObject getInfoCollectionDocument(Info info,
			boolean isDisplaySport) {
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("title", info.getTitle());
		basicDBObject.put("firstName", info.getFirstName());
		basicDBObject.put("middleName", info.getMiddleName());
		basicDBObject.put("lastName", info.getLastName());
		basicDBObject.put("gender", info.getGender());
		basicDBObject.put("birthDate", info.getBirthDate());
		basicDBObject.put("address", info.getAddress());
		basicDBObject.put("age", info.getAge());
		basicDBObject.put("emailId", info.getEmailId());
		basicDBObject.put("skypeId", info.getSkypeId());
		if (isDisplaySport) {
			basicDBObject.put("sports", info.getSports());
		}
		return basicDBObject;
	}
}
