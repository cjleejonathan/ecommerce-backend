package com.marketplace_ecommerce.app.service;

import com.marketplace_ecommerce.app.dao.MemberRepository;
import com.marketplace_ecommerce.app.dao.ProductRepository;
import com.marketplace_ecommerce.app.entity.Member;
import com.marketplace_ecommerce.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author j0975
 */
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepository) {
        this.productRepository = theProductRepository;
    }

    @Override
    public void onDelete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


}
