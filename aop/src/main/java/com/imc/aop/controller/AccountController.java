package com.imc.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imc.aop.service.AccountService;

@RestController
@RequestMapping("/account/create")
public class AccountController {
	
	@Autowired
	private AccountService accService;
	
	@GetMapping("/{str}")
	public String createAccount(@PathVariable("str") String str) {
		System.out.println(str);
		accService.createAccount();
		return str;
	}

	@GetMapping("/set")
	public void setSomething() {
		System.out.println("Setting something");
	}
	@GetMapping("/get")
	public void getSomething() {
		System.out.println("Getting something");
	}
}
