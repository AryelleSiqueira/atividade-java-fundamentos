package q6.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;            // references question
    private List<String> answers;       // saves all answers
    private int rightAnswerIndex;   // position of the right answer in the collection


    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(String answer, boolean isTrueOrFalse) {
        if (isTrueOrFalse) {
            this.rightAnswerIndex = answers.size(); // overrides if right answer was already set
        }
        this.answers.add(answer);
    }

    public String getRightAnswer() {
        return this.answers.get(rightAnswerIndex);
    }

    public boolean checkAnswer(int option) {
        return option == (rightAnswerIndex + 1);
    }

    @Override
    public String toString() {
        StringBuilder qNa = new StringBuilder(this.question);
        qNa.append("\n");

        int i = 1;
        for (String ans:  this.answers) {
            qNa.append(i + ") ");
            qNa.append(ans);
            qNa.append("\n");
            i++;
        }
        return qNa.toString();
    }
}
