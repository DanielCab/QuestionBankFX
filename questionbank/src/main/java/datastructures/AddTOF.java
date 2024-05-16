// Controller class for the add TOF scene, allows the user to add true or false questions to the TOF binary tree.

package datastructures;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import datastructures.tof_template.TNodeData;
import datastructures.tof_template.TOFBinaryTree;

public class AddTOF {

    private Main main;
    private TOFBinaryTree tofBst;

    public void setMain(Main main) {
        this.main = main;
    }

    @SuppressWarnings("exports")
    public void setTOFBinaryTree( TOFBinaryTree tofBst) {
        this.tofBst = tofBst;
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
    Button TOFsubmit;
    @FXML
    TextField TOFQuestion;
    @FXML
    TextField TOFanswer;
    @FXML
    TextField TOFID;

    @FXML
    public void handleSubmitTOF() { 
        
        if (TOFID.getText().isEmpty() || TOFQuestion.getText().isEmpty() || TOFanswer.getText().isEmpty()) { 
            System.out.println("Make sure you have entered all information necessary!");
            return; // Exit the method if any field is empty
        }

        String inputtedID = TOFID.getText();
        String inputtedQuestion = TOFQuestion.getText();
        String inputtedAnswer = TOFanswer.getText();
    
        if (tofBst.justFindNoInsert(inputtedID) != null) {
            System.out.println("Question ID already exists! Please enter a unique ID.");
            return; // Exit the method if the question ID already exists
        }
            if ("true".equals(inputtedAnswer)) { 
                tofBst.findOrInsert(new TNodeData(inputtedID, inputtedQuestion, inputtedAnswer, "false"));
            } else { 
                tofBst.findOrInsert(new TNodeData(inputtedID, inputtedQuestion, inputtedAnswer, "true"));
            }
        TOFQuestion.clear();
        TOFID.clear();
        TOFanswer.clear();
    }
}

