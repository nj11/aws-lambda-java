package com.example.lambda.demo.widget.model;

public class WidgetRequest {
	//Attributes
	
    private String id;
    
    //Constructor.
    public WidgetRequest() {
    }
    
    public WidgetRequest(String id) {
        this.id = id;
    }
    
    //Getters and Setters.
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}