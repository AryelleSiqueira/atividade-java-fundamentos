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
     * Adds a Question object to list of questions.
     * @param q reference to question to be added into the list
     */
    public void registerQuestion(Question q) {
        this.questions.add(q);
    }

    /**
     * Calls toString() method of the question at the specified position
     * of its list of questions.
     * @param questionIndex index of corresponding question to return
     * @throws IndexOutOfBoundsException if the questionIndex is out of range
     */
    public Question getQuestionByIndex(int questionIndex) {
        return this.questions.get(questionIndex);
    }

    /**
     * Returns boolean indicating if answer to question at the specified
     * position is true of false.
     * @param questionIndex index of corresponding question
     * @param answer option chosen by the user
     * @return boolean indicating if chosen option is the right one
     * @throws InvalidOptionException if chosen option (answer) does not exist
     * @throws IndexOutOfBoundsException if the questionIndex is out of range
     */
    public boolean checkAnswerToQuestion(int questionIndex, int answer) throws InvalidOptionException {
        Question q = this.questions.get(questionIndex);

        boolean isRight = q.checkAnswer(answer);
        if (isRight) {
            this.rightAnswersCounter++;
        }

        return isRight;
    }

    // Getters

    /**
     * Returns the number of elements in its list of questions.
     * @return number of questions inside its list os questions
     */
    public int getNumberOfQuestions() {
        return this.questions.size();
    }

    /**
     * Returns how many right answers were given.
     * @return number of right answers
     */
    public int getRightAnswersCounter() {
        return rightAnswersCounter;
    }

    /**
     * Returns how many wrong answers were given.
     * @return number of wrong answers
     */
    public int getWrongAnswersCounter() {
        return this.questions.size() - rightAnswersCounter;
    }

}
