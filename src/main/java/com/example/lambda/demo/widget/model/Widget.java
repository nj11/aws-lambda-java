package com.example.lambda.demo.widget.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Widget POJO.
 * @author natasha.juneja
 *
 */
@DynamoDBTable(tableName="Widget")
public class Widget {
	
	//Attributes.
	
    private String id;
    private String name;
    
    //Constructors.
    public Widget() {
    }
    
    
    public Widget(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    //Getters and Setters.
    
    @DynamoDBHashKey(attributeName="id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    @DynamoDBAttribute(attributeName="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}