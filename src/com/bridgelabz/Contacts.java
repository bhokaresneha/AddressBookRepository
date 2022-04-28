package com.bridgelabz;

class Contacts {
    private String firstName, lastName, address, city, state, zipCode, contactNo, email;
    public Contacts(String firstName, String lastName, String addr, String cityName, String stateName, String zipCodeNo, String contact, String emailAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = addr;
        this.city = cityName;
        this.state = stateName;
        this.zipCode = zipCodeNo;
        this.contactNo = contact;
        this.email = emailAddress;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getContactNo(){
        return contactNo;
    }
    public String getZipCode(){
        return zipCode;
    }

}