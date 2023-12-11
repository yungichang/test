package com.jycase.dreamflycustomer.dreamflycustomer.dao.impl;

import com.jycase.dreamflycustomer.dreamflycustomer.dao.CustomerDao;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerQueryParams;
import com.jycase.dreamflycustomer.dreamflycustomer.dto.CustomerRequest;
import com.jycase.dreamflycustomer.dreamflycustomer.model.Customer;
import com.jycase.dreamflycustomer.dreamflycustomer.rowmapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Customer> getCustomers(CustomerQueryParams customerQueryParams) {
        return null;
    }

    @Override
    public Integer createCustomer(CustomerRequest customerRequest) {
        String sql= "INSERT INTO customer_info(customer_name, birthday, phone, civil_id, career, car_model, " +
                "car_number,purchase_date,compulsory_insurace_date,insurace_date,insurance_service,created_date, last_modified_date) VALUES (:customerName , :birthday ,:phone " +
                " ,:civilId ,:career ,:carModel ,:carNumber ,:purchaseDate , :compulsoryInsuraceDate, :insuraceDate, :insuranceService" +
                " , :createdDate , :lastModifiedDate)" ;
        Map<String,Object> map = new HashMap<>();
        map.put("customerName",customerRequest.getCustomerName());
        map.put("birthday",customerRequest.getBirthday());
        map.put("phone",customerRequest.getPhone());
        map.put("civilId",customerRequest.getCivilId());
        map.put("career",customerRequest.getCareer());
        map.put("carModel",customerRequest.getCarModel());
        map.put("carNumber",customerRequest.getCarNumber());

        map.put("purchaseDate",customerRequest.getPurchaseDate());
        map.put("compulsoryInsuraceDate",customerRequest.getCompulsoryInsuraceDate());
        map.put("insuraceDate",customerRequest.getInsuraceDate());
        map.put("insuranceService",customerRequest.getInsuranceService());

        LocalDateTime now = LocalDateTime.now();
        map.put("createdDate",now);
        map.put("lastModifiedDate",now);
        System.out.println("sql "+sql);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("keyHolder "+keyHolder.toString());
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        // 獲取生成的鍵
        List<Map<String, Object>> keys = keyHolder.getKeyList();
        if (keys != null && !keys.isEmpty()) {
            Map<String, Object> keyMap = keys.get(0);
            if (keyMap.containsKey("customer_id")) {
                return (Integer) keyMap.get("customer_id");
            }
        }
        return null;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        String sql= "SELECT customer_id,customer_name, birthday, phone, civil_id, career, car_model, " +
                "car_number,purchase_date,compulsory_insurace_date,insurace_date,insurance_service,created_date, last_modified_date " +
                "FROM customer_info WHERE customer_id = :customerId";
        Map<String,Object> map = new HashMap<>();
        map.put("customerId",customerId);
        List<Customer> customerList = namedParameterJdbcTemplate.query(sql, map, new CustomerRowMapper());

        if(customerList.size()>0){
            return customerList.get(0);
        }else{
            return null;
        }
    }
}
