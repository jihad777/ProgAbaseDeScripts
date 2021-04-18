package org.sid.productms.web;

import org.sid.productms.entities.Product;
import org.sid.productms.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(path = "/produits")
    public List<Product> listProducts(){
        return produitRepository.findAll();
    }
    @GetMapping(path = "/produits/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
    }
    @GetMapping(path = "/produits/search")
    public List<Product> search(@RequestParam(name = "kw") String kw){
        return produitRepository.findByNameContains(kw);
    }
    @GetMapping(path = "/produits/priceGreater")
    public List<Product> priceGreater(@RequestParam(name = "value") double value){
        return produitRepository.findByPriceGreaterThan(value);
    }
    @PostMapping(path = "/produits")
    public Product saveP(@RequestBody Product p){
        return produitRepository.save(p);
    }
    @PutMapping(path = "/produits/{id}")
    public Product updateP(@PathVariable Long id, @RequestBody Product p){
        p.setId(id);
        return produitRepository.save(p);
    }
    @DeleteMapping(path = "/produits/{id}")
    public void deleteP(@PathVariable Long id){
        produitRepository.deleteById(id);
    }
}
