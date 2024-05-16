/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.mcq_template;

/**
 *
 * @author 00023354
 */
public class NodeData {

    String questionID;
    String question;
    String answer;
    String choice2;
    String choice3;
    String choice4;

    public NodeData(String questionID, String question, String answer, String choice2, String choice3, String choice4) {

        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }
    
    public String getQuestionID() { 
        return questionID;
    }

    public String getQuestion(){ 
        return question;
    }

    public String getAnswer() { 
        return answer;
    }

    public String getChoiceTwo() {
        return choice2;
    }

    public String getChoiceThree() {
        return choice3;
    }
    public String getChoiceFour() {
        return choice4;
    }

    public void setQuestionID(String questionIDString) { 
        this.questionID = questionIDString;
    }


    public int compareTo(NodeData d) {
        return this.questionID.compareTo(d.questionID);
    }

    @Override
    public String toString() {
        return "Question: " + getQuestion() + "\n" +
               "a) " + getAnswer() + "\n" +
               "b) " + getChoiceTwo() + "\n" +
               "c) " + getChoiceThree() + "\n" +
               "d) " + getChoiceFour() + "\n\n";
    }
    // end class NodeData
}// end class NodeData    
