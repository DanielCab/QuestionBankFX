// Controller class for the add mcq scene, allows the user to add multiple choice questions to the MCQ binary tree.

package datastructures;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import datastructures.mcq_template.MCQBinaryTree;
import datastructures.mcq_template.NodeData;

public class AddMcq {

    private Main main;
    private MCQBinaryTree mcqBst;

    public void setMain(Main main) {
        this.main = main;
    }

    @SuppressWarnings("exports")
    public void setMCQBinaryTree( MCQBinaryTree mcqBst) {
        this.mcqBst = mcqBst;
    }

    @FXML
    private void handleQuestionList(ActionEvent event) throws IOException {
        main.loadQuestionList();
    }
    @FXML
    private void handleCustomOutput(ActionEvent event) throws IOException {
        main.loadCustomOutput();
    }
    @FXML
    private void handleAddMCQ(ActionEvent event) throws IOException {
        main.loadAddMcq();
    }
    @FXML
    private void handleAddTOF(ActionEvent event) throws IOException {
        main.loadAddTOF();
    }

    @FXML
    Button MCQSubmit;
    @FXML
    TextField MCQuestion;
    @FXML
    TextField MCQanswer;
    @FXML
    TextField MCQchoice2;
    @FXML
    TextField MCQchoice3;
    @FXML
    TextField MCQchoice4;
    @FXML
    TextField MCQID;

    @FXML
    public void handleSubmitMCQ() { 
        if(MCQID.getText().isEmpty()|| MCQuestion.getText().isEmpty()|| MCQID.getText().isEmpty() || MCQchoice2.getText().isEmpty() || MCQchoice3.getText().isEmpty() || MCQchoice4.getText().isEmpty() ) { 
            System.out.println("Make sure you have entered all information necessary!");
            return; // Exit the method if any field is empty
        } 

        String inputtedID = MCQID.getText();
        String inputtedQuestion = MCQuestion.getText();
        String inputtedAnswer = MCQanswer.getText();
        String inputted2ndChoice = MCQchoice2.getText();
        String inputted3rdChoice = MCQchoice3.getText();
        String inputted4thChoice = MCQchoice4.getText();
        
        // Checking if the ID inputted already exists in the binary tree.
        if(mcqBst.justFindNoInsert(inputtedID) != null){
            System.out.println("Question ID already exists! Please enter a unique ID.");
            return; // Exit the method if the question ID already exists
        }

        mcqBst.findOrInsert(new NodeData(inputtedID, inputtedQuestion, inputtedAnswer, inputted2ndChoice, inputted3rdChoice, inputted4thChoice));
        MCQID.clear();
        MCQuestion.clear();
        MCQanswer.clear();
        MCQchoice2.clear();
        MCQchoice3.clear();
        MCQchoice4.clear();
    }

    
}