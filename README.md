# HousecallPro

# Short description
This repository contains setup for test automation of Housecall Pro application.
Following tools are used:
java 17, selenium 4, cucumber 7, maven, spring framework, assertJ, lombok.

# How to run test
Test is stored in \resources\features directory. Iy can be run using chrome or edge web browsers.
In order to run it please launch following maven command for chrome v.110
```sh
mvn clean verify -Dspring.profiles.active=chrome 
```
or for edge v.110
```sh
mvn clean verify -Dspring.profiles.active=edge
```

# Selenium drivers update
Selenium drivers are stored in \resources\drivers directory.
Drivers are compatible with Windows, if you need to run in on macOS, please replace 
chromedriver.exe and msedgedriver.exe with macOS compatible versions.

# Test reports
Test reports are generated after each test run and are stored in
\target\cucumber-report\cucumber.html

If test fails, cucumber reports shows assertion stacktrace and screenshot. 
Screenshot are taken only for failed tests.


