// Main class that launches the application and holds the loading methods for the different fxml scenes.

package datastructures;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import datastructures.mcq_template.*;
import datastructures.tof_template.*;


public class Main extends Application {

    private Stage primaryStage;
    private TOFBinaryTree toftree;
    private MCQBinaryTree mcqtree;


    @Override
    @SuppressWarnings("exports")
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        // Load home page and initialize both question type trees on app launch
        loadHomePage();
        toftree = new TOFBinaryTree();
        mcqtree = new MCQBinaryTree();
    
        primaryStage.setTitle("Question Bank");
        primaryStage.show();
    }

// Method to load the home page scene and assign the loader and controller to the respective HomePage assests.
    private void loadHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 640, 400);
        
        HomePage controller = loader.getController();
        controller.setMain(this);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

// Method to load the question list display scene and assign the loader and controller to the respective QuestionList assests.
    public void loadQuestionList() throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QuestionList.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,640,400);

        QuestionList controller = loader.getController();
        controller.setMain(this);
        controller.setMCQBinaryTree(mcqtree);
        controller.setTOFBinaryTree(toftree);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

// Method to load the custom output page and assign the loader and controller to the respective CustomOutput assests.
    public void loadCustomOutput() throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomOutput.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,640,400);

        CustomOutput controller = loader.getController();
        controller.setMain(this);
        controller.setMCQBinaryTree(mcqtree);
        controller.setTOFBinaryTree(toftree);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

// Method to load the adding multiple choice question page and assign the loader and controller to the respective AddMCQQuestion assests.
    public void loadAddMcq() throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMCQuestion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,640,400);

        AddMcq controller = loader.getController();
        controller.setMain(this);
        controller.setMCQBinaryTree(mcqtree);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

// Method to load the adding true or false question page and assign the loader and controller to the respective AddTOFQuestion assests.
    public void loadAddTOF() throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTOFQuestion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,640,400);

        AddTOF controller = loader.getController();
        controller.setMain(this);
        controller.setTOFBinaryTree(toftree);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
