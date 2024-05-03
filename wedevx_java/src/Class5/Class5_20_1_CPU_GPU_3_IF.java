package Class5;
import java.util.Scanner;

public class Class5_20_1_CPU_GPU_3_IF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a computer type (desktop, laptop):");
        String computerType = sc.nextLine();

        if (!computerType.equals("desktop") && !computerType.equals("laptop")) {
            System.out.println("Invalid computer type");
        } else {
            System.out.println("Enter a computer component (CPU, GPU, RAM, storage):");
            String computerComponent = sc.nextLine();
            if (computerType.equals("desktop")) {
                if (computerComponent.equals("CPU")) {
                    System.out.println("The AMD Ryzen 9 5950X is a popular CPU choice for high-performance desktops");
                }
                else if (computerComponent.equals("GPU")) {
                    System.out.println("The NVIDIA GeForce RTX 3090 is a popular GPU choice for high-performance desktops");
                }
                else if (computerComponent.equals("RAM")) {
                    System.out.println("The G.SKILL Trident Z RGB is a popular RAM choice for high-performance desktops");
                }
                else if (computerComponent.equals("storage")) {
                    System.out.println("The Samsung 970 EVO Plus is a popular storage choice for high-performance desktops");
                } else {
                    System.out.println("Invalid computer component");
                }
            }
            else if (computerType.equals("laptop")) {
                if (computerComponent.equals("CPU")) {
                    System.out.println("The Intel Core i7 is a popular CPU choice for high-performance laptops");
                }
                else if (computerComponent.equals("GPU")) {
                    System.out.println("The NVIDIA GeForce RTX 3080 is a popular GPU choice for high-performance laptops");
                }
                else if (computerComponent.equals("RAM")) {
                    System.out.println("The Corsair Vengeance SODIMM is a popular RAM choice for high-performance laptops");
                }
                else if (computerComponent.equals("GPU")) {
                    System.out.println("The Western Digital Black SN750 is a popular storage choice for high-performance laptops");
                } else {
                    System.out.println("Invalid computer component");
                }
            }
        }
    }
}
