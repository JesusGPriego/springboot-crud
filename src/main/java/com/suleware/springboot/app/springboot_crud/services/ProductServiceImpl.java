package com.suleware.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suleware.springboot.app.springboot_crud.entities.Product;
import com.suleware.springboot.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional()
    @Override
    public Product save(Product p) {
        return repository.save(p);
    }

    @Transactional()
    @Override
    public Optional<Product> update(Long id, Product p) {
        Optional<Product> oProduct = repository.findById(id);
        oProduct.ifPresent(product -> {
            p.setId(id);
            repository.save(p);
        });
        return oProduct;
    }

    @Transactional()
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> oProduct = repository.findById(id);
        oProduct.ifPresent(repository::delete);
        return oProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return repository.existsBySku(sku);
    }

}
