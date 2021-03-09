package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

import static hexlet.code.Cli.greeting;
import static hexlet.code.games.Calculator.calculator;
import static hexlet.code.games.Even.even;

public class Engine {

    // - диапазон от 0 до указанного значения для генератора
    // случайных чисел
    private static final int LAST_RND_NUMBER = 100;
    // - кол-во попыток в каждой игре
    private static final int COUNT_OF_TRIES = 3;

    public static void menuGames() {
        int selectNumberMenu;

        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "0 - Exit\n");

        System.out.print("Your choice: ");
        selectNumberMenu = enterNumber();

        switch (selectNumberMenu) {
            case 1: greeting();
                break;
            case 2: even(LAST_RND_NUMBER, COUNT_OF_TRIES);
                break;
            case 3: calculator(LAST_RND_NUMBER, COUNT_OF_TRIES);
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

    //Генератор случайного числа
    public static int generateRandomNumber(final int lastNumber) {
        return (int) (Math.random() * lastNumber);
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

}
