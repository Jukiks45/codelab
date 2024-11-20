public class Product {
    public static final double diskon = 0.9;
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
    }

    public void displayProduct() {
        // 10% discount
        System.out.println("Product Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Discounted Price: $" + calculateDiscount());//ini refactor
        System.out.println("Stock: " + getStock());
    }

    private double calculateDiscount() {
        return getPrice() * diskon;
    }

    public void applyStockAdjustment(int adjustment) {
        applyStockAdjustment(this, adjustment);
    }

    public static void applyStockAdjustment(Product product, int adjustment) {
        product.setStock(product.getStock() + adjustment);
        System.out.println("Stock adjusted. New stock: " + product.getStock());
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
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

public class Inventory {
    public Product product;
    public String location;

    public Inventory(Product product, String location) {
        this.product = product;
        this.location = location;
    }

    public void showInventory() {
        System.out.println("Location: " + location);
        product.displayProduct();
    }
}

public class MainApp {
    public static void main(String[] args) {
        Product prod = new Product("Smartphone", 699.99, 56);
        Inventory inv = new Inventory(prod, "Warehouse A");

        inv.showInventory();
        prod.applyStockAdjustment(10);
        inv.showInventory();
    }
}