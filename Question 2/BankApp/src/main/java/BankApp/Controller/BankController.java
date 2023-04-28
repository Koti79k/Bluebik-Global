package BankApp.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BankApp.Entity.Account;
import BankApp.Entity.User;
import BankApp.Exception.NotFountException;
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
	public ResponseEntity<Account> saveAccountDeatails(@RequestParam("id") Long id,@RequestBody Account account) throws NotFountException
	{
		Account save = bService.saveAccountDetails(account, id);
		return new ResponseEntity<Account>(save,HttpStatus.CREATED);
	}
	
	@PostMapping("/credit")
	public void credit(@RequestParam Long accound_id, @RequestParam Long user_id, @RequestParam BigDecimal amount) throws NotFountException{		
			bService.credit(user_id, accound_id, amount);				
	}
	
	@PostMapping("/debit")
	public void debit(@RequestParam Long accound_id, @RequestParam Long user_id, @RequestParam BigDecimal amount) throws NotFountException{	
			bService.debit(user_id, accound_id, amount);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccountDetails() throws NotFountException{
		List<Account> L1 = bService.getAllAccountDetails();
		return new ResponseEntity<List<Account>>(L1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUserDetails() throws NotFountException{
		List<User> L1 = bService.getAllUserDetails();
		return new ResponseEntity<List<User>>(L1,HttpStatus.ACCEPTED);
	}
	
}
