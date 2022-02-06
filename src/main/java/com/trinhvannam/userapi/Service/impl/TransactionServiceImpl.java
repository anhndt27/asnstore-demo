package com.trinhvannam.userapi.Service.impl;

import com.trinhvannam.userapi.Model.Order;
import com.trinhvannam.userapi.Model.Transaction;
import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Repository.OrderRepository;
import com.trinhvannam.userapi.Repository.ProductRepository;
import com.trinhvannam.userapi.Repository.TransactionRepository;
import com.trinhvannam.userapi.Repository.UserRepository;
import com.trinhvannam.userapi.Service.DTO.request.OrderRequestDTO;
import com.trinhvannam.userapi.Service.DTO.request.TransactionRequestDTO;
import com.trinhvannam.userapi.Service.ProductService;
import com.trinhvannam.userapi.Service.TransactionService;
import com.trinhvannam.userapi.Service.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Transaction createNewTransaction(TransactionRequestDTO transactionRequestDTO) {
        User user = userRepository.findUserByPhone(transactionRequestDTO.getUserPhone()).orElse(null);
        if(user == null) {
            user = new User();
            user.setUserEmail(transactionRequestDTO.getUserEmail());
            user.setUserPhone(transactionRequestDTO.getUserPhone());
            user.setUserAddress(transactionRequestDTO.getUserAddress());
            user.setUserFirstName(transactionRequestDTO.getUserFirstName());
            user.setUserLastName(transactionRequestDTO.getUserLastName());
            user = userRepository.saveAndFlush(user);
        }
        TransactionMapper transactionMapper = new TransactionMapper();
        Transaction transaction = transactionMapper.toEntity(transactionRequestDTO);
        transaction.setUser(user);
        transaction = transactionRepository.save(transaction);
        for(OrderRequestDTO orderRequestDTO : transactionRequestDTO.getListProduct()) {
            Order order = new Order();
            order.setOrderPrice(orderRequestDTO.getOrderPrice());
            order.setOrderQuantity(orderRequestDTO.getOrderQuantity());
            order.setOrderCreateAt(Timestamp.from(Instant.now()));
            order.setOrderLastUpdate(Timestamp.from(Instant.now()));
            order.setTransaction(transaction);
            order.setProduct(productRepository.findById(orderRequestDTO.getProductId()).orElse(null));
            orderRepository.saveAndFlush(order);
        };
        return transaction;
    }
}
