package ohtu.rockpaperscissors;

import java.util.Scanner;
import ohtu.rockpaperscissors.ui.ConsoleIO;
import ohtu.rockpaperscissors.ui.IO;
import ohtu.rockpaperscissors.ui.MainMenu;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*while (true) {
            System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");

            String move = scanner.nextLine();
            if (move.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                MultiplayerRPSGame pvp = new MultiplayerRPSGame();
                pvp.play();
            } else if (move.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                RPSAiPlayer singlePlayer = new RPSAiPlayer();
                singlePlayer.play();
            } else if (move.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                RPSImprovedAiPlayer difficultSinglePlayer = new RPSImprovedAiPlayer();
                difficultSinglePlayer.play();
            } else {
                break;
            }

        }*/
        IO io = new ConsoleIO(new Scanner(System.in));
        MainMenu menu = new MainMenu(io);
        menu.start();
    }
}
