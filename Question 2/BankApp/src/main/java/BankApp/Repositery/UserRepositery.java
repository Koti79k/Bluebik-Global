package BankApp.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BankApp.Entity.User;

@Repository
public interface UserRepositery extends JpaRepository<User, Long>{

}
