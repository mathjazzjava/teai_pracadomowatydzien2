package com.mathjazz.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Plus")
public class ShopPlus {

    @Value("${shop-component.tax}")
    private double tax;

    private ProductService productService;

    @Autowired
    public ShopPlus(ProductService productService) {

        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProduct() {
        double sum=0;

        for (Product product : productService.getProducts()) {
            System.out.printf(product.getName() +"  " +"%3.2f", product.getPrice());
            System.out.print(" zł");
            System.out.printf("  cena z VAT: " +"%3.2f", product.getPrice()*(1+tax));
            System.out.println(" zł");
            sum+=product.getPrice()*(1+tax);
        }

        System.out.printf("Suma: " +"%.2f", sum);
        System.out.print(" zł");
    }
}
