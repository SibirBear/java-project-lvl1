package hexlet.code.games;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Engine.generateRndNumberPeriod;
import static hexlet.code.Engine.numberCheckAnswerAndView;


public class Progression {

    private static int count;
    private static final int MIN_NUMBERS_EXP = 5;
    private static final int MAX_NUMBERS_EXP = 10;

    public static void progression(final int countOfTries) {

        final String player = greeting();

        System.out.println(
                "What number is missing in the progression?");

        while (count < countOfTries) {
            int firstNumber = generateRndNumberPeriod(1,
                    MAX_NUMBERS_EXP * 2);
            int stepValue = generateRndNumberPeriod(1,
                    MAX_NUMBERS_EXP);
            int valueExp = generateRndNumberPeriod(MIN_NUMBERS_EXP,
                    MAX_NUMBERS_EXP);
            int[] progressionResult = progressionArithmetic(
                    firstNumber, stepValue, valueExp);
            int result = progressionResult[
                    generateRndNumberPeriod(1, valueExp)];

            System.out.print("Question: ");

            for (int value : progressionResult) {
                if (value == result) {
                    System.out.print(".. ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();

            count = numberCheckAnswerAndView(
                    result, player, count, countOfTries);

/*            System.out.print("Your answer: ");
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
            }*/
        }

        if (count == countOfTries) {
            System.out.println("Congratulations, " + player + "!");
        }

    }

    private static int[] progressionArithmetic(final int first,
                                                final int step,
                                                final int qty) {
        int[] result = new int[qty];
        result[0] = first;
        for (int i = 1; i < qty; i++) {
            result[i] = first + i * step;
        }
        return result;
    }

}
