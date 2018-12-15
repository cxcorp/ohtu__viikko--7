package ohtu.rockpaperscissors;

import java.util.Scanner;

public class RPSPlayerVsPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Judge judge = new Judge();

        System.out.print("Ensimmäisen pelaajan move: ");
        String playerOneMove = scanner.nextLine();
        System.out.print("Toisen pelaajan move: ");
        String playerTwoMove = scanner.nextLine();

        while (isValidMove(playerOneMove) && isValidMove(playerTwoMove)) {
            judge.recordMoves(playerOneMove, playerTwoMove);
            System.out.println(judge);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan move: ");
            playerOneMove = scanner.nextLine();

            System.out.print("Toisen pelaajan move: ");
            playerTwoMove = scanner.nextLine();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(judge);
    }

    private static boolean isValidMove(String move) {
        return "k".equals(move) || "p".equals(move) || "s".equals(move);
    }
}