package Class5;

import java.util.Scanner;

public class Class5_20_4_Vehicle_Fuel_Type_Advisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Vehicle Fuel Type Advisor!");
        System.out.println("Enter your vehicle type (Sedan, SUV, Truck, Motorcycle):");
        String vehicleType = sc.nextLine();
        System.out.println("Enter your typical driving habits (City, Highway, Mixed):");
        String drivingHabits = sc.nextLine();

        switch (drivingHabits) {
            case "City":
                switch (vehicleType) {
                    case "Sedan":
                        System.out.println("Recommended Fuel Type: Electric");
                        break;
                    case "SUV":
                        System.out.println("Recommended Fuel Type: Petrol");
                        break;
                }
                break;
            case "Highway":
                switch (vehicleType) {
                    case "Sedan":
                    case "SUV":
                        System.out.println("Recommended Fuel Type: Petrol");
                        break;
                }
                break;
            case "Mixed":
                switch (vehicleType) {
                    case "Sedan":
                        System.out.println("Recommended Fuel Type: Petrol");
                        break;
                    case "SUV":
                        System.out.println("Recommended Fuel Type: Hybrid");
                        break;
                }
                break;
            default:
                    switch (vehicleType) {
                        case "Truck":
                            System.out.println("Recommended Fuel Type: Diesel");
                            break;
                        case "Motorcycle":
                            System.out.println("Recommended Fuel Type: Petrol");
                            break;
                }
        }
    }
}

//Instructions:
//Ask the user for their vehicle type (options: Sedan, SUV, Truck, Motorcycle).
//Ask the user for their typical driving habits (options: City, Highway, Mixed) if user selected Sedan or SUV.
//Use nested switch statements to provide fuel type recommendations based on the following criteria:
    //If the vehicle is a Sedan:
        //For City driving: Recommend Electric for eco-conscious users.
        //For Highway driving: Recommend Diesel for better mileage.
        //For Mixed driving: Recommend Petrol for versatility.
    //If the vehicle is an SUV:
        //For City driving: Recommend Petrol for fuel efficiency.
        //For Highway driving: Recommend Diesel for long-distance travel.
        //For Mixed driving: Recommend Hybrid for a balance of efficiency and power.
    //If the vehicle is a Truck:
        //Recommend Diesel.
    //If the vehicle is a Motorcycle:
        //Recommend Petrol.
//Display the recommended fuel type to the user.

//Example of expected output #1:
    //Welcome to the Vehicle Fuel Type Advisor!
    //Enter your vehicle type (Sedan, SUV, Truck, Motorcycle):
    //Enter your typical driving habits (City, Highway, Mixed):
    //Recommended Fuel Type: Electric