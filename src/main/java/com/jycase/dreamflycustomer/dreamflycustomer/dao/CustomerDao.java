package com.jycase.dreamflycustomer.dreamflycustomer.dao;

import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerQueryParams;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerRequest;
import com.jycase.dreamflycustomer.dreamflycustomer.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers(CustomerQueryParams customerQueryParams);
    Integer createCustomer(CustomerRequest customerRequest);
    Customer getCustomerById(Integer customerId);

}
