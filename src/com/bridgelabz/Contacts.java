package com.bridgelabz;

import java.util.List;

class Contacts {
    private String firstName, lastName, address, city, state, zipCode, contactNo, email;


    //Getter methods =The get method returns the variable value
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

    //Setter method =>The set method sets the value.
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setContactNo(String contactNo){
        this.contactNo=contactNo;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public String toString(){
        return ("FirstName IS " + firstName + " \n LastNAme Is " + lastName + " \n Email Is " + email +
                "\n Contact No Is " + contactNo + "\n Address Is " + address + " \n City Is " + city + "\n State Is " + state +
                "\n Zip Code Is " + zipCode);

    }

}