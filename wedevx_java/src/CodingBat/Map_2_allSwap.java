package CodingBat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Map_2_allSwap {
    public static void main(String[] args) {
        String[] strings = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
        allSwap(strings);
    }

    public static String[] allSwap(String[] strings) {
        Map<String,String> tempMap = new HashMap<>();
        String[] result = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
    System.out.println(str);
            String letter = String.valueOf(str.charAt(0));
            String remain = str.substring(1);
   //==========================================================================================================
            if (tempMap.containsKey(letter)){
                String firstStr = letter.concat(tempMap.get(letter));
                int index = Arrays.binarySearch(strings,firstStr);
    System.out.println("***** " + Arrays.binarySearch(strings,firstStr));
    System.out.println(letter.concat(tempMap.get(letter)) + "  " + index);
                result[index] = str;
                result[i] = letter.concat(tempMap.get(letter));
    //System.out.println(tempMap);
    //System.out.println(Arrays.toString(result));

                tempMap.remove(letter);

            }
    //==========================================================================================================
            else tempMap.put(letter,remain);
    System.out.println(tempMap);
    System.out.println(Arrays.toString(strings));
        } return result;
    }

}


