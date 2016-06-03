Feel free to reach out at http://www.automatethebox.com/2014/01/selenium-webdriver-selenium-2-java.html to share any new suggesstion to improve the framework and add more features.

#Selenium Webdriver Java Tests

## Description
This is Selenium 2 framework created using the latest Selenium 2 features with Java, TestNG and Maven and
soon we gonna add some new technologies like ReportNG and Google Guice dependency injection framework.This framework is
open to use as you want and mainly for those people who want to automate the web apps using Selenium 2 but needs some
help to get Started. So when you use it don't forget to leave your comments and you can also report an issue/requests/
enhancements if you like, we will definitely look into that and provide the solution

## Features
1. PageObjects with LoadableComponent design Pattern [ http://code.google.com/p/selenium/wiki/DesignPatterns ]
2. Object oriented Architecture
3. Rich TestNG test framework support [ http://testng.org/doc/index.html ]
4. Maven Support - Software project management and comprehension tool [ http://maven.apache.org/ ]
5. Support execution on latest firefox and Google Chrome and Internet Explorer browsers [windows only]

## Test Application
We have used functionally rich and well known Facebook as test application, so it would be easier to understand the
framework and then implement the same for your project as per your requirements.

## Automated Tests
1. Login/Logout to Facebook.
2. Facebook user status update - text status only.

## Prerequisites Software/Tools
1. Git [ http://git-scm.com/downloads ]
2. Maven [ http://maven.apache.org/ ]
3. Java Development Kit 7
4. Java Runtime Environment 7
5. IDE [ I prefer IntelliJ IDEA  for development :) ]

## Getting Started [ On Windows ]
1. Open the Git bash and clone the project using below command on the target directory:
     git clone https://github.com/lalit-k/selenium-java-tests.git
2. Once the project is cloned successfully go the the project directory and set the facebook user name and password
   values in testng-facebook.xml as:
     <parameter name="facebook_user_name" value="testuser@facebook.com"/>
     <parameter name="facebook_user_password" value="password"/>
3. Open the windows command prompt 'cmd' and navigate to the project directory 'selenium-webdriver-tests'.
4. Run the below command to start the tests.
     mvn clean test
