package com.tradebulls.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tradebulls.entity.AddressDetails;
import com.tradebulls.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;

	public AddressServiceImpl(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	@Override
	public void saveAddressDetails(List<AddressDetails> list) {
		addressRepository.saveAll(list);
	}

}
