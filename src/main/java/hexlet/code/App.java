package hexlet.code;

import static hexlet.code.Cli.greeting;
import static hexlet.code.EnterVar.enterVar;
import static hexlet.code.games.Even.even;

public class App {
    public static void main(final String[] args) {

        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit\n");

        String numberChoice;
        System.out.print("Your choice: ");
        numberChoice = enterVar();

        switch (numberChoice) {
            case "1": greeting();
            case "2": even();
            default:
        }

    }
}
