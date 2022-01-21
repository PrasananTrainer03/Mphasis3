package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WalletService {

	@Autowired
	WalletDAO dao;
	
	public Wallet[] showCustomerWallets(int customerId) {
		List<Wallet> walletList = dao.showCustomerWallets(customerId);
		return walletList.toArray(new Wallet[walletList.size()]);
	}
	
	public Wallet searchByWalletId(int walletId) {
		return dao.searchByWalletId(walletId);
	}
}
