package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.generateOperation;
import static hexlet.code.Engine.generateRandomNumber;
import static hexlet.code.Engine.numberCheckAnswerAndView;

public class Calculator {

    private static int count;

    public static void calculator(final int lastRndNumber,
                                   final int countOfTries) {

        final String player = greeting();

        System.out.println("What is the result of the expression?");

        while (count < countOfTries) {
            int questionNumberOne = generateRandomNumber(lastRndNumber);
            int questionNumberTwo = generateRandomNumber(lastRndNumber);
            String questionOperation = generateOperation(lastRndNumber);

            int result;
            switch (questionOperation) {
                case "+": result = questionNumberOne + questionNumberTwo;
                    break;
                case "*": result = questionNumberOne * questionNumberTwo;
                    break;
                default: result = questionNumberOne - questionNumberTwo;
            }

            System.out.println("Question: " + questionNumberOne
                    + " " + questionOperation
                    + " " + questionNumberTwo);

            count = numberCheckAnswerAndView(
                    result, player, count, countOfTries);
        }

        if (count == countOfTries) {
            System.out.println("Congratulations, " + player + "!");
        }

    }

}
