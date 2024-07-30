# QA_NYTIMES
# Overview
QA_NYTIMES is a project that automates the testing of the New York Times website using Selenium WebDriver and TestNG framework. It aims to ensure the quality and functionality of the website through automated test cases.

# Project Structure
**.idea**: IntelliJ IDEA configuration files.                                                                        
**AmsReports**: Directory containing report files.                                                
**src**: Source code for test scripts.                                                        
**test-output**: Directory containing test output results.                                                        
**.gitignor**e: Git ignore file.                                                        
**pom.xml**: Maven project file for managing dependencies.                                                        
**testng.xml**: TestNG configuration file.                                                                

# Technologies Used
**Selenium WebDriver:** For browser automation.                                                                        
**TestNG**: For organizing and running test cases.                                                                        
**Maven**: For dependency management and build automation.                                                                        
**Java**: Primary programming language.                                                                        
**HTML, CSS, JavaScript:** For web interactions.                                                                        

# Getting Started
# Prerequisites
Java Development Kit (JDK)                                                                                                
Maven                                                                                                
IntelliJ IDEA or any other IDE                                                                                                

# Installation
# Clone the repository:
git clone https://github.com/pallavchaturvedi-nagarro/QA_NYTIMES.git
# Navigate to the project directory:
cd QA_NYTIMES
# Install dependencies:
mvn clean install

# Running Tests
Open the project in IntelliJ IDEA.                                                                
Execute the tests using TestNG:                                                                                
Right-click on testng.xml.                                                                        
Select "Run 'testng.xml'".                                                                                

# Running Tests using CLI                                                                                                        
Navigate to the project directory and execute below code:                                                                                 
mvn clean test

# Running Tests on different browser
\src\main\resources\config\AmsConfig.properties

Change the browser type to below in the above mentioned config file for running on different browser:                  
Chrome(Currently set)                                                                                  
Edge                                                                                                      
Firefox                                                                                                            


# Test Cases Overview
Below mentioned **5 Test cases** were covered under **3 Test classes**:

**1. NYLoginPageTest :**                                                                                
**verifyNYLoginFunctionality :** This will validate the Login Functionality with Valid credentials and under this test we are doing test for page navigation post Valid login and this will explicitely fail.                                                        
**verifyLoginFunctionalityUsingInvalidCredentials:** This will validate the Login Functionality with InValid credentials and validate the Alert Message.
                                                                                                
**2. NYHomePageTest :**                                                                                          
**ValidateDate** : This will validate the Date on the home screen with the system date i.e. if we are displaying the correct data for current date.                                                                                      
**validatePageNavigationOnClick** : This will validate the navigation and hover functioanlity on Homescreen and clicking on link post hover.                                                                                                                                           
**3. SearchTest :**                                                
**validateSearchFunctionality** : This will validate the Search functionality on Homepage.


        
            
