package org.sid.productms.repositories;

import org.sid.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Product, Long> {         //Spring DATA
    @RestResource(path = "/byName")
    public List<Product> findByNameContains(@Param("keyW") String kw);
    public List<Product> findByPriceGreaterThan(double value);
}
