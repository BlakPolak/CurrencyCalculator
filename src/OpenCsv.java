import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OpenCsv {
//     main for TESTS:
     public static void main(String[] args) {
       HashMap CountryCapitalMap = getPairsMap();
       System.out.println(CountryCapitalMap);
     }

    public static HashMap<String,Double> getPairsMap(){

        String csvFile = "/home/ppolak/Desktop/Java/Coding Dojo- Currency Calculator/money.csv";
        BufferedReader br = null;
        String line = "";
        HashMap <String, Double> CountryCapitalMap = new HashMap<String, Double>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
                CountryCapitalMap.put(country[0], Double.parseDouble(country[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return CountryCapitalMap;
    }
}

