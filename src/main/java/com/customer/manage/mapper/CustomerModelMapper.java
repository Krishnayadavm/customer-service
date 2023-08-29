package com.customer.manage.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.customer.manage.entity.AddressEntity;
import com.customer.manage.entity.ContactEntity;
import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.model.AddressModel;
import com.customer.manage.model.ContactModel;
import com.customer.manage.model.CustomerModel;

@Component
public class CustomerModelMapper {

	public CustomerModel entityToCustomerModel(CustomerEntity customerEntity) {
		customerEntity.setCustomerId(getId(customerEntity.getCustomerId()));
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerEntity, customerModel);
		customerModel.setContactModels(entityToContactModels(customerEntity.getContactList()));
		customerModel.setAddressModel(entityToAddressModel(customerEntity.getAddressEntity()));
		return customerModel;
	}

	public AddressModel entityToAddressModel(AddressEntity addressEntity) {
		addressEntity.setAddressId(getId(addressEntity.getAddressId()));
		AddressModel addressModel = new AddressModel();
		BeanUtils.copyProperties(addressEntity, addressModel);
		return addressModel;
	}

	public ContactModel entityToContactModel(ContactEntity contactEntity) {
		ContactModel contactModel = new ContactModel();
		BeanUtils.copyProperties(contactEntity, contactModel);
		return contactModel;
	}

	public List<ContactModel> entityToContactModels(List<ContactEntity> contactEntities) {
		return contactEntities.stream().map(contactEntity -> entityToContactModel(contactEntity))
				.collect(Collectors.toList());
	}

	public int getId(int id) {
		if (id <= 0) {
			id = UUID.randomUUID().hashCode();
		} else {
			System.out.println("id is not found--->>>" + id);
		}
		return id;
	}
}
