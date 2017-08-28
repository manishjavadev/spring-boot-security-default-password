package com.manish.javadev.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manish.javadev.model.Account;

/**
 * @author Manish
 *
 */
@Repository
public interface AccountDao extends CrudRepository<Account, Long> {

}
