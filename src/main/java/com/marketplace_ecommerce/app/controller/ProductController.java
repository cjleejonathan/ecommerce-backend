package com.marketplace_ecommerce.app.controller;

import com.marketplace_ecommerce.app.dao.ProductRepository;
import com.marketplace_ecommerce.app.entity.Member;
import com.marketplace_ecommerce.app.entity.Product;
import com.marketplace_ecommerce.app.service.MemberService;
import com.marketplace_ecommerce.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/list")
    public String listProducts(Model theModel){
        List<Product> theProducts = productService.findAll();

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

    @PostMapping("/save")
    public String saveUpdateProduct(@ModelAttribute("product") Product product,
                                    @ModelAttribute("member") Member member,
                                    BindingResult bindingResult){

        // check is member exist?
        String theEmail = member.getEmail();

        Member memberFromDB = memberService.FindByEmail(theEmail);

        if(memberFromDB != null){

            member = memberFromDB;
        }

        // set product active status to true
        product.setActive(true);

        // set member to product
        product.setMember(member);

        // add product to member set<>
        member.add(product);

        memberService.save(member);

        productService.save(product);
        return "products/list-products";
    }

    @DeleteMapping("/delete")
    public String onDelete(@RequestParam("id") Long id) {
        productService.onDelete(id);
        return "products/list-products";
    }


    // testing method: JSON format
    // @RequestBody is an annotation used to request JSON or other format Data from HTTP request body

//    @PostMapping("/save")
//    public String saveUpdateProduct(@RequestBody Product product){
//
//        Member member = product.getMember();
//
//        String theEmail = member.getEmail();
//
//        Member memberFromDB = memberRepository.findByEmail(theEmail);
//
//        if(memberFromDB != null){
//
//            member = memberFromDB;
//        }
//
//        member.add(product);
//
//        memberRepository.save(member);
//
//        productRepository.save(product);
//        return "Success";
//    }


}
