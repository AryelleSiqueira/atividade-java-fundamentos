package q6.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;        // references question
    private List<String> answers;   // saves all answers
    private int rightAnswerIndex;   // position of the right answer in the collection


    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(String answer, boolean isTrueOrFalse) {
        // TODO: there can only be one right answer
        if (isTrueOrFalse) {
            this.rightAnswerIndex = answers.size();
        }
        this.answers.add(answer);
    }

    public String getAllAnswers() {
        StringBuilder answers = new StringBuilder("");

        int i = 1;
        for (String ans:  this.answers) {
            answers.append(i + ") ");
            answers.append(ans);
            answers.append("\n");
            i++;
        }

        return answers.toString();
    }

    public String getRightAnswer() {
        return this.answers.get(rightAnswerIndex);
    }

    public boolean CheckAnswer(int option) {
        return option == (rightAnswerIndex + 1);
    }

    @Override
    public String toString() { // TODO: yet to implement
        return "";
    }
}
