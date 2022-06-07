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

