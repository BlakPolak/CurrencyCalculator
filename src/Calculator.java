import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Calculator {

    public static void main(String[] args){
        String baseCurrency, targetCurrency;
        Double currency;
        Scanner user_input = new Scanner( System.in );
        try {
            System.out.println("Podaj walutę podstawowa");
            baseCurrency = user_input.next().toUpperCase();

            System.out.println("Podaj walutę docelowa");
            targetCurrency = user_input.next().toUpperCase();

            System.out.println("Podaj kwote");
            currency = user_input.nextDouble();

            Double dupa = exchange(baseCurrency, targetCurrency, currency);
            System.out.println(dupa);
        }catch (InputMismatchException e){
            System.out.println("Currency format example => EUR, PLN");
        }
    }

    public static Double exchange(String baseCurrency, String targetCurrency, Double currency){
        HashMap<String, Double> countryCapitalMap = OpenCsv.getPairsMap();
        Double baseCurrencyValue = countryCapitalMap.get(baseCurrency);
        Double targetCurrencyValue = countryCapitalMap.get(targetCurrency);

        if (baseCurrency.equals("PLN")) {
            currency = currency * targetCurrencyValue;
            return currency;
        } else if (targetCurrency.equals("PLN")) {
            currency = ( currency /baseCurrencyValue );
            return currency;
        } else {
            currency = ( currency / targetCurrencyValue ) * baseCurrencyValue;
            return currency;
        }
    }


}
