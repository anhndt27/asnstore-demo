package com.trinhvannam.userapi.Service;

import com.trinhvannam.userapi.Model.Transaction;
import com.trinhvannam.userapi.Service.DTO.request.TransactionRequestDTO;

public interface TransactionService {
    public Transaction createNewTransaction(TransactionRequestDTO transactionRequestDTO);
}
