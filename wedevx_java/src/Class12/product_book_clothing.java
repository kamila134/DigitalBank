package Class12;

public class product_book_clothing {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1", 10.99);
        Product product2 = new Product("Product 2", 20.49, 5);
        Product product3 = new Product("Product 3", 5.99, 2, "Description for Product 3", true);
        Book book1 = new Book("Book 1", 15.99, "Author 1", "Genre 1");
        Book book2 = new Book("Book 2", 25.49, "Author 2", "Genre 2", 300);
        Book book3 = new Book("Book 3", 12.99, "Author 3", "Genre 3", 250, 2020);

        Clothing clothing1 = new Clothing("Shirt", 29.99, "M", "Cotton");
        Clothing clothing2 = new Clothing("Pants", 39.99, "L", "Denim", "Blue");
        Clothing clothing3 = new Clothing("Dress", 49.99, "S", "Silk", "Red", "Female");

        Electronics electronics1 = new Electronics("Phone", 599.99, "Brand X", 12);
        Electronics electronics2 = new Electronics("Laptop", 999.99, "Brand Y", 24, true);
        Electronics electronics3 = new Electronics("Tablet", 299.99, "Brand Z", 6, true, true);

        System.out.println("----- Product 1 -----");
        printNonNull("Name", product1.getName());
        printNonNull("Price", product1.getPrice());
        printNonNull("Quantity", product1.getQuantity());
        printNonNull("Description", product1.getDescription());
        printNonNull("Is Available", product1.isAvailable());

        System.out.println("----- Book 1 -----");
        printNonNull("Name", book1.getName());
        printNonNull("Price", book1.getPrice());
        printNonNull("Author", book1.getAuthor());
        printNonNull("Genre", book1.getGenre());
        printNonNull("Page Count", book1.getPageCount());
        printNonNull("Publication Year", book1.getPublicationYear());
        printNonNull("Rating", book1.getRating());

        System.out.println("----- Clothing 1 -----");
        printNonNull("Name", clothing1.getName());
        printNonNull("Price", clothing1.getPrice());
        printNonNull("Size", clothing1.getSize());
        printNonNull("Material", clothing1.getMaterial());
        printNonNull("Color", clothing1.getColor());
        printNonNull("Gender", clothing1.getGender());

        System.out.println("----- Electronics 1 -----");
        printNonNull("Name", electronics1.getName());
        printNonNull("Price", electronics1.getPrice());
        printNonNull("Brand", electronics1.getBrand());
        printNonNull("Warranty Period", electronics1.getWarrantyPeriod());
        printNonNull("Has Battery", electronics1.hasBattery());
        printNonNull("Is Portable", electronics1.isPortable());
    }

    private static void printNonNull(String label, Object value) {
        if (value != null) {
            System.out.println(label + ": " + value);
        }
        int h = 6/0;
    }
    }



class Product {
    private  String name;
    private double price;
    private  int quantity;
    private  String description;
    private  boolean isAvailable;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, int quantity) {
        this(name, price);
        this.quantity = quantity;
    }

    public Product(String name, double price, int quantity, String description, boolean isAvailable) {
        this(name, price, quantity);
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
}

class Book extends Product{
    private String author;
    private String genre;
    private  int pageCount;
    private  int publicationYear;
    private double rating;


    public Book(String name, double price, String author, String genre) {
        super(name, price);
        this.author = author;
        this.genre = genre;
    }

    public Book(String name, double price, String author, String genre, int pageCount) {
        this(name, price, author,genre);
        this.pageCount = pageCount;
    }
    public Book(String name, double price, String author, String genre, int pageCount, int publicationYear) {
        this(name, price, author,genre, pageCount);
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }
}

class Clothing extends Product {
    private  String size;
    private String material;
    private String color;
    private String gender;

    public Clothing(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    public Clothing(String name, double price, String size, String material, String color) {
        this(name, price, size, material);
        this.color = color;

    }
    public Clothing(String name, double price, String size, String material, String color, String gender) {
        this(name, price, size, material, color);
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public String getGender() {
        return gender;
    }
}

class Electronics extends Product {
    private String brand;
    private int warrantyPeriod;
    private  boolean hasBattery;
    private  boolean isPortable;
    private  String[] connectivityOptions;

    public Electronics(String name, double price, String brand, int warrantyPeriod) {
        super(name, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronics(String name, double price, String brand, int warrantyPeriod, boolean hasBattery) {
        this(name, price, brand, warrantyPeriod);
        this.hasBattery = hasBattery;
    }

    public Electronics(String name, double price, String brand, int warrantyPeriod, boolean hasBattery, boolean isPortable) {
        this(name, price, brand, warrantyPeriod, hasBattery);
        this.isPortable = isPortable;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public boolean hasBattery() {
        return hasBattery;
    }

    public boolean isPortable() {
        return isPortable;
    }

    public String[] getConnectivityOptions() {
        return connectivityOptions;
    }
}


























