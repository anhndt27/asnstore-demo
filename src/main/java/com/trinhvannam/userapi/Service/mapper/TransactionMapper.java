package com.trinhvannam.userapi.Service.mapper;

import com.trinhvannam.userapi.Model.Product;
import com.trinhvannam.userapi.Model.Transaction;
import com.trinhvannam.userapi.Service.DTO.request.ProductRequestDTO;
import com.trinhvannam.userapi.Service.DTO.request.TransactionRequestDTO;

import java.sql.Timestamp;
import java.time.Instant;

public class TransactionMapper {
    public Transaction toEntity(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setTransactionTotalPay(transactionRequestDTO.getTransactionTotalPay());
//        transaction.setUser(transactionRequestDTO.getUser());
        transaction.setTransactionCreateAt(Timestamp.from(Instant.now()));
        transaction.setTransactionLastUpdate(Timestamp.from(Instant.now()));
        return transaction;
    }
}
