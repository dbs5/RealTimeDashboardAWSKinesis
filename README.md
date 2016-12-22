# RealTimeDashboardAWSKinesis

Sample Project and required script for my Walkthrough of "Building a near RealTime Dashboard with AWS Kinesis"

## CloudFormation
- The Template is build for use in eu-west-1 (Ireland, Dublin). If you want to use it in a different region you have to change the following
    - set lines 173 and 181 to the AZs for the region you are in
    - set line 21 to the AMI IDs of Ubuntu Server 16.04 LTS in your region
- An existing keypair named *kp_Dashboard* is required
- An existing Certificate and HostedZone are required