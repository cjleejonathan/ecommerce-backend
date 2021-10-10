package com.marketplace_ecommerce.app.controller;

import com.marketplace_ecommerce.app.dao.MemberRepository;
import com.marketplace_ecommerce.app.dao.ProductRepository;
import com.marketplace_ecommerce.app.entity.Member;
import com.marketplace_ecommerce.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class UpdateProductController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    public UpdateProductController(MemberRepository memberRepository, ProductRepository productRepository){
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/save")
    public String saveUpdateProduct(@ModelAttribute("product") Product product,
                                    @ModelAttribute("member") Member member,
                                    BindingResult bindingResult){

        // check is member exist?
        String theEmail = member.getEmail();

        Member memberFromDB = memberRepository.findByEmail(theEmail);

        if(memberFromDB != null){

            member = memberFromDB;
        }

        // set product active status to true
        product.setActive(true);

        // set member to product
        product.setMember(member);

        // add product to member set<>
        member.add(product);

        memberRepository.save(member);

        productRepository.save(product);
        return "Success";
    }

    // testing method: JSON format
    // @RequestBody is an annotation used to request JSON or other format Data from HTTP request body
/*
    @PostMapping("/save")
    public String saveUpdateProduct(@RequestBody Product product){

        Member member = product.getMember();

        String theEmail = member.getEmail();

        Member memberFromDB = memberRepository.findByEmail(theEmail);

        if(memberFromDB != null){

            member = memberFromDB;
        }

        member.add(product);

        memberRepository.save(member);

        productRepository.save(product);
        return "Success";
    }
*/

}
