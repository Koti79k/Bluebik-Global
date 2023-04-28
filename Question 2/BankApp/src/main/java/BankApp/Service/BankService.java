package BankApp.Service;

import BankApp.Entity.Account;
import BankApp.Entity.User;
import BankApp.Exception.UserNotFountException;

public interface BankService {
   public User saveUserDetails(User user);
   public Account saveAccountDetails(Account account, Long userId) throws UserNotFountException;
}
