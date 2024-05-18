import java.util.Scanner; // Importiert die Scanner-Klasse für die Benutzereingabe

public class Taschenrechner {
    public static void main(String[] args) {
        // Erstellen eines Scanner-Objekts zur Eingabe von der Konsole
        Scanner scanner = new Scanner(System.in);
        double num1, num2; // Variablen für die beiden Zahlen
        char operation; // Variable für die gewählte Operation

        // Begrüßungsnachricht
        System.out.println("Willkommen zu meinem Taschenrechner!");

        // Benutzeraufforderung zur Eingabe der ersten Zahl
        System.out.println("Gib eine erste Zahl ein: ");
        num1 = scanner.nextDouble(); // Speichert die Eingabe in num1

        // Benutzeraufforderung zur Auswahl der Operation
        System.out.println("Wähle eine Operation aus zwischen (+, -, *, /): ");
        operation = scanner.next().charAt(0); // Speichert das erste Zeichen der Eingabe in operation

        // Benutzeraufforderung zur Eingabe der zweiten Zahl
        System.out.println("Gib eine zweite Zahl ein: ");
        num2 = scanner.nextDouble(); // Speichert die Eingabe in num2

        // Switch-Anweisung zur Auswahl und Ausführung der Operation basierend auf der Benutzereingabe
        switch (operation) {
            case '+': // Fall für Addition
                System.out.println("Ergebnis: " + (num1 + num2)); // Ausgabe des Ergebnisses
                break; // Beendet diesen Fall
            case '-': // Fall für Subtraktion
                System.out.println("Ergebnis: " + (num1 - num2)); // Ausgabe des Ergebnisses
                break; // Beendet diesen Fall
            case '*': // Fall für Multiplikation
                System.out.println("Ergebnis: " + (num1 * num2)); // Ausgabe des Ergebnisses
                break; // Beendet diesen Fall
            case '/': // Fall für Division
                if (num2 != 0) { // Überprüfen, ob der Divisor nicht null ist
                    System.out.println("Ergebnis: " + (num1 / num2)); // Ausgabe des Ergebnisses
                } else {
                    System.out.println("Fehler: Division durch 0 ist nicht erlaubt."); // Fehlermeldung bei Division durch Null
                }
                break; // Beendet diesen Fall
            default: // Fall für ungültige Operationen
                System.out.println("Ungültige Operation."); // Ausgabe einer Fehlermeldung
                break; // Beendet diesen Fall
        }

        // Schließen des Scanner-Objekts
        scanner.close();
    }
}