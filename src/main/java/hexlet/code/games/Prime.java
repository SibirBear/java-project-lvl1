package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.enterVar;
import static hexlet.code.Engine.generateRandomNumber;
import static hexlet.code.Engine.isPrimeCheck;
import static hexlet.code.Engine.stringCheckAnswerAndView;

public class Prime {

    private static int count;

    public static void prime(final int lastRndNumber,
                             final int countOfTries) {

        final String player = greeting();

        System.out.println(
            "Answer 'yes` if given number is prime. Otherwise answer `no`.");

        while (count < countOfTries) {
            int questionNumber = generateRandomNumber(lastRndNumber);
            System.out.println("Question: " + questionNumber);
            System.out.print("Your answer: ");

            String userAnswer = enterVar();
            String correctAnswer = isPrimeCheck(questionNumber) ? "yes" : "no";

            count = stringCheckAnswerAndView(
                    correctAnswer, userAnswer, count, player, countOfTries);
        }

        if (count == countOfTries) {
            System.out.println("Congratulations, " + player + "!");
        }

    }
}
