package q6.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Question> questions;
    private int rightAnswersCounter;


    public Quiz() {
        this.questions = new ArrayList<>();
    }

    /**
     * Adds a Question object to its list of questions.
     * */
    public void registerQuestion(Question q) {
        this.questions.add(q);
    }

    /**
     * Calls toString() method of the question at the specified position
     * of its list of questions.
     * */
    public Question getQuestionByIndex(int questionIndex) {
        return this.questions.get(questionIndex);
    }

    /**
     * Returns boolean indicating if answer to question at the specified
     * position of its list of questions is true of false.
     * */
    public boolean checkAnswerToQuestion(int questionIndex, int answer) {
        // TODO: Question might not exist in the list!
        Question q = this.questions.get(questionIndex);

        if (q != null) {
            boolean isRight = q.checkAnswer(answer);
            if (isRight) { this.rightAnswersCounter++; }

            return isRight;
        }
        return false; // always returns false when question is not found
    }

    // Getters

    /**
     * Returns the number of elements in its list of questions.
     * */
    public int getNumberOfQuestions() {
        return this.questions.size();
    }

    /**
     * Returns how many right answers were given.
     * */
    public int getRightAnswersCounter() {
        return rightAnswersCounter;
    }

    /**
     * Returns how many wrong answers were given.
     * */
    public int getWrongAnswersCounter() {
        return this.questions.size() - rightAnswersCounter;
    }
}
