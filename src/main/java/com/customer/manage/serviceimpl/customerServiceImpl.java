package com.customer.manage.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.exception.CustomerNotFound;
import com.customer.manage.mapper.CustomerEntityMapper;
import com.customer.manage.mapper.CustomerModelMapper;
import com.customer.manage.model.CustomerModel;
import com.customer.manage.repository.CustomerRepository;
import com.customer.service.CustomerService;

@Service
public class customerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	/*
	 * @Autowired private ProductClient productClient;
	 */
	@Autowired
	private CustomerModelMapper customerModelMapper;

	@Autowired
	private CustomerEntityMapper customerEntityMapper;


	/*
	 * @Override public ProductModel getProducts(int productId) { return null;
	 */
	

	@Override
	public void createCustomer(CustomerModel customerModel) {
		customerRepository.save(customerEntityMapper.modelToCustomerEntity(customerModel));		
	}

	@Override
	public void updateCustomer(CustomerModel customerModel) {
		customerRepository.save(customerEntityMapper.modelToCustomerEntity(customerModel));
	}

	@Override
	public void deleteByCustomer(int customerId) {
		customerRepository.deleteById(customerId);		
	}

	@Override
	public CustomerModel findByCustomerId(int customerId) {
		CustomerModel customerModel;
		Optional<CustomerEntity> customerModelOptional = customerRepository.findById(customerId);

	if(customerModelOptional.isPresent()) {
		customerModel=customerModelMapper.entityToCustomerModel(customerModelOptional.get());
	}else {
		throw new CustomerNotFound("Customer not found for giver customerId--->" + customerId);
	}
	return customerModel;
	
	}
}

	