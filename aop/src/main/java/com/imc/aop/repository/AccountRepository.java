package com.imc.aop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
	
	public String createAccount() {
		return "Created Account";
	}

}
