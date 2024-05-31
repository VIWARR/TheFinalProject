package by.VIWARR.TheFinalProject.services;

import by.VIWARR.TheFinalProject.models.Product;
import by.VIWARR.TheFinalProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(

        )
    }


}
