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
         public void DisplayDetails()
         {
        System.out.println(contactDetails);
        }
            public static void main(String[] args)
            {
                System.out.println("Welcome to Address Book Program!");
                AddressBookMain addressbookmain = new AddressBookMain();
                addressbookmain.addContactDetail();
                addressbookmain.DisplayDetails();
            }
}
