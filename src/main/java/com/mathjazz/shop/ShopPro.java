package com.mathjazz.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
public class ShopPro {

    @Value("${shop-component.tax}")
    private double tax;

    @Value("${shop-component.discount}")
    private double discount;

    private ProductService productService;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProduct() {
        double sum=0;

        for (Product product : productService.getProducts()) {
            System.out.printf(product.getName() +"  " +"%3.2f", product.getPrice());
            System.out.print(" zł");
            System.out.printf("  cena z VAT: " +"%3.2f", product.getPrice()*(1+tax));
            System.out.print(" zł");
            System.out.printf("  cena+VAT-rabat: " +"%3.2f", product.getPrice()*(1+tax)*(1-discount));
            System.out.println(" zł");
            sum+=product.getPrice()*(1+tax)*(1-discount);
        }
        System.out.printf("Suma: " +"%.2f", sum);
        System.out.print(" zł");
    }
}
