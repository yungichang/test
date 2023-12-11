package com.jycase.dreamflycustomer.dreamflycustomer.controller;

import com.jycase.dreamflycustomer.dreamflycustomer.constant.CustomerCategory;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerQueryParams;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerRequest;
import com.jycase.dreamflycustomer.dreamflycustomer.model.Customer;
import com.jycase.dreamflycustomer.dreamflycustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated // MAX 跟 MIN的註解才會啟用
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            //查詢條件filtering
            @RequestParam(required = false) CustomerCategory category,
            @RequestParam(required = false) String search,
            //排序 sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort

    ){
        CustomerQueryParams customerQueryParams = new CustomerQueryParams();
        customerQueryParams.setSearch(search);
        customerQueryParams.setCategory(category);
        customerQueryParams.setOrderBy(orderBy);
        customerQueryParams.setSort(sort);

        List<Customer> customerList = customerService.getCustomers(customerQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(customerList);
    }


    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        System.out.println("YAAAAAAAAAAA");
        Integer customerId =customerService.createCustomer(customerRequest);
        Customer customer = customerService.getCustomerById(customerId);
        return  ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

}
