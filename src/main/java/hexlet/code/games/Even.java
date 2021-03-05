package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.EnterVar.enterVar;

public class Even {

    private static final int LAST_RND_NUMBER = 100;
    private static final int COUNT_OF_TRIES = 3;
    private static int count;
    private static int countCorrectAnswer;

    public static void even() {
        String player = greeting();

        System.out.println(
                "Answer 'yes' if number even otherwise answer 'no'.");

        while (count != COUNT_OF_TRIES) {
            int questionNumber = randomNumber();
            System.out.println("Question: " + questionNumber);
            System.out.print("Your answer: ");

            String userAnswer = enterVar();
            String correctAnswer = isEven(questionNumber) ? "yes" : "no";

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

    private static int randomNumber() {
        return (int) (Math.random() * LAST_RND_NUMBER);
    }

    private static boolean isEven(final int number) {
        return 0 == number % 2;
    }
}
