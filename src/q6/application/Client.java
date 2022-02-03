package q6.application;

import q6.quiz.Question;
import q6.quiz.Quiz;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        // Creating Quizz and registering Questions

        Quiz quiz = new Quiz();

        Question q1 = new Question("How are Jon Snow and Daenerys Targaryen related?");
        q1.addAnswer("They're siblings", false);
        q1.addAnswer("Daenerys is Jon's aunt", true);
        q1.addAnswer("Daenerys is Jon's nethew", false);
        q1.addAnswer("They're not related at all", false);
        quiz.registerQuestion(q1);

        Question q2 = new Question("What are the names of Daenerys Targaryen's dragons?");
        q2.addAnswer("Balerion, Meraxes and Vhagar", false);
        q2.addAnswer("Drogon, Vhagar and Rhaegal", false);
        q2.addAnswer("Balerion, Drogon and Viserion", false);
        q2.addAnswer("Drogon, Viserion and Rhaegal", true);
        quiz.registerQuestion(q2);

        Question q3 = new Question("How did Renly Baratheon die?");
        q3.addAnswer("He died in the Battle of the Blackwater", false);
        q3.addAnswer("Brienne of Tarth stabbed him", false);
        q3.addAnswer("He was killed by his own brother", false);
        q3.addAnswer("Renly was assassinated by a shadow demon borne from Melisandre", true);
        quiz.registerQuestion(q3);


        // Printing Quiz questions and reading answers

        Scanner sc = new Scanner(System.in); // reads from standard input

        int nQuestions = quiz.getNumberOfQuestions();

        for (int i = 0; i < nQuestions; i++) {
            // Prints question
            System.out.print(">> ");
            System.out.println(quiz.getQuestionByIndex(i));

            // Asks for answer
            System.out.print("Which one is the correct answer? ");
            int ans = Integer.parseInt(sc.nextLine());

            // Checks if user chose the right answer
            if (quiz.checkAnswerToQuestion(i, ans)) {
                System.out.println("Right answer! Congrats\n");
            } else {
                System.out.println("Oops... Wrong answer\n");
                //System.out.printf("Right answer: --- \n\n");
            }
        }

        // Printing results

        System.out.println("UserName: ---"); // TODO: get user name
        System.out.printf("Got %d answers right and %d answers wrong!\n",
                quiz.getRightAnswersCounter(), quiz.getWrongAnswersCounter());

    }
}
