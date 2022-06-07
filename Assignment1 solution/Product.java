package com.Assignment;
import java.util.ArrayList;
import java.util.Objects;
class ProductService {
    public static ArrayList<Product> produs = Product.getProductsList();
    String produName;
    double temp = 0.00;
    Product product_object, temp_obj;
    ArrayList<Product> newList = new ArrayList<>();

    public String findNameByCode(int productCode) {
        produs.forEach(a -> {
            if (productCode == a.getProductCode()) produName = a.getName();
            else produName = null;

        });
        return ("Product Name: " + produName);
    }

    public Product findMaxPriceProduct(String category) {

        produs.forEach(a -> {
            if (Objects.equals(category, a.getCategory())) {
                product_object = a;
                if (temp < a.getPrice()) {
                    temp = a.getPrice();
                    temp_obj = a;
                }
            } else {
                product_object = null;
            }
        });
        return (temp_obj);
    }

    public ArrayList<Product> getProductsByCategory(String category) {
        produs.forEach(a -> {
            if (Objects.equals(category, a.getCategory())) {
                newList.add(a);
            } else {
                product_object = null;
            }
        });
        return newList;
    }
}

public class Product {
    private int productCode;
    private String name;
    private double price;
    private String category;

    public Product(int productCode, String name, double price, String category) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Product> getProductsList() {
        ArrayList<Product> produs = new ArrayList<>();
        Product V1 = new Product(1, "Car", 1587999.00, "vehicle");
        produs.add(V1);
        Product V2 = new Product(2, "Bus", 8858999.00, "vehicle");
        produs.add(V2);
        Product V3 = new Product(3, "bike", 86000.00, "vehicle");
        produs.add(V3);
        Product C1 = new Product(11, "audi", 8889999.00, "car");
        produs.add(C1);
        Product C2 = new Product(12, "Bmw", 6559999.00, "car");
        produs.add(C2);
        Product C3 = new Product(13, "mercedes", 9552000.00, "car");
        produs.add(C3);
        Product B1 = new Product(31, "TVS", 82000.00, "Bike");
        produs.add(B1);
        Product B2 = new Product(32, "Honda", 82999.00, "Bike");
        produs.add(B2);
        Product B3 = new Product(33, "Yamaha", 122999.00, "Bike");
        produs.add(B3);
        return produs;
    }

    public static void main(String[] args) {

        ProductService productService = new ProductService();
        String produName = productService.findNameByCode(381);
        System.out.println(produName);

        Product product_obj = productService.findMaxPriceProduct("vehicle");
        System.out.println(product_obj);

        ArrayList<Product> products = productService.getProductsByCategory("vehicle");
        if (products != null) {
            for (Product product : products) {
                System.out.println("[ product code: " + product.getProductCode() + ", product name: " + product.getName() + ", product price: Rs." + product.getPrice() + ", product category: " + product.getCategory() + " ]");
            }
        }
    }
}

