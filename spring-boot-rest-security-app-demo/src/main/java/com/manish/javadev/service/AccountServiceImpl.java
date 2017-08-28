package com.manish.javadev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.dao.AccountDao;
import com.manish.javadev.model.Account;

/**
 * @author Manish
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	public void setPersonDAO(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public Account createAccount(Account account) {
		Account acccountResult = accountDao.save(account);
		return acccountResult;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public void fundTransfer(Long accountFrom, Long accountTo, Double amount) {
		Account account = accountDao.findOne(accountFrom);
		account.setAmount(account.getAmount() - amount);
		accountDao.save(account);
		account = accountDao.findOne(accountTo);
		account.setAmount(account.getAmount() + amount);
		accountDao.save(account);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public Account depositAmount(Long accountNumber, Double amount) {
		Account account = accountDao.findOne(accountNumber);
		account.setAmount(account.getAmount() + amount);
		return accountDao.save(account);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public Account findAccount(Long accountNumber) {
		return accountDao.findOne(accountNumber);
	}

}
