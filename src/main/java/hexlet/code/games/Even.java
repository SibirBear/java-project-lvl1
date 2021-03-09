package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.*;

public class Even {

    private static int count;
    private static int countCorrectAnswer;

    public static void even(final int LAST_RND_NUMBER, final int COUNT_OF_TRIES) {

        final String player = greeting();

        System.out.println(
                "Answer 'yes' if number even otherwise answer 'no'.");

        while (count != COUNT_OF_TRIES) {
            int questionNumber = generateRandomNumber(LAST_RND_NUMBER);
            System.out.println("Question: " + questionNumber);
            System.out.print("Your answer: ");

            String userAnswer = enterVar();
            String correctAnswer = isEvenCheck(questionNumber) ? "yes" : "no";

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswer++;
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + player + "!");
            }
            count++;
        }
        if (countCorrectAnswer == COUNT_OF_TRIES) {
            System.out.println("Congratulations!");
        }
    }

}
