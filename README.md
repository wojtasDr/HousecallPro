# HousecallPro

# Short description
This repository contains setup for test automation of Housecall Pro application.
Following tools are used:
java 17, selenium 4, cucumber 7, maven, spring framework, assertJ, lombok.

# How to run test
Test is stored in \resources\features directory. I can be run using chrome or edge web browsers.
In order to run it launch following maven command
mvn clean verify -Dspring.profiles.active=chrome
mvn clean verify -Dspring.profiles.active=edge

# Selenium drivers update
Selenium drivers are stored in \resources\drivers directory.
Drivers are compatible with Windows OS, if you need to run in on MacOS please replace 
chromedriver.exe and msedgedriver.exe with MacOS compatible versions.

# Test reports
Test reports are generated after each test run and stored in
\target\cucumber-report\cucumber.html

If test fails cucumber reports shows Assertion stacktrace and screenshot. 
Screenshot are taken only for failed tests.


