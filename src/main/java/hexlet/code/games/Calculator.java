package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.*;

public class Calculator {

    private static int count;

    public static void calculator (final int lastRndNumber,
                                   final int countOfTries) {

        final String player = greeting();

        System.out.println("What is the result of the expression?");

        while (count < countOfTries) {
            int questionNumberOne = generateRandomNumber(lastRndNumber);
            int questionNumberTwo = generateRandomNumber(lastRndNumber);
            String questionOperation = generateOperation(lastRndNumber);

            int result;
            switch(questionOperation) {
                case "+": result = questionNumberOne + questionNumberTwo;
                    break;
                case "*": result = questionNumberOne * questionNumberTwo;
                    break;
                default: result = questionNumberOne - questionNumberTwo;
            }

            System.out.println("Question: " + questionNumberOne
                    + " " + questionOperation
                    + " " + questionNumberTwo);
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
                count = countOfTries + 10;
            }
        }

        if (count == countOfTries) {
            System.out.println("Congratulations, " + player + "!");
        }

    }

}
