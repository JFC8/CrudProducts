package jfc.mongoDBTests;

import org.bson.Document;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Following imports are necessary for MongoDB
import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import jfc.model.entity.Product;

public class ProductTests {

	private static final String CONNECTION_STRING = "mongodb://localhost:27017/";
	@Test
	@Order(1)
	public void testInsertProduct() throws Exception {
		try {

			//TEST CONNECTION
			MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
			MongoDatabase db = mongoClient.getDatabase("CrudProducts");
			MongoCollection<Document> table = db.getCollection("Products");
		
			//INSERT
			Document document = new Document();
			document.put("code", "12345");
			document.put("code2", "c2_12345");
			document.put("name", "test_product");
			document.put("description", "test_description");
			document.put("description2", "test_description2");
			document.put("category", "test_category");
			table.insertOne(document);
			
			Document document2 = new Document();
			document.put("code", "1234567");
			document.put("code2", "c2_1234567");
			document.put("name", "test_product");
			document.put("description", "test_description");
			document.put("description2", "test_description2");
			document.put("category", "test_category");
			table.insertOne(document2);
			
			Document document3 = new Document();
			document.put("code", "12345678");
			document.put("code2", "c2_12345678");
			document.put("name", "test_product");
			document.put("description", "test_description");
			document.put("description2", "test_description2");
			document.put("category", "test_category");
			table.insertOne(document3);
			
			//CHECK
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("code", "12345");

			MongoCursor<Document> cursor = table.find(searchQuery).cursor();
			
			while (cursor.hasNext()) {
				Document object = cursor.next();
				assertEquals("12345", object.get("code").toString());
				assertEquals("c2_12345", object.get("code2").toString());
				assertEquals("test_product", object.get("name").toString());
				assertEquals("test_description", object.get("description").toString());
				assertEquals("test_description2", object.get("description2").toString());
				assertEquals("test_category", object.get("category").toString());
			}

		} catch (MongoException e) {
			e.printStackTrace();
			fail("There has been an Exception: " + e.getMessage());
		}
	}

	@Test
	@Order(2)
	public void testUpdateProduct() throws Exception{
	
		try {
			
			//TEST CONNECTION
			MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
			MongoDatabase db = mongoClient.getDatabase("CrudProducts");
			MongoCollection<Document> table = db.getCollection("Products");
			
			//UPDATE
	        BasicDBObject query = new BasicDBObject();
	        query.put("code", "1234567");
	        
	        BasicDBObject newDocument = new BasicDBObject();
	        //Changing description2
	        newDocument.put("description2", "new_test_description2");
	        // Adding a new column
	        newDocument.put("characteristics", "test_characteristic");
	
	        BasicDBObject updateObj = new BasicDBObject();
	        updateObj.put("$set", newDocument);
	        table.updateOne(query, updateObj);
	
	        //CHECK
	        BasicDBObject searchQuery 
	            = new BasicDBObject().append("code", "1234567");
	
	        MongoCursor<Document> cursor = table.find(searchQuery).cursor();
	        while (cursor.hasNext()) {
	            Document object = cursor.next();
	            assertEquals("1234567", object.get("code").toString());
				assertEquals("c2_1234567", object.get("code2").toString());
				assertEquals("test_product", object.get("name").toString());
				assertEquals("test_description", object.get("description").toString());
				assertEquals("test_description2", object.get("description2").toString());
				assertEquals("test_category", object.get("category").toString());
				assertEquals("test_characteristic", object.get("characteristics").toString());
	        }
	        
		} catch (MongoException e) {
			e.printStackTrace();
			fail("There has been an Exception: " + e.getMessage());
		}
	}
	
	@Test
	@Order(3)
	public void testDeleteProduct() throws Exception{
		
		try {
			
			//TEST CONNECTION
			MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
			MongoDatabase db = mongoClient.getDatabase("CrudProducts");
			MongoCollection<Document> table = db.getCollection("Products");
			
			//TODO
			//DELETE
	        BasicDBObject query = new BasicDBObject();
	        query.remove("code", "12345678");
	        

	        //CHECK
	        BasicDBObject searchQuery 
	            = new BasicDBObject().append("code", "12345678");
	
	        
	        MongoCursor<Document> cursor = table.find(searchQuery).cursor();
	        while (cursor.hasNext()) {
	            Document object = cursor.next();
	            assertEquals("0", object.get("code").toString());
				assertEquals("0", object.get("code2").toString());
				assertEquals("0", object.get("name").toString());
				assertEquals("0", object.get("description").toString());
				assertEquals("0", object.get("description2").toString());
				assertEquals("0", object.get("category").toString());
				assertEquals("0", object.get("characteristics").toString());
	        }
	        
		} catch (MongoException e) {
			e.printStackTrace();
			fail("There has been an Exception: " + e.getMessage());
		}
	}
	

}
