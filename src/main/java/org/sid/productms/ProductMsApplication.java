package org.sid.productms;

import org.sid.productms.entities.Product;
import org.sid.productms.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductMsApplication implements CommandLineRunner {
    @Autowired
    private ProduitRepository produitRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProductMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        produitRepository.save(new Product(null,"Computer",8000,10));
        produitRepository.save(new Product(null,"printer",850,45));
        produitRepository.save(new Product(null,"Smartphone",2000,25));

        produitRepository.findAll().forEach(product ->
                System.out.println(product.getName()));
    }
}
