package Class11;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class c11_putAll_method {
    public static void main(String[] args) {
        Map<Integer,String> countryCodeUE = new TreeMap<>();
        countryCodeUE.put(1, "France");
        countryCodeUE.put(2, "Germany");
        countryCodeUE.put(2, "United Kingdom");
        System.out.println(" EU = " + countryCodeUE);


        Map<Integer,String> countryCode = new TreeMap<>();
        countryCode.put(4, "United States");
        countryCode.put(5, "China");
        countryCode.put(6, "South Korea");
        countryCode.put(1, "Poland");
        System.out.println(" World = " + countryCode);



        System.out.println("===============");
        countryCodeUE.putAll(countryCode);
        System.out.println(" EU = " + countryCodeUE);
    }
}
