import java.util.ArrayList; // Importiert die ArrayList-Klasse
import java.util.Scanner;   // Importiert die Scanner-Klasse für die Benutzereingabe

// Klasse für einzelne Kontakte
class Kontakt {
    private String name;
    private String telefonnummer;
    private String email;

    // Konstruktor zum Erstellen eines Kontakts
    public Kontakt(String name, String telefonnummer, String email) {
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }

    // Getter-Methoden, um die Eigenschaften des Kontakts abzurufen
    public String getName() {
        return name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    // Überschreibt die toString-Methode, um den Kontakt als String darzustellen
    @Override
    public String toString() {
        return "Name: " + name + ", Telefonnummer: " + telefonnummer + ", Email: " + email;
    }
}

