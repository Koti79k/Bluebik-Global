package BankApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BankApp.Entity.Account;
import BankApp.Entity.User;
import BankApp.Exception.UserNotFountException;
import BankApp.Repositery.AccountRepositery;
import BankApp.Repositery.UserRepositery;
import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

@Service
public class BankServiceImple implements BankService{
	
	@Autowired
	private UserRepositery uRepo;

	@Autowired
	private AccountRepositery aRepo;
	
	@Override
	public User saveUserDetails(User user) {
		return uRepo.save(user);
	}

	@Override
	public Account saveAccountDetails(Account account, Long userId) throws UserNotFountException {
		Optional<User> find_user = uRepo.findById(userId);
		if(find_user.isPresent()) {
			return aRepo.save(account);
		}
		else {
			throw new UserNotFountException("User Not Found");
		}
	}


}
