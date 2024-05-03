package CodingBat;

public class String_H_equalIsNot {
    public static void main(String[] args) {
        String_H_equalIsNot object = new String_H_equalIsNot();
        boolean result = object.equalIsNot("This is not");
        System.out.println(result);
    }
    public boolean equalIsNot(String str) {
        int is = 0;
        int not = 0;
        int cIs = 0;
        int cNot = 0;
        System.out.println("is = " + is + "   not = " + not);
        System.out.println("index of is: " + str.indexOf("is", is));
        System.out.println("index of not: " + str.indexOf("not", not));
        if (str.indexOf("is", is) >= 0 ) {
            is = str.indexOf("is") + 1;
        } else if (str.indexOf("not", not) >= 0) {
            not = str.indexOf("not") + 1;
        }

        System.out.println();

        System.out.println("is = " + is + "   not = " + not);
        System.out.println("index of is: " + str.indexOf("is", is));
        System.out.println("index of not: " + str.indexOf("not", not));
        if (str.indexOf("is", is) >= 0 ) {
            is = str.indexOf("is") + 1;
        } else if (str.indexOf("not", not) >= 0) {
            not = str.indexOf("not") + 1;
        }

        System.out.println();

        System.out.println("is = " + is + "   not = " + not);
        System.out.println("index of is: " + str.indexOf("is", is));
        System.out.println("index of not: " + str.indexOf("not", not));
        if (str.indexOf("is", is) >= 0 ) {
            is = str.indexOf("is") + 1;
        } else if (str.indexOf("not", not) >= 0) {
            not = str.indexOf("not") + 1;
        }

        System.out.println();

        System.out.println("is = " + is + "   not = " + not);
        System.out.println("index of is: " + str.indexOf("is", is));
        System.out.println("index of not: " + str.indexOf("not", not));








        if (cIs == cNot) return true;
        else return false;
    }

}
