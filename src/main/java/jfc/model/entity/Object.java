package jfc.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Object")  //Represents mongodb object
public class Object {

	@Id		//Represents id
	private String id;
}
