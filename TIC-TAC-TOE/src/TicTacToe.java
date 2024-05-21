import java.util.Random;

public class TicTacToe {
    private char[][] board; // 2D-Array zur Darstellung des Spielfelds
    private static final int SIZE = 3; // Größe des Spielfelds (3x3)

    // Konstruktor zur Initialisierung des Spielfelds
    public TicTacToe() {
        board = new char[SIZE][SIZE]; // Initialisierung des Spielfelds als 3x3 Array
        // Initialisierung des Spielfelds mit leeren Feldern ('-')
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Methode zur Ausgabe des aktuellen Spielfelds
    public void printBoard() {
        // Durchlaufe jede Zeile und Spalte des Spielfelds
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " "); // Gib das Zeichen in der aktuellen Zelle aus
            }
            System.out.println(); // Zeilenumbruch nach jeder Zeile
        }
    }

    // Methode zur Überprüfung, ob das Spielfeld voll ist
    public boolean isBoardFull() {
        // Durchlaufe jede Zelle des Spielfelds
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') { // Wenn eine Zelle leer ist, ist das Spielfeld nicht voll
                    return false;
                }
            }
        }
        return true; // Wenn keine leere Zelle gefunden wurde, ist das Spielfeld voll
    }

    // Methode zur Überprüfung, ob ein Spieler gewonnen hat
    public boolean checkWin(char player) {
        // Überprüfung der Zeilen
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Wenn alle drei Felder in der Zeile dem Spieler gehören, gewinnt er
            }
        }
        // Überprüfung der Spalten
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true; // Wenn alle drei Felder in der Spalte dem Spieler gehören, gewinnt er
            }
        }
        // Überprüfung der Diagonalen
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Wenn alle drei Felder in der Hauptdiagonale dem Spieler gehören, gewinnt er
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Wenn alle drei Felder in der Nebendiagonale dem Spieler gehören, gewinnt er
        }
        return false; // Wenn keine Gewinnbedingung erfüllt ist, hat der Spieler nicht gewonnen
    }

    // Methode zur Durchführung eines Spielzugs
    public boolean makeMove(int row, int col, char player) {
        // Überprüfe, ob die Koordinaten innerhalb des Spielfelds liegen und das Feld leer ist
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = player; // Setze das Feld auf den Spielerwert
            return true; // Rückgabe, dass der Zug erfolgreich war
        }
        return false; // Rückgabe, dass der Zug ungültig war
    }

    // Methode zur Durchführung des besten Zugs für den Computer
    public void makeBestMove(char player) {
        int bestScore = Integer.MIN_VALUE; // Initialisierung des besten Scores
        int moveRow = -1; // Initialisierung der Zeile für den besten Zug
        int moveCol = -1; // Initialisierung der Spalte für den besten Zug

        // Durchlaufe alle möglichen Züge
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') { // Überprüfe, ob das Feld leer ist
                    board[i][j] = player; // Setze den Zug auf das Spielfeld
                    int score = minimax(0, false); // Berechne den Score für diesen Zug
                    board[i][j] = '-'; // Setze das Feld zurück

                    // Aktualisiere den besten Score und die besten Koordinaten, wenn nötig
                    if (score > bestScore) {
                        bestScore = score;
                        moveRow = i;
                        moveCol = j;
                    }
                }
            }
        }

        // Führe den besten Zug aus, wenn gültige Koordinaten vorhanden sind
        if (moveRow != -1 && moveCol != -1) {
            makeMove(moveRow, moveCol, player);
        }
    }

    // Methode zur Implementierung des Minimax-Algorithmus für die künstliche Intelligenz
    private int minimax(int depth, boolean isMaximizing) {
        // Basisfälle: Gewinn, Niederlage oder Unentschieden
        if (checkWin('O')) {
            return 10 - depth; // Gewinn des Computers ('O')
        }
        if (checkWin('X')) {
            return depth - 10; // Gewinn des Spielers ('X')
        }
        if (isBoardFull()) {
            return 0; // Unentschieden
        }

        // Maximizer: Computer ('O')
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE; // Initialisierung des besten Scores
            // Durchlaufe alle möglichen Züge
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == '-') { // Überprüfe, ob das Feld leer ist
                        board[i][j] = 'O'; // Setze den Zug des Computers
                        int score = minimax(depth + 1, false); // Berechne den Score für diesen Zug
                        board[i][j] = '-'; // Setze das Feld zurück
                        bestScore = Math.max(score, bestScore); // Aktualisiere den besten Score
                    }
                }
            }
            return bestScore; // Rückgabe des besten Scores für den Computer
        } else { // Minimizer: Spieler ('X')
            int bestScore = Integer.MAX_VALUE; // Initialisierung des besten Scores
            // Durchlaufe alle möglichen Züge
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == '-') { // Überprüfe, ob das Feld leer ist
                        board[i][j] = 'X'; // Setze den Zug des Spielers
                        int score = minimax(depth + 1, true); // Berechne den Score für diesen Zug
                        board[i][j] = '-'; // Setze das Feld zurück
                        bestScore = Math.min(score, bestScore); // Aktualisiere den besten Score
                    }
                }
            }
            return bestScore; // Rückgabe des besten Scores für den Spieler
        }
    }
}



