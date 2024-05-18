import java.util.ArrayList; // Importiert die ArrayList-Klasse
import java.util.Scanner;   // Importiert die Scanner-Klasse für die Benutzereingabe

// Hauptklasse des Programms
public class Kontaktbuch {
    // ArrayList zum Speichern der Kontakte
    private ArrayList<Kontakt> kontakte = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Hauptmethode des Programms
    public static void main(String[] args) {
        Kontaktbuch kontaktbuch = new Kontaktbuch();
        kontaktbuch.start();
    }

    // Startet das Hauptmenü
    public void start() {
        while (true) {
            System.out.println("Kontaktbuch Menü:");
            System.out.println("1. Kontakt hinzufügen");
            System.out.println("2. Kontakte anzeigen");
            System.out.println("3. Kontakt löschen");
            System.out.println("4. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int wahl = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (wahl) {
                case 1:
                    kontaktHinzufügen();
                    break;
                case 2:
                    kontakteAnzeigen();
                    break;
                case 3:
                    kontaktLöschen();
                    break;
                case 4:
                    System.out.println("Programm beendet.");
                    return;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
            }
        }
    }

    // Fügt einen neuen Kontakt hinzu
    private void kontaktHinzufügen() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Telefonnummer: ");
        String telefonnummer = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        kontakte.add(new Kontakt(name, telefonnummer, email));
        System.out.println("Kontakt hinzugefügt.");
    }

    // Zeigt alle gespeicherten Kontakte an
    private void kontakteAnzeigen() {
        if (kontakte.isEmpty()) {
            System.out.println("Keine Kontakte gefunden.");
        } else {
            System.out.println("Kontakte:");
            for (Kontakt kontakt : kontakte) {
                System.out.println(kontakt);
            }
        }
    }

    // Löscht einen Kontakt basierend auf dem Namen
    private void kontaktLöschen() {
        System.out.print("Name des zu löschenden Kontakts: ");
        String name = scanner.nextLine();
        boolean gefunden = false;
        for (Kontakt kontakt : kontakte) {
            if (kontakt.getName().equalsIgnoreCase(name)) {
                kontakte.remove(kontakt);
                System.out.println("Kontakt gelöscht.");
                gefunden = true;
                break;
            }
        }
        if (!gefunden) {
            System.out.println("Kontakt nicht gefunden.");
        }
    }
}