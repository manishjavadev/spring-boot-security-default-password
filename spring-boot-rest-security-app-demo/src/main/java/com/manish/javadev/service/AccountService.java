package com.manish.javadev.service;

import com.manish.javadev.model.Account;

/**
 * @author Manish
 *
 */
public interface AccountService {
	Account createAccount(Account account);

	Account findAccount(Long accountNumber);

	public Account depositAmount(Long accountNumber, Double amount);

	void fundTransfer(Long accountFrom, Long accountTo, Double amount);
}
