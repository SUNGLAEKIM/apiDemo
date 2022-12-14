package com.demo.apiDemo.product;

import com.demo.apiDemo.cart.CartList;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private Long baseProductId;
    private String productName;
    private int price;
    private String description;
    @OneToOne(mappedBy = "product", fetch = FetchType.EAGER)
    @JsonBackReference
    private CartList cartLists;

}
