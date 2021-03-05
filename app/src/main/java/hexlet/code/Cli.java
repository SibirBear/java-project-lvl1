package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();

        System.out.format("Hello, %s!\n", playerName);
    }
}
