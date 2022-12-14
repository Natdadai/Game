import Model.MGame;

import java.util.Scanner;
public class UI {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int playerCount;
        String[] playerNames;
        MGame mGame;

        System.out.println("Welcome to the Monopoly Game.");

        while (true) {
            System.out.print("Please enter amount of players (2-8): ");
            playerCount = Integer.parseInt(scanner.nextLine());

            if (playerCount >= 2 && playerCount <= 8) {
                break;
            }

            System.out.println("Invalid amount of players. Must be between 2-8.");
        }

        playerNames = new String[playerCount];
        for (int i = 0; i < playerCount; ++i) {
            System.out.print("Enter player #" + (i + 1) + " " + "name: ");
            playerNames[i] = scanner.nextLine();
        }

        mGame = new MGame(playerNames, playerCount);
        mGame.playGame();
    }
}
