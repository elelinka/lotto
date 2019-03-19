package pl.intel.lotto;

import org.apache.commons.lang.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

//    pobrać 6 liczb od użytkownika
//    zwalidować (1. czy liczba jest liczbą, 2. czy jest z zakresu od 1 do 49, 3. czy się nie powtarzają)
//    wylosować 6 liczb całkowitych, od 1 do 49 bez powtórzeń
//    sprawdzić trafienia -
//    poinformować użytkownika

//    public Lotto() {
//
//    }

    private int[] userInput = new int[6];
    private int[] results = new int[6];


    public void getUserDigit() {
        int i = 0;

        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Podaj liczbę");
            String userDigit = userInput.next();

            if (checkIsNumber(userDigit)) {
                int digit = Integer.parseInt(userDigit);
                //System.out.println(Arrays.toString(this.userInput));
                if (isInRange(digit) && isNotRedundand(digit)) {
                    this.userInput[i] = digit;
                    i++;

                    if (i == 6) {
                        break;
                    }
                }

            }
        }

    }

    public boolean isInRange(int digit) {
        if (digit >= 1 && digit <= 49) {
            return true;
        }
        return false;
    }

    public boolean isNotRedundand(int digit) {
        return !checkIsInArray(userInput, digit);
    }

    public boolean checkIsNumber(String digit) {
        return StringUtils.isNumeric(digit);
    }

    // wyszukiwanie elementów w tablicy
    public boolean checkIsInArray(int[] tab, int digit) {
        //System.out.println(Arrays.toString(tab));
        //System.out.println(digit);
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == digit) {
                return true;
            }
        }
        return false;
    }

    public void shuffledDigits() {

        Random generator = new Random();
        System.out.println("Liczby wylosowane:");
        for (int i = 0; i < 6; i++) {
            int digit = (int) (generator.nextDouble() * 48 + 1);
            if (!checkIsInArray(results, digit)) {
                results[i] = digit;
            } else {
                i--;
            }

            System.out.print(digit + " ");
        }

    }

    public void checkedDigits() {

        int winNumb = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[i] == userInput[i]) {

                winNumb++;
                System.out.println("trafienia: " + winNumb);
            }
//            } else {
//                System.out.println("brak trafienia");
//            }
        }

    }
}
