package Class6;

public class Class_6_8_Renting_Expenses {
    public static void main(String[] args) {

    }

    public static double netOperatingIncome(double rentalIncome, double expenses, double vacancyRate) {
        double calc = rentalIncome*(100-vacancyRate)/100 - expenses;
        return calc;
    }
}
