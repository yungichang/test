package com.jycase.dreamflycustomer.dreamflycustomer.rowmapper;

import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerRequest;
import com.jycase.dreamflycustomer.dreamflycustomer.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setCustomerName(rs.getString("customer_name"));
        customer.setBirthday(rs.getTimestamp("birthday").toLocalDateTime().toLocalDate());
        customer.setPhone(rs.getString("phone"));
        customer.setCivilId(rs.getString("civil_id"));
        customer.setCareer(rs.getString("career"));
        customer.setCarModel(rs.getString("car_model"));
        customer.setCarNumber(rs.getString("car_number"));
        customer.setPurchaseDate(rs.getTimestamp("purchase_date").toLocalDateTime().toLocalDate());
        customer.setCompulsoryInsuraceDate(rs.getTimestamp("compulsory_insurace_date").toLocalDateTime().toLocalDate());
        customer.setInsuraceDate(rs.getTimestamp("insurace_date").toLocalDateTime().toLocalDate());
        customer.setInsuranceService(rs.getBoolean("insurance_service"));
        customer.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime().toLocalDate());
        customer.setLastModifiedDate(rs.getTimestamp("last_modified_date").toLocalDateTime().toLocalDate());
        return customer;

    }
}
