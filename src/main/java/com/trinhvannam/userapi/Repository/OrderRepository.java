package com.trinhvannam.userapi.Repository;

import com.trinhvannam.userapi.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
