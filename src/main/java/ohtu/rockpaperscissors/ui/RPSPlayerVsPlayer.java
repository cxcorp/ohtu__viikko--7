package ohtu.rockpaperscissors;

import java.util.Scanner;
import ohtu.rockpaperscissors.logic.Game;
import ohtu.rockpaperscissors.logic.RPSMove;

public class RPSPlayerVsPlayer {

    private static final Scanner scanner = new Scanner(System.in);

    public void play() {
        Game game = new Game();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        RPSMove playerOneMove = RPSMove.fromString(scanner.nextLine());
        System.out.print("Toisen pelaajan siirto: ");
        RPSMove playerTwoMove = RPSMove.fromString(scanner.nextLine());

        while (playerOneMove != null && playerTwoMove != null) {
            game.playRound(playerOneMove, playerTwoMove);
            System.out.println(game);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            playerOneMove = RPSMove.fromString(scanner.nextLine());

            System.out.print("Toisen pelaajan siirto: ");
            playerTwoMove = RPSMove.fromString(scanner.nextLine());
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(game);
    }
}