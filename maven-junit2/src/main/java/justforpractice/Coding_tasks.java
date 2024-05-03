package justforpractice;

public class Coding_tasks {
    public static void main(String[] args) {
//    Write a function that returns the index of the first non-repeating character in a string.

//    GetIndexOfFirstNonRepeatingCharacter(“Toronto”); // Returns 2
//    GetIndexOfFirstNonRepeatingCharacter(“Ceridian”); // Returns 0

//        int result = GetIndexOfFirstNonRepeatingCharacter("Toronto");
//        System.out.println(result);
//
//        int result2 = GetIndexOfFirstNonRepeatingCharacter("Ceridian");
//        System.out.println(result2);

        String lol = "hello miss you";
        System.out.println(lol.charAt(lol.indexOf("miss") + 5));

    }

    public static int GetIndexOfFirstNonRepeatingCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            String startingLetter = String.valueOf(str.charAt(i));
            boolean isUnique = true;
            for (int j = str.length()-1; j > i; j--) {
                String endingLetter = String.valueOf(str.charAt(j));
                if (startingLetter.equalsIgnoreCase(endingLetter)) {
                    isUnique = false;
                    break;
                }
            } if (isUnique) {
                return i;
            }
        }
        return -1;
    }
}
