package BankApp.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BankApp.Entity.Transaction;

@Repository
public interface TransactionRepositery extends JpaRepository<Transaction, Long>{

}
