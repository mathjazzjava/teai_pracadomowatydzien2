package com.mathjazz.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Start")
public class ShopStart {

    private ProductService productService;

    @Autowired
    public ShopStart(ProductService productService) {

        this.productService = productService;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void showProduct() {
        double sum=0;

        for (Product product : productService.getProducts()) {
            System.out.printf(product.getName() +" " +"%3.2f", product.getPrice());
            System.out.println(" zł");
            sum+=product.getPrice();
        }
        System.out.printf("Suma: " +"%.2f", sum);
        System.out.print(" zł");
    }
}
