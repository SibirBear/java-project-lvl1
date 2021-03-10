package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

import static hexlet.code.Cli.greeting;
import static hexlet.code.games.Calculator.calculator;
import static hexlet.code.games.Even.even;
import static hexlet.code.games.GCD.gcd;
import static hexlet.code.games.Prime.prime;
import static hexlet.code.games.Progression.progression;

public class Engine {

    // - диапазон от 0 до указанного значения для генератора
    // случайных чисел
    private static final int LAST_RND_NUMBERS = 100;
    // - кол-во попыток в каждой игре
    private static final int TRIES_FOR_GAME = 3;

    public static void menuGames() {
        int selectNumberMenu;

        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n");

        System.out.print("Your choice: ");
        selectNumberMenu = enterNumber();

        switch (selectNumberMenu) {
            case 1: greeting();
                break;
            case 2: even(LAST_RND_NUMBERS, TRIES_FOR_GAME);
                break;
            case 3: calculator(LAST_RND_NUMBERS, TRIES_FOR_GAME);
                break;
            case 4: gcd(LAST_RND_NUMBERS, TRIES_FOR_GAME);
                break;
            case 5: progression(TRIES_FOR_GAME);
                break;
            case 6: prime(LAST_RND_NUMBERS, TRIES_FOR_GAME);
            default:
        }
    }

    //Цифровой ввод
    public static int enterNumber() {
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("ERROR! This is not a number! Repeat enter.");
            return enterNumber();
        }
    }

    //Строковый ввод
    public static String enterVar() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //Генератор случайного числа от 0 до значения
    public static int generateRandomNumber(final int lastNumber) {
        return generateRndNumberPeriod(0, lastNumber);
    }

    //Генератор случайного числа в заданном диапазоне
    public static int generateRndNumberPeriod(final int firstNumber,
                                              final int lastNumber) {
        int numberTmp = firstNumber;
        while (numberTmp <= firstNumber) {
            numberTmp = (int) (Math.random() * lastNumber);
        }
        return numberTmp;
    }

    //Генератор операции для калькулятора
    public static String generateOperation(final int lastNumber) {
        final int qtyOperation = 3; //кол-во операций: +, -, *
        int result = generateRandomNumber(lastNumber);
        if (result < lastNumber / qtyOperation) {
            return "+";
        } else if (result >= lastNumber / qtyOperation
                & result < qtyOperation * 2) {
            return "*";
        } else {
            return "-";
        }
    }

    //Проверка на четность
    public static boolean isEvenCheck(final int number) {
        return 0 == number % 2;
    }

    //Проверка на простое число
    public static boolean isPrimeCheck(final int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Запрос цифрового ответа на вопрос в игре и вывод результата
    public static int numberCheckAnswerAndView(final int result,
                                               final String player,
                                               final int count,
                                               final int tries) {
        int countCheck = count;
        System.out.print("Your answer: ");
        int userAnswer = enterNumber();

        if (result == userAnswer) {
            System.out.println("Correct!");
            countCheck++;
        } else {
            System.out.println("'" + userAnswer + "'"
                    + " is wrong answer ;(. Correct answer was '"
                    + result + "'.");
            System.out.println("Let's try again, " + player + "!");
            countCheck = tries * tries;
        }
        return countCheck;
    }

    //Запрос буквенного ответа на вопрос и вывод результата
    public static int stringCheckAnswerAndView(
            final String correctAnswer, final String userAnswer,
            final int count, final String player, final int tries) {

        int countCheck = count;
        if (correctAnswer.equals(userAnswer)) {
            System.out.println("Correct!");
            countCheck++;
        } else {
            System.out.println("'" + userAnswer
                    + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.");
            System.out.println("Let's try again, " + player + "!");
            countCheck = tries * tries;
        }
        return countCheck;
    }
}
