package ohtu.rockpaperscissors;

import java.util.Scanner;

public class RPSAiPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Judge judge = new Judge();
        AiPlayer aiPlayer = new AiPlayer();

        System.out.print("Ensimmäisen pelaajan move: ");
        String playerOneMove = scanner.nextLine();
        String playerTwoMove;

        playerTwoMove = aiPlayer.getNextMove();
        System.out.println("Tietokone valitsi: " + playerTwoMove);


        while (isValidMove(playerOneMove) && isValidMove(playerTwoMove)) {
            judge.recordMoves(playerOneMove, playerTwoMove);
            System.out.println(judge);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan move: ");
            playerOneMove = scanner.nextLine();

            playerTwoMove = aiPlayer.getNextMove();
            System.out.println("Tietokone valitsi: " + playerTwoMove);
            aiPlayer.setNextMove(playerOneMove);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(judge);
    }

    private static boolean isValidMove(String move) {
        return "k".equals(move) || "p".equals(move) || "s".equals(move);
    }
}