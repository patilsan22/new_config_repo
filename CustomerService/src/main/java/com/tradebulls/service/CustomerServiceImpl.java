package com.tradebulls.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.tradebulls.entity.AddressDetails;
import com.tradebulls.entity.BankDetails;
import com.tradebulls.entity.CustomerDetails;
import com.tradebulls.entity.Employee;
import com.tradebulls.repo.AddressRepository;
import com.tradebulls.repo.BankRepository;
import com.tradebulls.repo.CustomerRepository;
import com.tradebulls.repo.EmployeeRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private final String hashReference = "CustomersInfo";
	
	@Resource(name="masterRedisTemplate")
	private HashOperations<String, String, Map> hashOperations;
	
	public CustomerServiceImpl(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	public CustomerServiceImpl(BankRepository bankRepository) {
		super();
		this.bankRepository = bankRepository;
	}

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public void addCustomer(CustomerDetails customerDetails) {
		customerRepository.save(customerDetails);
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		
		List<CustomerDetails> custList = new ArrayList<CustomerDetails>();
		Iterable<CustomerDetails> custItr = customerRepository.findAll();
		custItr.forEach(x -> custList.add(x));
//		custItr.forEach(x-> System.out.println(x));
		return custList;
	}

	@Override
	public void saveCustomerDetails(List<CustomerDetails> list) {
		customerRepository.saveAll(list);
//		List<Customer> custList = new ArrayList<>();
//		custList.forEach(x -> hashOperations.putIfAbsent(hashReference, x, x));
//		
	}

	@Override
	public CustomerDetails getCustomerByID(String id) {
		CustomerDetails customerDetails = customerRepository.findById(id).orElse(null);
		return customerDetails;
	}

	@Override
	public String deleteCustomerById(String id) {
		Optional<CustomerDetails> customerDetails = customerRepository.findById(id);
		if (customerDetails.isPresent()) {
			customerRepository.deleteById(id);
			hashOperations.delete("Customer", id);
			return "Record deleted successfully";
		} else {
			return "No such record with id " + id + " found";
		}
	}

	@Override
	public void updateCustomerById(String id, CustomerDetails customerDetails) {
		CustomerDetails updateCustomer = customerRepository.findById(id).orElse(null);
		updateCustomer.setCust_name(customerDetails.getCust_name());
		updateCustomer.setCust_city(customerDetails.getCust_city());
		updateCustomer.setCust_status(customerDetails.getCust_status());
		customerRepository.save(updateCustomer);
	}

	@Override
	public List<Map<String, Object>> getCustomerDetailsByID(String id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		CustomerDetails customerDetails = customerRepository.findById(id).orElse(null);
		System.out.println("getCustomerDetailsByID >>>>>>>>>> "+customerDetails.getBank_Id());
		Optional<BankDetails> bankDetails = bankRepository.findById(customerDetails.getBank_Id());
		map.put("Customer", customerDetails);
		map.put("BankDetails", bankDetails);
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map);
		
		return list;
	}

	public Map<String, Object> getAddressandBankDetails(String cust_id) {
		Map<String, Object> innermap = new HashMap<>();
		Map<String, Object> outermap = new HashMap<>();
		CustomerDetails customerDetails = customerRepository.findById(cust_id).orElse(null);
		BankDetails bankDetails = bankRepository.findById(customerDetails.getBank_Id()).orElse(null);
		AddressDetails addressDetails =  addressRepository.findById(cust_id).orElse(null);
		innermap.put("CustomerDetails", customerDetails);
		innermap.put("AddressDetails", addressDetails);
		innermap.put("BankDetails", bankDetails);
		outermap.put(customerDetails.getCust_name(), innermap);
		return outermap;
	}
	
	@Override
	public void saveAllCustomerFullDetails() {
		Map<String, Object> outerMap = new HashMap<>();
		List<CustomerDetails> list = new ArrayList<>();
		list = getAllCustomers();
		for (CustomerDetails customerDetails : list) {
			String cust_id = customerDetails.getCust_ID();
			hashOperations.put(hashReference, cust_id, (outerMap = getAddressandBankDetails(cust_id)));
		}
	}
	

}

