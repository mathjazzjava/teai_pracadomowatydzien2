package com.mathjazz.shop;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private List<Product> productList;
    Random ran = new Random();

    public ProductService() {

        Product prod1 = new Product("ring", 50 + (double)(ran.nextInt(25001))/100);
        Product prod2 = new Product("watch", 50 + (double)(ran.nextInt(25001))/100);
        Product prod3 = new Product("t-shirt", 50 + (double)(ran.nextInt(25001))/100);
        Product prod4 = new Product("pen", 50 + (double)(ran.nextInt(25001))/100);
        Product prod5 = new Product("painting", 50 + (double)(ran.nextInt(25001))/100);

        productList = new ArrayList<>();
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);
        productList.add(prod5);

    }

    public List<Product> getProducts() {
        return productList;
    }

}
