package Class5;

import java.util.Scanner;

public class Class5_20_3_Recipe_Ingredients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cuisine = sc.nextLine();
        String veg = sc.nextLine();

        switch (veg) {
            case "Vegetarian":
                switch (cuisine) {
                    case "Italian":
                        System.out.println("Tomatoes, Basil, Mozzarella, Olive Oil, Pasta");
                        break;
                    case "Mexican":
                        System.out.println("Beans, Tomatoes, Avocado, Corn, Tortillas");
                        break;
                    case "Indian":
                        System.out.println("Lentils, Rice, Spinach, Spices, Naan");
                        break;
                }
            break;
                case "Non-vegetarian":
                switch (cuisine) {
                    case "Italian":
                        System.out.println("Beef, Tomatoes, Garlic, Parmesan, Pasta");
                        break;
                    case "Mexican":
                        System.out.println("Chicken, Beef, Beans, Salsa, Tortillas");
                        break;
                    case "Indian":
                        System.out.println("Chicken, Lamb, Rice, Curry, Naan");
                        break;
                }
        }
    }
}

//Italian:
    //Vegetarian:
        //Tomatoes, Basil, Mozzarella, Olive Oil, Pasta
    //Non-vegetarian:
        //Beef, Tomatoes, Garlic, Parmesan, Pasta
//Mexican:
    //Vegetarian:
        //Beans, Tomatoes, Avocado, Corn, Tortillas
    //Non-vegetarian:
        //Chicken, Beef, Beans, Salsa, Tortillas
//Indian:
    //Vegetarian:
        //Lentils, Rice, Spinach, Spices, Naan
    //Non-vegetarians:
        //Chicken, Lamb, Rice, Curry, Naan