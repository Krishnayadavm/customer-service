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
public class CustomerEntityMapper {

	public CustomerEntity modelToCustomerEntity(CustomerModel customerModel) {
		customerModel.setCustomerId(getId(customerModel.getCustomerId()));
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customerModel, customerEntity);
		customerEntity.setContactList(modelToContactEntities(customerModel.getContactModels(),customerEntity));
		customerEntity.setAddressEntity(modelToAddressEntity(customerModel.getAddressModel()));
		return customerEntity;
	}

	public AddressEntity modelToAddressEntity(AddressModel addressModel) {
		addressModel.setAddressId(getId(addressModel.getAddressId()));
		AddressEntity addressEntity = new AddressEntity();
		BeanUtils.copyProperties(addressModel, addressEntity);
		return addressEntity;
	}

	public ContactEntity modelToContactEntity(ContactModel contactModel,CustomerEntity customerEntity) {
		contactModel.setContactId(getId(contactModel.getContactId()));
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contactModel, contactEntity);
		contactEntity.setCustomerEntity(customerEntity);
		return contactEntity;
	}

	public List<ContactEntity> modelToContactEntities(List<ContactModel> contactModels ,CustomerEntity customerEntity) {
		return contactModels.stream().map(contactModel -> modelToContactEntity(contactModel,customerEntity))
				.collect(Collectors.toList());
	}

	public int getId(int id) {
		if (id <= 0) {
			id = UUID.randomUUID().hashCode();
			System.out.println("Id from UUID--->" + id);
		}
		return id;
	}

}