package com.trinhvannam.userapi.Repository;

import com.trinhvannam.userapi.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
