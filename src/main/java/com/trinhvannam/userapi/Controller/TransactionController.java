package com.trinhvannam.userapi.Controller;

import com.trinhvannam.userapi.Exception.BadRequestAlertException;
import com.trinhvannam.userapi.Exception.ResourceNotFoundException;
import com.trinhvannam.userapi.Model.Transaction;
import com.trinhvannam.userapi.Repository.TransactionRepository;
import com.trinhvannam.userapi.Service.DTO.request.TransactionRequestDTO;
import com.trinhvannam.userapi.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        if(transactionRequestDTO.getTransactionTotalPay() <= 0) {
            throw new BadRequestAlertException("Tong tien phai lon hon 0!.", "ENTITY_NAME", "data-notfound");
        }
        return ResponseEntity.ok().body(transactionService.createNewTransaction(transactionRequestDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

}
