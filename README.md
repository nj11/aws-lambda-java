# AWS SDK usage for running server less Lambda functions inside Java function.

A simple Java application illustrating usage of the AWS SDK API for running AWS Lambda functions.

## Setup.

1.You need to create a AWS user and generate access keys for this user.This user must have
  the necessary permissions. 

Install AWS CLI and then run command aws configure to generate aws credentials file at the
(C:\Users\USER_NAME\.aws\credentials for Windows users)  location.

    [default]
    aws_access_key_id = <your access key id>
    aws_secret_access_key = <your secret key>
    
2.Create an S3 bucket to store the AWS functions created.

3.If invoking function via eclipse SDK install the AWS toolkit for eclipse plugin.( https://aws.amazon.com/eclipse/ )  

4.You can also invoke lambda function via the client code under com.example.lamda.demo.client package.    


## Reference

https://docs.aws.amazon.com/general/latest/gr/aws-sec-cred-types.html#access-keys-and-secret-access-keys

https://docs.aws.amazon.com/cli/latest/userguide/awscli-install-windows.html

https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html






