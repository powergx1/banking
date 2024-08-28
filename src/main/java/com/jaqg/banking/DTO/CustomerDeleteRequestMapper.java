package com.jaqg.banking.dto;

import com.jaqg.banking.entities.Customer;

public class CustomerDeleteRequestMapper {
    public static CustomerDeleteRequest toDelete(Customer customer) {
        return new CustomerDeleteRequest(customer.getUniqueID(),
                customer.getFullName(), customer.getAccounts());
    }
}