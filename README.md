# PVAI-UI-Test Coding Challenge

Home Values Site Automation: http://www.homegain.com/homevalues.
Test Steps:
1. Landing on the Home page, entering a valid Zip Code
2. Selection of the Home Values page on the subsequent form
3. Testing “Search Home Values” form by entering various input values per field and
validating the response.

The project has been devloped using Java, Selenium Webdriver, Maven and TestNg. I have developed an end to end solution using page objects model design pattern. Also I have made use of reusuable methods and maintained separate config, testdata and util file. Tests can be accessed at src/test/java/com/pvai/qa/testcases directory


Please follow the below steps to execute the code.

1. Clone project from github location https://github.com/roop983/PVAI-UI-Test
2. Upload the project in an IDE (Eclipse) and run the testng.xml file (/PVAI-UITest/testng.xml) or else run as Maven test
3. To run in the terminal, navigate to the local project path and execute the below maven commands:
mvn clean
mvn install
mvn test
NOTE: Ensure Chrome browser is present, as this project is designed to run only in this browser.

