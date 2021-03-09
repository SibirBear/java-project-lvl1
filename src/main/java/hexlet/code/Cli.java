package hexlet.code;

import static hexlet.code.Engine.enterVar;

public class Cli {
    public static String greeting() {
        System.out.print("\nWelcome to the Brain Games!\n");
        System.out.print("May I have your name? ");

        final String player = enterVar();

        System.out.println("Hello, " + player + "!");
        return player;
    }
}

