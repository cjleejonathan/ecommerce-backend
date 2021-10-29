package com.marketplace_ecommerce.app.service;

import com.marketplace_ecommerce.app.entity.Member;
import com.marketplace_ecommerce.app.entity.Product;

import java.util.List;

/**
 * @author j0975
 */
public interface ProductService {

    public void onDelete(Long id);

    List<Product> findAll();

    void save(Product product);
}
