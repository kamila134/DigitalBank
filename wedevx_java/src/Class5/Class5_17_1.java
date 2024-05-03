package Class5;

// The original exercise was to use Scanner but below I am experimenting on my own with double variables for switch method

public class Class5_17_1 {
    public static void main(String[] args) {
        int number = 89;
        int num2 = 4;
        //re, mi, fa, sol, la, ti

        switch (number | num2) {
            case 1:
                System.out.print("The corresponding musical note is ");
                System.out.println("do");
                break;
            case 2:
                System.out.print("The corresponding musical note is ");
                System.out.println("re");
                break;
            case 3:
                System.out.print("The corresponding musical note is ");
                System.out.println("mi");
                break;
            case 4:
                System.out.print("The corresponding musical note is ");
                System.out.println("fa");
                break;
            case 5:
                System.out.print("The corresponding musical note is ");
                System.out.println("sol");
                break;
            case 6:
                System.out.print("The corresponding musical note is ");
                System.out.println("la");
                break;
            case 7:
                System.out.print("The corresponding musical note is ");
                System.out.println("ti");
                break;
            default:
                System.out.println("Error: Invalid input. Please enter a number between 1 and 7");
        }
    }
}


//Enter a number between 1 and 7:
//The corresponding musical note is do