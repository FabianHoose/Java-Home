import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wächle zwischen einer der folgenden Optionen");
        System.out.println("1) USD in Euro");
        System.out.println("2) Euro in USD");
        System.out.println("3) Pfund in USD");

        int wechsel = sc.nextInt();
        switch(wechsel) {
            case 1: {
                System.out.println("Gib die Menge in USD ein");

                double usd = sc.nextDouble();

                if (usd>=0) {
                    System.out.println(usd + " USD ist "+ usd*0.908 + " Euro. ");

                }
                else {
                    System.out.println("Bitte gib eine positive Zahl in USD ein. ");
                }
            }
            break;
            case 2: {
                System.out.println("Gib die Menge in Euro ein");
                double euro = sc.nextDouble();

                if (euro>=0) {
                    System.out.println(euro + " Euro ist "+ euro*1.101+ " USD. ");

                }
                else {
                    System.out.println("Gib bitte eine positive Zahl in Euro ein");
                }

            }
            break;
            case 3: {
                System.out.println("Gib die Menge in Pfund ein");
                double pounds = sc.nextDouble();

                if (pounds>=0) {
                    System.out.println(pounds + " Pfund ist " + pounds * 1.28 + " USD. ");

                }
                else {
                    System.out.println("Bitte gib eine positive Zahl in Pfund ein");

                }
            }
            break;
        }
        sc.close();

    }
}