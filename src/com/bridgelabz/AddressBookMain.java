package com.bridgelabz;
public class AddressBookMain{
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        Contacts contacts = new Contacts("Sneha", "Bhokare", "Matruchaya Apartment", "Pune", "Maharashtra","411014", "70570519131","bhokaresneha20@gmail.com");
        System.out.print(contacts.getFirstName()+" ");
        System.out.println(contacts.getLastName());
        System.out.println(contacts.getEmail());
        System.out.print(contacts.getAddress()+" ");
        System.out.println(contacts.getCity());
        System.out.print(contacts.getState()+" ");
        System.out.println(contacts.getZipCode());
        System.out.println(contacts.getContactNo());


    }
}