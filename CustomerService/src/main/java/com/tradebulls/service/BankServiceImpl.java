package com.tradebulls.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tradebulls.entity.BankDetails;
import com.tradebulls.repo.BankRepository;

@Service
public class BankServiceImpl implements BankService{
	private BankRepository bankRepository;
	

	public BankServiceImpl(BankRepository bankRepository) {
		super();
		this.bankRepository = bankRepository;
	}


	@Override
	public void saveBankDetails(List<BankDetails> list) {
		// TODO Auto-generated method stub
		bankRepository.saveAll(list);
	}
	
}
