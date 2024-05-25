package com.imc.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imc.aop.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public String createAccount() {
		return repository.createAccount();
	}

}
