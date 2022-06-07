# HelloWorldLambdaJava

Creates and deploys a "Hello World" AWS Lambda function, implemented in Java.

## Prerequisites

* Created: An AWS account, and an S3 bucket for storing temporary deployment artifacts (referred to as $CF_BUCKET below)
* Installed: AWS CLI, Maven, SAM CLI
* Configured: AWS credentials in your terminal


## Usage

To build:

```
$ mvn package
```

Create a Staging bucket (if one doesn't already exist):

```
$ export CF_BUCKET=testbucketgmb1
$ aws s3 mb s3://$CF_BUCKET
```

To deploy (with template.yaml for deploy definition):

```
$ sam deploy --s3-bucket $CF_BUCKET --stack-name HelloWorldLambdaJava --capabilities CAPABILITY_IAM
```


### To test:

The above will create a new function in Lambda, so you can test via the Lambda web console,
or via the CLI using `aws lambda invoke`.

(Base64 encode the payload first)
```
$ echo '[1, 2, 3]' | base64
WzEsIDIsIDNdCg==

aws lambda invoke  --function-name HelloWorldJavaGB --payload WzEsIDIsIDNdCg==  outputfile.txt
{
    "StatusCode": 200,
    "ExecutedVersion": "$LATEST"
}

```

###To teardown:

```
$ aws cloudformation delete-stack --stack-name HelloWorldLambdaJava
```

## More Information

Please see https://github.com/symphoniacloud/sam-init-HelloWorldLambdaJava for more information.
