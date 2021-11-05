package com.marketplace_ecommerce.app.controller;

import com.marketplace_ecommerce.app.entity.Member;
import com.marketplace_ecommerce.app.entity.Product;
import com.marketplace_ecommerce.app.service.MemberService;
import com.marketplace_ecommerce.app.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author j0975
 */
@Controller
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private ProductService productService;
    private MemberService memberService;

    public ProductController(ProductService theProductService, MemberService theMemberService) {
        this.productService = theProductService;
        this.memberService = theMemberService;
    }

    @PostMapping("/save")
    public void saveUpdateProduct(@RequestBody Product product){

        Member member = product.getMember();

        String theEmail = member.getEmail();

        Member memberFromDB = memberService.findByEmail(theEmail);

        if(memberFromDB != null){

            member = memberFromDB;
        }

        // set product active status to true
        product.setActive(true);

        // add product to member set<>
        member.add(product);

        memberService.save(member);

        productService.save(product);
        return;
    }


}
