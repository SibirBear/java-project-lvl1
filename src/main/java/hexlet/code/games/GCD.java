package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.generateRandomNumber;
import static hexlet.code.Engine.numberCheckAnswerAndView;

public class GCD {

    private static int count;

    public static void gcd(final int lastRndNumber,
                           final int countOfTries) {

        final String player = greeting();

        System.out.println(
                "Find the greatest common divisor of given numbers.");

        while (count < countOfTries) {

            int numberOne = generateRandomNumber(lastRndNumber);
            int numberTwo = generateRandomNumber(lastRndNumber);
            int result = gcdExp(numberOne, numberTwo);

            System.out.println("Question: " + numberOne
                    + " " + numberTwo);

            count = numberCheckAnswerAndView(
                    result, player, count, countOfTries);
        }

        if (count == countOfTries) {
            System.out.println("Congratulations, " + player + "!");
        }

    }

    //Вычисляем НОД
    private static int gcdExp(final int numOne, final int numTwo) {
        int a = numOne;
        int b = numTwo;

        while (b != 0) {
            int remainderOfDivision = a % b;
            a = b;
            b = remainderOfDivision;
        }
        return a;
    }

}
