# Exam Question Bank Java

This is the exam question bank application built in Java using Apache Maven and JavaFX for the UI, the app allows you to add
two types of questions and their associated answers: 

 - Multiple Choice
 - True or False

You may then choose to select one or both types of questions along with an amount 
to be retrieved and the program will take a random amount of questions that fit the query
and output them into the output.txt file. 

### Compilation

Once you have downloaded the files and all the additional dependencies, follow the steps below:  

- cd into directory housing your pom.xml file
- in your terminal run the 'mvn clean install' command
- this will create a target folder in your project folder, cd into the target folder
- now run the 'java --module-path "path to your javafx lib" --add-modules javafx.controls,javafx.fxml -jar nameofyourjar.jar

### Functionality 

Once you have compiled and lauched the application, you may see the different menu with a 
multitude of items that correspond to different functions in the program. 

The Question List menu item allows you to display all the questions which you have created. 

The Add MCQ and Add T/F menu items allow you to create questions to be stored in the question bank.

Lastly the Custom Output menu item allows you to input the amount and type of questions to be retrieved onto your output file.

### Output 

Once you have added questions into the bank and have selected the amount and type of questions
to be outputted, a file named output.txt will be created in the same project directory.

Keep in mind that editing this file while the program is running will cause the file to stop 
outputting the desired selection of questions and you will have to delete the file for a new one to be created.

### <u>Requirements</u>

##### Java Development Kit (JDK)

- Version: 21
- Ensure that Java 21 is installed and properly set up on your system. You can verify the installation by running java -version in your terminal or command prompt.

##### Apache Maven

- Version: 3.8.0 or later
- Maven is used to manage the build lifecycle and dependencies. You can verify the installation by running mvn -version in your terminal or command prompt.

##### JavaFX SDK

- Version: 21
- The project depends on JavaFX for building the user interface. Ensure that JavaFX SDK version 21 is included in your project dependencies and properly configured.
