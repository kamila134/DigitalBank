package Class12;

import java.util.ArrayList;

public class Ecommerce_12_15 {
    public static void main(String[] args) {


    }
}


class Productnam {
    private static int nextId = 1;

    private int productId;
    private String name;
    private double price;

    public Productnam(String name, double price) {
        this.name = name;
        this.price = price;
        productId = nextId;
        nextId++;
    }


    public int getProductId() {
        return productId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >=0) {
            this.price = price;
        }
        else System.out.println("Invalid price. Price cannot be negative.");
    }
}

class Customerh {
    private static int nextId = 1;
    private int customerId;
    private String name;
    private String email;


    public Customerh(String name, String email) {
        this.name = name;
        this.email = email;
        customerId = nextId;
        nextId++;
    }

    public int getCustomerId() {
        return customerId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Order {
    private static int nextId = 1;
    private int orderId;
    private Customer customer;
    private ArrayList<Product> products;

    //Initializes the Order object with the provided customer,
    // and products with empty ArrayList (new ArrayList<>()),
    // and orderId from nextId, then increase nextId by 1.
    public Order(Customer customer) {
        this.customer = customer;
        products= new ArrayList<>();
        orderId = nextId;
        nextId++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void addProduct(Product product){
        products.add(product);
    } //Adds the product to the products list.
    //
    public double getTotalPrice(){
        double totalPrice = 0;
        for (Product product: products) {
            totalPrice+= product.getPrice();
        } return  totalPrice;
    }

    // Returns the total price of the Order's products list.


}