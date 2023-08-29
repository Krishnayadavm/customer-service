
package com.customer.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.model.CustomerModel;
import com.customer.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public void createCustomer(@Valid @RequestBody CustomerModel customerModel) {
		customerService.createCustomer(customerModel);
	}

	@PutMapping("/update")
	public void updateCustomer(@Valid @RequestBody CustomerModel customerModel) {
		customerService.updateCustomer(customerModel);
	}

	@DeleteMapping("/delete/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteByCustomer(customerId);
	}

	@GetMapping("/findByCustomerId/{customerId}")
	public CustomerModel findByCustomerId(@PathVariable int customerId) {
		return customerService.findByCustomerId(customerId);
	}

}
