package com.trinhvannam.userapi.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String productName;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "category_id")
//    @JsonIgnoreProperties("products")
    @JsonIgnoreProperties(value = { "products" }, allowSetters = true)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("order")
    @JsonIgnoreProperties(value = { "product" }, allowSetters = true)
    private List<Order> orders = new ArrayList<>();

    @Column(name = "product_price")
    private float productPrice;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_img_url")
    private String productImgURL;

}
