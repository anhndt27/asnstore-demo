package com.trinhvannam.userapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userManagement")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_password")
    private String userPass;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "user_firstname")
    private String userFirstName;

    @Column(name = "user_lastname")
    private String userLastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Transaction> transactions = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("user")
//    private List<Order> orders = new ArrayList<>();

//    @Column(name = "remember_token")
//    private Date rememberToken;
//
//    @Column(name = "create_at")
//    private Timestamp createAt;
//
//    @Column(name = "last_update")
//    private Timestamp lastUpdate ;
}