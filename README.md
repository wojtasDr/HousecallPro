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
for edge v.110
```sh
mvn clean verify -Dspring.profiles.active=edge
```

for chrome v.110 on mac_64
```sh
mvn clean verify -Dspring.profiles.active=chromeMac
```


# Selenium drivers update
Selenium drivers are stored in \resources\drivers directory.
Drivers are compatible with Windows and macOS (mac_64), if you need to run test on mac m1 , please replace 
chromedriver with compatible version. The same for web browsers versions.

# Test reports
Test reports are generated after each test run and are stored in
\target\cucumber-report\cucumber.html

If test fails, cucumber reports shows assertion stacktrace and screenshot. 
Screenshot are taken only for failed tests.


