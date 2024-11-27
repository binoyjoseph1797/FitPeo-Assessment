## Project Overview
This project is a Selenium-based automation testing suite developed in Java using the TestNG framework. 
It focuses on verifying functionalities of a webpage, including navigation, form handling, slider interactions, 
and revenue calculations.

### 1. Folder Structure
Organize the project files systematically:
project/
├── base/
│   ├── Constants.java        # Stores reusable constants
│   └── TestBase.java         # Manages WebDriver setup and configurations
├── elementsAndActions/
│   └── HomePage.java         # Contains methods to interact with webpage elements
├── runner/
│   └── HomeRun.java          # Main test class with TestNG annotations
├── resources/
│   └── chromedriver.exe      # WebDriver for Chrome
├── test-output/              # Generated TestNG reports
├── pom.xml                   # Maven configuration for dependencies
└── testng.xml                # TestNG configuration file

### 2. Technologies Used
Programming Language: Java
Automation Tool: Selenium WebDriver
Test Framework: TestNG
Build Tool: Maven
Browser Driver: ChromeDriver

### 3. Setting Up the Project
#### Prerequisites
Install Java Development Kit (JDK).
Set up an Integrated Development Environment (IDE) Eclipse.
Install Maven.
Download ChromeDriver and ensure it matches your Chrome browser version.

#### Installation
Clone the repository:
bash
Copy code
git clone <https://github.com/binoyjoseph1797/FitPeo-Assessment.git>
Navigate to the project directory:
bash
Copy code
cd project
Install dependencies using Maven:
Copy code
mvn clean install

#### Running Test
You can run tests using the TestNG framework by leveraging the testng.xml configuration file. It allows you to define and manage your test suite effectively.

Using testng.xml in IDE
Open your project in a Eclipse.
Locate the testng.xml file in the root directory.
Right-click on the testng.xml file and select:
Run As > TestNG Suite (in Eclipse).
