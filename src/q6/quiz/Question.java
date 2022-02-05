package q6.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;            // references question
    private List<String> answers;       // saves all answers/options
    private int rightAnswerIndex;       // position of the right answer in the collection


    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    /**
     * Add answer/option to question.
     * @param answer to be added to list of options
     * @param isTrueOrFalse true if option is the correct answer to question, false otherwise.
     * There can only be one right answer (overrides if right answer was already set)
     */
    public void addAnswer(String answer, boolean isTrueOrFalse) {
        if (isTrueOrFalse) {
            this.rightAnswerIndex = answers.size(); // overrides if right answer was already set
        }
        this.answers.add(answer);
    }

    /**
     * @return right answer to question
     */
    public String getRightAnswer() {
        return this.answers.get(rightAnswerIndex);
    }

    /**
     * Checks if chosen option is correct.
     * @param option number corresponding to any answer
     * @return true if chosen option is correct, returns false otherwise
     * @throws InvalidOptionException if option does not correspond to any answer
     */
    public boolean checkAnswer(int option) throws InvalidOptionException {
        if (option > this.answers.size() || option < 1) {
            throw new InvalidOptionException("There's no such option");
        }
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
