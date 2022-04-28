package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain
{

   static ArrayList<Contacts> contactDetails = new ArrayList();

    public void addContactDetail() {
          Contacts contacts = new Contacts();
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter First Name");
            contacts.setFirstName(scanner.nextLine());
            System.out.println("Enter Last Name");
            contacts.setLastName(scanner.nextLine());
            System.out.println("Enter Email: ");
            contacts.setEmail(scanner.nextLine());
            System.out.println("Enter Address: ");
            contacts.setAddress(scanner.nextLine());
            System.out.println("Enter City Name: ");
            contacts.setCity(scanner.nextLine());
            System.out.println("Enter State: ");
            contacts.setState(scanner.nextLine());
            System.out.println("Enetr Zip Code:");
            contacts.setZipCode(scanner.nextLine());
            System.out.println("Enter contact Number:");
             contacts.setContactNo(scanner.nextLine());

             contactDetails.add(contacts);
          }
    public void DisplayDetails(){
        System.out.println(contactDetails);
    }
            public static void main(String[] args)
            {
                System.out.println("Welcome to Address Book Program!");
                AddressBookMain addressbookmain = new AddressBookMain();
                addressbookmain.addContactDetail();
                addressbookmain.DisplayDetails();


            }

       /* System.out.println("Welcome to Address Book System");
            //Creating object of contact class to call getter setter method
        Contacts contacts = new Contacts("Sneha", "Bhokare", "Matruchaya Apartment", "Pune", "Maharashtra","411014", "70570519131","bhokaresneha20@gmail.com");
        System.out.print(contacts.getFirstName()+" ");
        System.out.println(contacts.getLastName());
        System.out.println(contacts.getEmail());
        System.out.print(contacts.getAddress()+" ");
        System.out.println(contacts.getCity());
        System.out.print(contacts.getState());
        System.out.println(contacts.getZipCode());
        System.out.println(contacts.getContactNo());

*/
    }
