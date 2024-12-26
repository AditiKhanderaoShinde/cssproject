package com.sakshi.atm.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Customer {
    @Id
    @Column(length=10)
    private String customerId;
    @Column(length=20)
    private String customerName;
    @Column(length=10)
    private String contact;
    @Column(length=50)
    private String address;
    private Date dateOfBirth;
    @Column(length=12)
    private String adhaarNo;
    @Column(length=11)
    private String panNo;
    @Column(length=7)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "ifscCode")
    private Bank bank;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> account = new ArrayList<>();

    public Customer() {}

    public Customer(String customerId, String customerName, String contact, String address, Date dateOfBirth,
                    String adhaarNo, String panNo, String gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contact = contact;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.adhaarNo = adhaarNo;
        this.panNo = panNo;
        this.gender = gender;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> accounts) {
        this.account = accounts;
    }

    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
    public String toString() {
        return "Customer{" +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", adhaarNo='" + adhaarNo + '\'' +
                ", panNo='" + panNo + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
