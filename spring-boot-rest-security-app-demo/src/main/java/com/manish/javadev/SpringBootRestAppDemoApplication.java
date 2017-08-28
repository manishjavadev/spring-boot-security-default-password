package com.manish.javadev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.manish.javadev.dao.AccountDao;
import com.manish.javadev.model.Account;
import com.manish.javadev.service.AccountService;

/**
 * @author Manish
 *
 */
@SpringBootApplication
public class SpringBootRestAppDemoApplication implements CommandLineRunner {
	@Autowired
	static AccountDao accountDao;

	@Autowired
	private AccountService accountService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootRestAppDemoApplication.class, args);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("accountService = " + accountService.getClass().getSimpleName());

		Account account = new Account("Saving Account", "Manish", new Double(15000));
		accountService.createAccount(account);

		System.out.println("===================");
		account = accountService.findAccount(new Long(1));
		System.out.println("After Loading The Account info =" + account);
		System.out.println("Done");

	}
}
