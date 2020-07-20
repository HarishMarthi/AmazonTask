
===== Project Name ======  AmazonAutomation

=====  Project Description  =====  
Writing the Automation Script for Amazon Application
===== Tools Using ===== 

   Programming Language : Java(can be use the JDK 8 and above)
   Automation Tool : Selenium WebDriver 3.141.59
   Framework Used : Hybrid Framework(BDD Cucumer, POM with Page Factory, Junit, Cucumber JVM Reports)
   Reports : Custom HTML reports
   Build Tool : Maven
   
   
===== How to Run =====  

===== 1st Method =====  

Run through Junit file : In the project root node there is a "TestRunner,java" file. Right click on it and choose 
	run as then click on "JUnit Test" Option.
	

===== 2nd Method =====  

Run through POM file : In the project root node there is a "pom.xml" file. Right click on it and choose 
	run configuration for maven build as "mvn clean verify".
	

=====  Reports Path ===== 

After completion of the script execution reports will be saved in "AmazonAutomation/target/cucumber-jvm-report/cucumber-html-report" folder.



===== How Framework Will Work ========

1. Once run the project through TestRunner.java or pom.xml file then control will move to feature file to read steps

2. After that control will move to step definitions package to read the glue code.

3. From step definitions control move to Page files to do actual test execution.

2. In the test base class we are maintaining the driver details and launching the browser.

3. Utils containing the utility method for the the project.

5. Configuration file having all the config details for the drivers, driver keys and app url etc..

6. Finally reports will be stored under "AmazonAutomation/target/cucumber-jvm-report/cucumber-html-report" folder.

7. Here we are using the cucumber JVM reports

8. After every test case or test scenario is completed browser will close and again it will open for next test case or test scenario




