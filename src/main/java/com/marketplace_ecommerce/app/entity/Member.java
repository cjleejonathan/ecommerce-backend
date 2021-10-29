package com.marketplace_ecommerce.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author j0975
 */
@Entity
@Table(name = "member" )
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<Product> products;

    // create new Set container when new Member is insert
    public void add(Product product){

        if(product != null){

            if(products == null){
                products = new HashSet<>();
            }

            products.add(product);
            product.setMember(this);
        }
    }
}
