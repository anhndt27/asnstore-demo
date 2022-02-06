package com.trinhvannam.userapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "order_price")
    private float orderPrice;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    @JsonIgnoreProperties("orders")
//    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
//    @JsonIgnoreProperties("orders")
    @JsonIgnoreProperties(value = { "orders" }, allowSetters = true)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
//    @JsonIgnoreProperties("orders")
    @JsonIgnoreProperties(value = { "orders" }, allowSetters = true)
    private Transaction transaction;

    @Column(name = "order_create_at")
    private Timestamp orderCreateAt;

    @Column(name = "order_last_update")
    private Timestamp orderLastUpdate;
}
