package hexlet.code;

import static hexlet.code.EnterVar.enterVar;

public class Cli {
    public static String greeting() {
        System.out.print("\nWelcome to the Brain Games!\n");
        System.out.print("May I have your name? ");
        String player = enterVar();
        System.out.println("Hello, " + player + "!");
        return player;
    }
}

