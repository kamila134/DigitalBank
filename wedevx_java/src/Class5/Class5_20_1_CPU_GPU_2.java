package Class5;
import java.util.Scanner;

public class Class5_20_1_CPU_GPU_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a computer component (CPU, GPU, RAM, storage):");
        String computerComponent = sc.next();
        System.out.println("Enter a computer type (desktop, laptop):");
        String computerType = sc.next();

        switch (computerComponent) {
            case "CPU":
                switch (computerType) {
                    case "desktop":
                        System.out.println("The AMD Ryzen 9 5950X is a popular CPU choice for high-performance desktops");
                        break;
                    case "laptop":
                        System.out.println("The Intel Core i7 is a popular CPU choice for high-performance laptops");
                        break;
                    default:
                        System.out.println("Invalid computer type");
                }
                break;

            case "GPU":
                switch (computerType) {
                    case "desktop":
                        System.out.println("The NVIDIA GeForce RTX 3090 is a popular GPU choice for high-performance desktops");
                        break;
                    case "laptop":
                        System.out.println("The NVIDIA GeForce RTX 3080 is a popular GPU choice for high-performance laptops");
                        break;
                    default:
                        System.out.println("Invalid computer type");
                }
                break;

            case "RAM":
                switch (computerType) {
                    case "desktop":
                        System.out.println("The G.SKILL Trident Z RGB is a popular RAM choice for high-performance desktops");
                        break;
                    case "laptop":
                        System.out.println("The Corsair Vengeance SODIMM is a popular RAM choice for high-performance laptops");
                        break;
                    default:
                        System.out.println("Invalid computer type");
                }
                break;

            case "storage":
                switch (computerType) {
                    case "desktop":
                        System.out.println("The Samsung 970 EVO Plus is a popular storage choice for high-performance desktops");
                        break;
                    case "laptop":
                        System.out.println("The Western Digital Black SN750 is a popular storage choice for high-performance laptops");
                        break;
                    default:
                        System.out.println("Invalid computer type");
                }
                break;
            default:
                System.out.println("Invalid computer component");
        }
    }
}
