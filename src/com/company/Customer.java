package com.company;

public class Customer {
    private String name;
    private String email;
    private String address;
    private String mobile;

    public Customer(String name, String email, String address, String mobile) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
    }

    public String getDetails() {
        return "Name: " + name + ", Email: " + email + ", Address: " + address+ ", Mobile: " + mobile;
    }
}
