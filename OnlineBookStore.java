// Book class
class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and Setter methods
    // ...

    // Other methods
    // ...
}

// EBook class (subclass of Book)
class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, double price, int quantity, String fileFormat) {
        super(title, author, price, quantity);
        this.fileFormat = fileFormat;
    }

    // Getter and Setter methods
    // ...

    public void openBook() {
        System.out.println("The book is opened. You may start reading.");
    }

    public void downloadBook() {
        System.out.println("The book has begun downloading.");
    }

    public boolean validateFormat() {
        return fileFormat.equals(".pdf") || fileFormat.equals(".epub");
    }
}

// PhysicalBook class (subclass of Book)
class PhysicalBook extends Book {
    private double weight;

    public PhysicalBook(String title, String author, double price, int quantity, double weight) {
        super(title, author, price, quantity);
        this.weight = weight;
    }

    // Getter and Setter methods
    // ...

    public double calculateShippingCost() {
        double baseCost = 4.50;
        double additionalWeight = weight - 500;
        int additionalCharge = (int) Math.ceil(additionalWeight / 250.0);
        return baseCost + (additionalCharge * 1.00);
    }

    public double getWeightInPounds() {
        return weight * 0.00220462;
    }
}

// Testing the classes
public class OnlineBookstore {
    public static void main(String[] args) {
        // Creating an eBook object
        EBook eBook = new EBook("Java Programming", "John Smith", 9.99, 100, ".pdf");
        eBook.openBook();
        eBook.downloadBook();
        System.out.println("Valid format: " + eBook.validateFormat());

        // Creating a physical book object
        PhysicalBook physicalBook = new PhysicalBook("Data Structures", "Jane Doe", 19.99, 50, 750);
        System.out.println("Shipping cost: $" + physicalBook.calculateShippingCost());
        System.out.println("Weight in pounds: " + physicalBook.getWeightInPounds());
    }
}
