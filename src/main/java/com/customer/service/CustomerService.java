package com.customer.service;

import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.model.CustomerModel;

public interface CustomerService {
	public void createCustomer(CustomerModel customerModel);

	public void updateCustomer(CustomerModel customerModel);

	public void deleteByCustomer(int customerId);

	public CustomerModel findByCustomerId(int customerId);



}
