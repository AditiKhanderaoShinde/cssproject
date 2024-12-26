package com.sakshi.atm.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @Column(length=11)
    private String ifscCode;
    @Column(length=11)
    private String branchCode;
    @Column(length=20)
    private String branchName;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Customer> customer = new ArrayList<>();

    public Bank() {}

    public Bank(String ifscCode, String branchCode, String branchName) {
        this.ifscCode = ifscCode;
        this.branchCode = branchCode;
        this.branchName = branchName;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customers) {
        this.customer = customers;
    }

	public void setCustomers(List<Customer> customers) {
		this.customer = customers;
	}

	@Override
    public String toString() {
        return "Bank{" +
                "ifscCode='" + ifscCode + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
