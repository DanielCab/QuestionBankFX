/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tof_template;

/**
 *
 * @author 00023354
 */
public class TNodeData {

    String questionID;
    String question;
    String answer;
    String choice2;

    public TNodeData(String questionID ,String question ,String answer ,String choice2) {

        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
        this.choice2 = choice2;
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
    
    public void setQuestionID(String questionIDString) { 
        this.questionID = questionIDString;
    }


    public int compareTo(TNodeData d) {
        return this.questionID.compareTo(d.questionID);
    }
}// end class NodeData    
