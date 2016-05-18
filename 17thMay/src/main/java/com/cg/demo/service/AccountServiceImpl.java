package com.cg.demo.service;

import com.cg.demo.beans.Account;
import com.cg.demo.beans.Customer;
import com.cg.demo.exceptions.InsufficientBalanceException;
import com.cg.demo.exceptions.InvalidAccountException;
import com.cg.demo.exceptions.InvalidInitialAmountException;
import com.cg.demo.repo.AccountRepo;

public class AccountServiceImpl implements AccountService {
	
	private AccountRepo repo;

	public AccountServiceImpl(AccountRepo repo) {
		super();
		this.repo = repo;
	}

	public Account createAccount(Customer c, float amount) throws InvalidInitialAmountException {
		// TODO Auto-generated method stub
		return null;
	}

	public double showBalance(int number) throws InvalidAccountException {
		// TODO Auto-generated method stub
		Account a = repo.findByNumber(number);
		if(a==null){
			throw new InvalidAccountException();
		}
		return a.getBalance();
	}

	public Account withdraw(int number, float amount) throws InvalidAccountException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		if(amount <0){
			throw new IllegalArgumentException();
		}
		Account a = repo.findByNumber(number);
		if(a == null){
			throw new InvalidAccountException();
		}
		if(a.getBalance()<amount){
			throw new InsufficientBalanceException();
		}
		a.setBalance(a.getBalance()-amount);
		return a;
	}

	public Account deposit(int number, float amount) throws InvalidAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
