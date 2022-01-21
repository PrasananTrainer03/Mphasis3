package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

	@Autowired
	WalletService service;
	
	@RequestMapping("/showAllWallets/{custId}")
	public Wallet[] showAllWallet(@PathVariable int custId) {
		return service.showCustomerWallets(custId);
	}
	
	@RequestMapping("/searchByWalletId/{walletId}")
	public Wallet searchByWalletId(@PathVariable int walletId) {
		return service.searchByWalletId(walletId);
	}
}
