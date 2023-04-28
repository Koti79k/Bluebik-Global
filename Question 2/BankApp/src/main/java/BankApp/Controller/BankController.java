package BankApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BankApp.Entity.Account;
import BankApp.Entity.User;
import BankApp.Exception.UserNotFountException;
import BankApp.Service.BankService;

@RestController
public class BankController {

	@Autowired
	private BankService bService;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUserDetails(@RequestBody User user){
		User save = bService.saveUserDetails(user);
		return new ResponseEntity<User>(save,HttpStatus.CREATED);
	}
	
	@PostMapping("/account/{id}")
	public ResponseEntity<Account> saveAccountDeatails(@RequestParam("id") Long id,@RequestBody Account account) throws UserNotFountException{
		Account save = bService.saveAccountDetails(account, id);
		return new ResponseEntity<Account>(save,HttpStatus.CREATED);
	}
}
