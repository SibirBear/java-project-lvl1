package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.generateRandomNumber;
import static hexlet.code.Engine.enterNumber;

public class GCD {

    private static int count;

    public static void gcdGame(final int lastRndNumber,
                           final int countOfTries) {

        final String player = greeting();

        System.out.println(
                "Find the greatest common divisor of given numbers.");

        while (count < countOfTries) {

            int numberOne = generateRandomNumber(lastRndNumber);
            int numberTwo = generateRandomNumber(lastRndNumber);
            int result = gcd(numberOne, numberTwo);

            System.out.println("Question: " + numberOne
                    + " " + numberTwo);
            System.out.print("Your answer: ");
            int userAnswer = enterNumber();

            if (result == userAnswer) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was '"
                        + result + "'.");
                System.out.println("Let's try again, " + player + "!");
                count = countOfTries * countOfTries;
            }
        }

        if (count == countOfTries) {
            System.out.println("Congratulations, " + player + "!");
        }

    }

    //Вычисляем НОД
    private static int gcd(final int numOne, final int numTwo) {
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
