package com.jycase.dreamflycustomer.dreamflycustomer.service.impl;

import com.jycase.dreamflycustomer.dreamflycustomer.dao.CustomerDao;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerQueryParams;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerRequest;
import com.jycase.dreamflycustomer.dreamflycustomer.model.Customer;
import com.jycase.dreamflycustomer.dreamflycustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> getCustomers(CustomerQueryParams customerQueryParams) {
        return customerDao.getCustomers(customerQueryParams);
    }

    @Override
    public Integer createCustomer(CustomerRequest customerRequest) {
        return customerDao.createCustomer(customerRequest);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerDao.getCustomerById(customerId);
    }
}
