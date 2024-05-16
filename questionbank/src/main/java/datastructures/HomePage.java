// Controller class for the Home Page the user sees upon launching the application

package datastructures;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class HomePage {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
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

}