package BankApp.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BankApp.Entity.Account;

@Repository
public interface AccountRepositery extends JpaRepository<Account, Long>{

}
