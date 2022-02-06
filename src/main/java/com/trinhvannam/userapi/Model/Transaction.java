package com.trinhvannam.userapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "transaction_total_pay")
    private float transactionTotalPay;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("transactions")
    private User user;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("transaction")
    private List<Order> orders = new ArrayList<>();

    @Column(name = "transaction_create_at")
    private Timestamp transactionCreateAt;

    @Column(name = "transaction_last_update")
    private Timestamp transactionLastUpdate;
}
