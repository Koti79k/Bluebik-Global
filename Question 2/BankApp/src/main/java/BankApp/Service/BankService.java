package BankApp.Service;

import java.math.BigDecimal;

import BankApp.Entity.Account;
import BankApp.Entity.User;
import BankApp.Exception.NotFountException;

public interface BankService {
   public User saveUserDetails(User user);
   public Account saveAccountDetails(Account account, Long userId) throws NotFountException;
   public void credit(Long user_id, Long account_id, BigDecimal amount) throws NotFountException;
   public void debit(Long user_id, Long account_id, BigDecimal amount) throws NotFountException;
}
