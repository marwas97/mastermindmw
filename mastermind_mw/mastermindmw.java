import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class mastermindmw {
    public static void main(String[] args) {
        String creds = "mastermind v0.001 by marek wasiewski";
        Random random = new Random();
        int num1 = random.nextInt(1, 6);
        int num2 = random.nextInt(1, 6);
        int num3 = random.nextInt(1, 6);
        int num4 = random.nextInt(1, 6);
        String code = "" + num1 + num2 + num3 + num4;
        int code2 = Integer.parseInt(code);
        int index = 0;
        boolean over = false;
        boolean trafienie = false;
        int maxTries = 10;
        int points = 0;
        System.out.println("Witaj w grze " +creds+"\nTwoim zadaniem jest odgadnięcie w " + maxTries + " próbach czterocyfrowego kodu, składającego\nsię z liczb z zakresu od 1 do 6. Wpisz cztery takie liczby\nlub wpisz quit aby wyjść.");
        Scanner scanner = new Scanner(System.in);
        while (!over) {
            String input = scanner.next();
            int numScann = 0;
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Może innym razem, pa!");
                over = true;
                scanner.close();
            } else {
                try {
                    numScann = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("Błędna wartość! Podaj liczbę z zakresu od 1 do 6!");
                    continue;
                }
            }
            if (numScann >= 1 && numScann <= 6) {
                System.out.println("Podaj liczbę od 1 do 6. Pozostało " + maxTries + " prób.");
                   maxTries--;
                if (numScann == num1) {
                    points++;
                    System.out.println("liczba pierwsza odgadnięta");
                } else if (numScann == num2) {
                    points++;
                    System.out.println("liczba druga odgadnięta");
                } else if (numScann == num3) {
                    points++;
                    System.out.println("liczba trzecia odgadnięta");
                } else if (numScann == num4) {
                    points++;
                    System.out.println("liczba czwarta odgadnięta");
                } else {
                    System.out.printf("Błędna liczba, pozostało ci " + maxTries + " prób.\n");
                }
            }
            if (maxTries == 0) {
                System.out.println("Koniec prób! Spróbuj ponownie wpisując retry, albo wyjdź wpisując quit. Kod którego nie odgadłeś to: " + code);
                Scanner scanner1 = new Scanner(System.in);
                String input2 = scanner1.nextLine();
                if (input2.equalsIgnoreCase("retry")) {
                    maxTries = 10;
                    points = 0;
                    over = false;
                    System.out.println("Witaj w grze mastermind. \nTwoim zadaniem jest odgadnięcie czterocyfrowego kodu, składającego\nsię z liczb z zakresu od 1 do 6. Wpisz cztery takie liczby\nlub wpisz quit aby wyjść.");

                } else if (input2.equalsIgnoreCase("quit")) {
                    System.out.println("Pa, pa!");
                    over = true;
                    scanner.close();

                } else {
                    System.out.println("Błędna wartość, pa, pa!");
                    over = true;
                    scanner.close();
                }

            }
        }
    }
}

