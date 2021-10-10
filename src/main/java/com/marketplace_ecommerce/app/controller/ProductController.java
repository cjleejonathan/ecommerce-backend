package com.marketplace_ecommerce.app.controller;

import com.marketplace_ecommerce.app.dao.ProductRepository;
import com.marketplace_ecommerce.app.entity.Member;
import com.marketplace_ecommerce.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    public ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public String listProducts(Model theModel){
        List<Product> theProducts = productRepository.findAll();

        theModel.addAttribute("products", theProducts);

        return "products/list-products";
    }

    @GetMapping("/showForm")
    public String showForm(Model theModel){
        Product theProduct = new Product();
        Member theMember = new Member();

        theModel.addAttribute("product", theProduct);
        theModel.addAttribute("member", theMember);

        return  "products/form-products";
    }
}
