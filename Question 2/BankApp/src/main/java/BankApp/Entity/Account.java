package BankApp.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double balance;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_account",joinColumns = @JoinColumn(name="account_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;
}
