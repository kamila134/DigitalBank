package Class11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c11_14_1_MapList_ComplexSorting {
    public static void main(String[] args) {
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Sed euismod ex eget urna sollicitudin, quis sagittis nisl vestibulum. Curabitur rhoncus, purus ac tincidunt tempus, ligula purus pharetra e1x, sed rutrum risus risus nec urna. Fusce malesuada velit vel risus pellentesque tincidunt. Etiam auctor augue ac condimentum mollis. Nunc malesuada volutpat lacinia. Proin sed semper lacus. Quisque non nunc quis ligula elementum lacinia eu ac sem. Maecenas gravida lorem in volutpat fermentum. Aliquam interdum posuere quam, sed eleifend tortor condimentum sed. Donec ullamcorper bibendum ni2si, nec tempus metus cursus ac. Nam euismod sagittis nunc, sit amet fringilla libero fermentum eu. Sed aliquam quam at orci ullamcorper vestibulum. Integer nec malesuada libero. Donec venenatis facilisis tortor, sit amet cursus justo lobortis ac. Pellentesque dignissim libero nec orci congu3e, sit amet rhoncus orci faucibus.";
        String[] arr = input.split(" ");
        List<String> uppercase = new ArrayList<>();
        List<String> lowercase = new ArrayList<>();
        List<String> specials = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        Map<String,List<String>> finalMap = new HashMap<>();
        for (String word: arr) {
            int hasUpper = 0;
            int hasSpecial = 0;
            int hasDigit = 0;
            for (int i = 0; i < word.length(); i++) {
               // System.out.println(hasUpper + "  " + word);
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    hasDigit++;
                }  if (c == Character.toUpperCase(c) && Character.isLetter(c)) {
                    hasUpper++;
                    //System.out.println(hasUpper + "  " + word);
                }  if (!Character.isDigit(c) && !Character.isLetter(c)) {
                    specials.add(word);

                }
            } if (hasUpper == 0) {
                lowercase.add(word);
                System.out.println(word);
            } else if (hasUpper > 0) {
                uppercase.add(word);
            } if (hasDigit > 0) {
                digits.add(word);
            }
        }
        finalMap.put("Has Uppercase", uppercase);
        finalMap.put("All Lowercase", lowercase);
        finalMap.put("Has Special Character", specials);
        finalMap.put("Has Digit", digits);

    }
}
