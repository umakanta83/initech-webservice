Email and Phone Number Masking Utility
This is Java utility to mask the email address and phone number

Technology Stack: Java 8,Junit 4.12, maven 3.2 

This project contains .
MaskStringUtil.java -  utility java class  masks the string input with given masking character
MaskStringUtilTest.java - Test class to test the utility java class.

Seeting up workspace and creating jar From eclipse import as  mvn project and run the command mvn clean install

You can create the jar (Initech-WS-Utility.jar) and put as dependency in to your project 

To Run the application from eclipse

Step1. Run As Java Application 

To test the application from eclipse

Step2: Run as Junit 


This Utility does the following steps.

1. It checks input string is valid email address or not, if it is valid email address it masks the all the characters email address except first and last character of email ID and append the '@' domain to the end as domain won't get masked.
For Eg: If your input is "umakanta@gmail.com" and masking char is "*" then it will mask to "u******a@gmail.com".
2. If it is 2 char email Id then it masks like below
For Eg: If your input is "uk@gmail.com" and masking char is "*" then it will mask to "**@gmail.com".

3.If it is 1 char email Id then it masks like below
For Eg: If your input is "u@gmail.com" and masking char is "*" then it will mask to "*@gmail.com".

4.It also check input string is valid phone number or not. It only supports phone number in below formats 
Format 1: 1234567890 (phone number with country code)
Format 2:234567890(phone number with out country code)
Format 3:123-567-8905(phone number with '-' separator)
It doesn't support phone number separated by space " " like 123 567 8905 or with extension.

5.If it is valid phone number it masks the middle three digits with provided masking character
For eg:if phone number is "1234567890", after masking the new masking string will be "123***7890"
If phone number is "123-567-8905" then the new masked string will be "123-***-8905".

6.This utility make sure the input string is not lost , hence if it is not valid email address or not valid phone number then 
it will return the input string



















