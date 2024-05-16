// Controller class for the question list scene, allows the user to display all the possible questions which may be chosen.

package datastructures;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

import datastructures.mcq_template.MCQBinaryTree;
import datastructures.tof_template.TOFBinaryTree;

public class QuestionList {

     private Main main;
    private MCQBinaryTree mcqBst;
    private TOFBinaryTree tofBst;

    public void setMain(Main main) {
        this.main = main;
    }
     @SuppressWarnings("exports")
    public void setMCQBinaryTree( MCQBinaryTree mcqBst) {
        this.mcqBst = mcqBst;
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
    TextArea questionListTextArea;

    @FXML
    // Method to handle the functionality for displaying and clearing questions on the text area when the button is pressed.
    public void handleDisplayQuestions() {
        questionListTextArea.clear();
         questionListTextArea.appendText(mcqBst.getMQCTreeAsString());
         questionListTextArea.appendText(tofBst.getTOFTreeAsString());   
    }
}