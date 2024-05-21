import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner für Benutzereingaben
        TicTacToe game = new TicTacToe(); // Erstellen eines neuen Tic-Tac-Toe-Spiels

        System.out.println("Willkommen zu meinem Tic-Tac-Toe Spiel");
        game.printBoard(); // Das Spielfeld wird initial ausgegeben

        while (true) { // Hauptspielschleife, läuft bis das Spiel endet
            // Spieler 'X' macht seinen Zug
            System.out.println("Spieler 'X', mach deinen Zug (Zeile und Spalte): ");
            int row = scanner.nextInt(); // Einlesen der Zeile
            int col = scanner.nextInt(); // Einlesen der Spalte
            game.makeMove(row, col, 'X'); // Spieler 'X' macht seinen Zug
            game.printBoard(); // Das Spielfeld wird nach dem Zug ausgegeben

            // Überprüfen, ob Spieler 'X' gewonnen hat
            if (game.checkWin('X')) {
                System.out.println("Spieler X gewinnt!");
                break; // Spiel beenden, wenn Spieler 'X' gewinnt
            }

            // Überprüfen, ob das Spielfeld voll ist (Unentschieden)
            if (game.isBoardFull()) {
                System.out.println("Unentschieden!");
                break; // Spiel beenden, wenn das Spielfeld voll ist
            }

            // Computer 'O' macht seinen Zug
            System.out.println("Computer 'O' macht seinen Zug");
            game.makeBestMove('O'); // Computerzug wird berechnet und gemacht
            game.printBoard(); // Das Spielfeld wird nach dem Zug ausgegeben

            // Überprüfen, ob der Computer 'O' gewonnen hat
            if (game.checkWin('O')) {
                System.out.println("Computer 'O' gewinnt!");
                break; // Spiel beenden, wenn der Computer 'O' gewinnt
            }

            // Überprüfen, ob das Spielfeld voll ist (Unentschieden)
            if (game.isBoardFull()) {
                System.out.println("Unentschieden!");
                break; // Spiel beenden, wenn das Spielfeld voll ist
            }
        }
    }
}