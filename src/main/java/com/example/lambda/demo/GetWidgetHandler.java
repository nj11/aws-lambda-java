package com.example.lambda.demo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambda.demo.widget.model.Widget;
import com.example.lambda.demo.widget.model.WidgetRequest;


/**
 * Lambda function.
  Input is WidgetRequest with an ID.
   When testing function pass input as JSON.
  {
  	"id":"1"
  }
  
  Output - Widget object with ID requested.
  NOTE:First time runs are always more expensive since the container needs to be setup.Subsequent calls are cheaper.
  Uploading function code to GetWidgetFunction...
  Upload success. Function ARN: arn:aws:lambda:us-east-2:069774747842:function:GetWidgetFunction
  Invoking function...
	==================== FUNCTION OUTPUT ====================
	{"id":"1","name":"Widget 1"}
	==================== FUNCTION LOG OUTPUT ====================
	START RequestId: 2d316836-ce53-11e8-850c-59f95a0fe2eb Version: $LATEST
	END RequestId: 2d316836-ce53-11e8-850c-59f95a0fe2eb
	REPORT RequestId: 2d316836-ce53-11e8-850c-59f95a0fe2eb	Duration: 6887.07 ms	Billed Duration: 6900 ms 	Memory Size: 512 MB	Max Memory Used: 67 MB	
	
*/



/**
 * For Lambda to be able to access your lambda function you have to create
 * an IAM role that gives it access to your resources.
 * Attach policy AmazonDynamoDBFullAccess to the role.
 * Attach policy AWSLambdaBasicExecutionRole to the role.
 *
*/
public class GetWidgetHandler implements RequestHandler<WidgetRequest, Widget> {
    @Override
    public Widget handleRequest(WidgetRequest widgetRequest, Context context) {
        // Create a connection to DynamoDB
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();

        // Build a mapper
        DynamoDBMapper mapper = new DynamoDBMapper(client);

        // Load the widget by ID
        Widget widget = mapper.load(Widget.class, widgetRequest.getId());
        if(widget == null) {
            // We did not find a widget with this ID, so return an empty Widget
            context.getLogger().log("No Widget found with ID: " + widgetRequest.getId() + "\n");
            return new Widget();
        }
        
        // Return the widget
        return widget;
    }
}