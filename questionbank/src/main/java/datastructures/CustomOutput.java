// Controller class for the custom output scene, allows the user to request a custom output of questions.

package datastructures;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import datastructures.mcq_template.MCQBinaryTree;
import datastructures.tof_template.TOFBinaryTree;

public class CustomOutput {

    private Main main;
    private MCQBinaryTree mcqBst;
    private TOFBinaryTree tofBst;

    public void setMain(Main main) {
        this.main = main;
    }


    private static void saveToFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
         writer.close();
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
CheckBox TOFbox;
@FXML
CheckBox MCQbox;
@FXML
TextField TOFAmount;
@FXML
TextField MCQAmount;
@FXML
Button customSubmit;

@FXML
private void handleCustomSubmit() throws NumberFormatException, IOException {
    
    // If both boxes are not selected upon hitting submit.
    if (!TOFbox.isSelected() && !MCQbox.isSelected()) {
        System.out.println("Please select at least one type of question!");
        return;
    }
        // If either boxes are selected but no amount is available upon hitting submit.
    if (TOFbox.isSelected() && TOFAmount.getText().isEmpty() || MCQbox.isSelected() && MCQAmount.getText().isEmpty()) {
        System.out.println("Please enter an amount to be returned for both questions!");
        return;
    }
    // If the user inputs more questions to be retrieved than are available in the BST.
    if (TOFbox.isSelected() && !TOFAmount.getText().isEmpty() && Integer.parseInt(TOFAmount.getText()) > tofBst.countNodes() ||
            MCQbox.isSelected() && !MCQAmount.getText().isEmpty() && Integer.parseInt(MCQAmount.getText()) > mcqBst.countNodes()) {
        System.out.println("More questions selected than available for one or both question types!");
        return;
    }
    
    if (TOFbox.isSelected() && MCQbox.isSelected()) {
        TOFBinaryTree pulledTOFTree = tofBst.pullNodesFromNewTree(Integer.parseInt(TOFAmount.getText()));
        MCQBinaryTree pulledMCQTree = mcqBst.pullNodesFromNewTree(Integer.parseInt(MCQAmount.getText()));
    
        // Combine content from both categories into a single output
        String combinedContent = pulledMCQTree.getMQCTreeAsString() + pulledTOFTree.getTOFTreeAsString();
    
        // Save combined content to output.txt
        saveToFile("output.txt", combinedContent);
    } else {
        // If only one checkbox is selected
        if (TOFbox.isSelected()) {
            TOFBinaryTree pulledTOFTree = tofBst.pullNodesFromNewTree(Integer.parseInt(TOFAmount.getText()));
            saveToFile("output.txt", pulledTOFTree.getTOFTreeAsString());

        } else if (MCQbox.isSelected()) {
            MCQBinaryTree pulledMCQTree = mcqBst.pullNodesFromNewTree(Integer.parseInt(MCQAmount.getText()));
            saveToFile("output.txt", pulledMCQTree.getMQCTreeAsString());
        }
    }
}
}

