package com.jycase.dreamflycustomer.dreamflycustomer.dto;

import com.jycase.dreamflycustomer.dreamflycustomer.constant.CustomerCategory;

public class CustomerQueryParams {
    private CustomerCategory category;
    private String search;
    private String orderBy;
    private String sort;
    public CustomerCategory getCategory() {
        return category;
    }

    public void setCategory(CustomerCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
