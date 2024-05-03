package CodingBat;

public class String_H_countYZ {
    public static void main(String[] args) {
        String str = "fez day";
        int counter = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'y' || str.charAt(i) == 'z' ) {
                if (i == str.length()-1 || !Character.isLetter(str.charAt(i+1))) {
                    counter++;
                }
            }
        } System.out.println(counter);
    }
}
