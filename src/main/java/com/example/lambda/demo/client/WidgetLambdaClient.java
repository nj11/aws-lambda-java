package com.example.lambda.demo.client;

//AWS  SDK Imports...
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

/**
 * Demo invocation of a lambda function via client.
 * Note : permissions must be set properly for the  code to work.
 * 
 * 1.For Lambda to be able to access your lambda function you have to create
 * an IAM role that gives it access to your resources.
 * Attach policy AWSLambdaBasicExecutionRole to the role.
 * Attach policy AmazonDynamoDBFullAccess to the role.
 *
 * 2.Also create a S3 bucket where lambda function
 *  will get uploaded before it's run.s3 bucket should be
 *  in the same region as lambda function.
 *  
 * 3.User whose access key id and secret access key are used to
 *   run the client should be granted the role you created in step 1.
 *  
*/

public class WidgetLambdaClient {

	public static void main(String[] args) {
		
		String functionName = "GetWidgetFunction";
		System.out.println("=========================================");
		System.out.println("Invoking LAMBDA client for function :: " + functionName);
		
		System.out.println("\n");
		
		// (1) Define the AWS Region in which the function exists.
		Regions region = Regions.fromName("us-east-2");
		
		AWSLambdaClientBuilder builder = AWSLambdaClientBuilder.standard()
                .withRegion(region);
		
		// (3) Build the client, which will ultimately invoke the function
		AWSLambda lamdaClient = builder.build();
		
		// (4) Create an InvokeRequest with required parameters
		InvokeRequest req = new InvokeRequest()
		                           .withFunctionName("GetWidgetFunction")
		                           .withPayload("{ \"id\": \"1\"}"); //optional pay load..
		
		try {
			// (5) Invoke the function and capture response
			InvokeResult result = lamdaClient.invoke(req);
			
			 // We should validate the response
            System.out.println("Response Status Code :: " + result.getStatusCode()); //200 IS OK.
            
            // Get the response as JSON
            String json = new String(result.getPayload().array(), "UTF-8");
            
            // Show the response; we could use a library like Jack son to convert this to an object
            System.out.println("Response JSON :: " + json);
            
            System.out.println("\n");
            
            System.out.println("Lambda  invocation completed successfully for function ::" + functionName);
			
		}
		catch(Exception e) {
			System.out.println("Error occured when executing the lambda function :: " + functionName);
			e.printStackTrace();
		}
		finally {
			System.out.println("\n================END=====================");
		}
		
	}//end main.

}
