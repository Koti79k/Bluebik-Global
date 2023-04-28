package BankApp.Service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BankApp.Entity.Account;
import BankApp.Entity.User;
import BankApp.Exception.NotFountException;
import BankApp.Repositery.AccountRepositery;
import BankApp.Repositery.UserRepositery;

@Service
public class BankServiceImple implements BankService{
	
	@Autowired
	private UserRepositery uRepo;

	@Autowired
	private AccountRepositery aRepo;
	
	private static final BigDecimal MAX_BALANCE = BigDecimal.valueOf(10000000);
	private static final BigDecimal MIN_BALANCE = BigDecimal.ZERO;
	
	@Override
	public User saveUserDetails(User user) {
		return uRepo.save(user);
	}

	@Override
	public Account saveAccountDetails(Account account, Long userId) throws NotFountException {
		Optional<User> find_user = uRepo.findById(userId);
		if(find_user.isPresent()) {
			return aRepo.save(account);
		}
		else {
			throw new NotFountException("User Not Found");
		}
	}
	
	@Override
	public void credit(Long user_id, Long account_id, BigDecimal amount) throws NotFountException {
	   Account account = aRepo.findById(account_id).orElseThrow(null);
	   User user = uRepo.findById(user_id).get();
	   
	   if(account==null) {
		   throw new NotFountException("Account Not Found");
	   }
	   
	   if(user==null) {
		   throw new NotFountException("User Not Found");
	   }
	   
	   BigDecimal newBalance = account.getBalance().add(amount);
       if(newBalance.compareTo(MAX_BALANCE) > 0) {
    	   throw new NotFountException("Account balance should be Less than 10 Millions ");
       }
       account.setBalance(newBalance);
       aRepo.save(account);
       System.out.println("Successfully Deposited ...");
	}

	@Override
	public void debit(Long user_id, Long account_id, BigDecimal amount) throws NotFountException {
		   Account account = aRepo.findById(account_id).orElseThrow(null);
		   User user = uRepo.findById(user_id).get();
		   
		   if(account==null) {
			   throw new NotFountException("Account Not Found");
		   }
		   
		   if(user==null) {
			   throw new NotFountException("User Not Found");
		   }
		   
		   BigDecimal newBalance = account.getBalance().subtract(amount);
	       if(newBalance.compareTo(MIN_BALANCE) < 0) {
	    	   throw new NotFountException("Account balance should be not Less than Zero ");
	       }
	       account.setBalance(newBalance);
	       aRepo.save(account);
	       System.out.println("Successfully Withdraw From Account ...");
	}

}
