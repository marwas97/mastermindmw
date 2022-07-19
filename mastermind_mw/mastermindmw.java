import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class mastermindmw {

    public static void main(String[] args) {
        String creds = "mastermind java v0.001 by marek wasiewski";
        int [] compNums = new int[4];
        Random random = new Random();
        for(int i = 0; i < compNums.length; i++){
            compNums[i] = random.nextInt(1,6);
        }
        int index = 0;
        boolean over = false;
        boolean trafienie = false;
        int maxTries = 10;
        int points = 0;
        System.out.println("Witaj w grze mastermind. \nTwoim zadaniem jest odgadnięcie w "+maxTries +" próbach czterocyfrowego kodu, składającego\nsię z liczb z zakresu od 1 do 6. Wpisz cztery takie liczby\nlub wpisz quit aby wyjść.");
        Scanner scanner = new Scanner(System.in);
        while (!over) {
            String input = scanner.next();
            int numScann = 0;
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Może innym razem, pa!");
                over = true;
                scanner.close();
            } else {
                try{
                    numScann = Integer.parseInt(input);
                }
                catch(Exception e){
                    System.out.println("Błędna wartość! Podaj liczbę z zakresu od 1 do 6!");
                    continue;
                }
            }
            boolean contains = Arrays.asList(compNums).contains(numScann);
            int length = 4;
            int [] playerNums = new int [length];
            if (numScann >= 1 && numScann <= 6){
                System.out.println("Podaj cztery liczby od 1 do 6. " +Arrays.toString(playerNums)+ " pozostało " +maxTries+ " prób." +compNums);
                for(int i = 0; i < length; i++){
                    playerNums[i] = scanner.nextInt();
                    maxTries--;
                    if(contains == true){
                        System.out.println("Kod zawiera podane liczby.");
                    }else{
                        System.out.println("Kod nie zawiera podanych liczb.");
                    }
                    if(compNums[i] == playerNums[i]){
                        trafienie=true;
                    }else {
                       trafienie=false;
                    }
                }
                break;
            } else {
                System.out.printf("Błędna liczba, pozostało ci " + maxTries + " prób.\n");
                maxTries--;
                break;
            }}
            if (trafienie = true){
                points++;
                System.out.println("Zdobywasz punkt! Masz "+points+" punktów.");
            }else {
                System.out.println("Nie zdobywasz punktu. Masz "+points+" punktów.");
            }
            if (maxTries == 0){
                System.out.println("Koniec prób! Spróbuj ponownie wpisując retry, albo wyjdź wpisując quit. Kod którego nie odgadłeś to: " +Arrays.toString(compNums));
                Scanner scanner1 = new Scanner(System.in);
                String input2 = scanner1.nextLine();
                if (input2.equalsIgnoreCase("retry")){
                    maxTries=10;
                    points=0;
                    over=false;
                    System.out.println("Witaj w grze mastermind. \nTwoim zadaniem jest odgadnięcie czterocyfrowego kodu, składającego\nsię z liczb z zakresu od 1 do 6. Wpisz cztery takie liczby\nlub wpisz quit aby wyjść.");

                } else if (input2.equalsIgnoreCase("quit")) {
                    System.out.println("Pa, pa!");
                    over=true;
                    scanner.close();

                } else {
                    System.out.println("Błędna wartość, pa, pa!");
                    over=true;
                    scanner.close();
                }

            }
            }
        }

