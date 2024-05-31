package by.VIWARR.TheFinalProject.repositories;

import by.VIWARR.TheFinalProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
