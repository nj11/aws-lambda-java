package com.example.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

//Reference : https://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/lambda-tutorial.html
	
/**
 * 1.For Lambda to be able to access your lambda function you have to create
 * an IAM role that gives it access to your resources.
 * Attach policy AWSLambdaBasicExecutionRole to the role.
 *
 * 2.Also create a S3 bucket where lambda function
 *  will get uploaded before it's run.s3 bucket should be
 *  in the same region as lambda function.
 *  
*/

/**
 * Simple Hello World Lambda function.
 * Takes an input when the function is run and returns "Hello,<input>" as output. 
 *
*/

public class Hello implements RequestHandler<Object, String> {

	//Context object- provides information about your function
	//and the environment in which it's running.
	@Override
	public String handleRequest(Object input, Context context) {
		 context.getLogger().log("Input: " + input);
		 String output = "Hello, " + input + "!";
		 return output;
	}//end handleRequest

	
}//end Hello class.
