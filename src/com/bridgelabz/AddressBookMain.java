package com.bridgelabz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class AddressBookMain
{
    Contacts contacts = new Contacts();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails = new ArrayList();

     public void addContactDetail()
         {
                System.out.println("Enter First Name");
                contacts.setFirstName(scanner.next());
                System.out.println("Enter Last Name");
                contacts.setLastName(scanner.next());
                System.out.println("Enter contact Number:");
                contacts.setContactNo(scanner.next());
                System.out.println("Enter Email: ");
                contacts.setEmail(scanner.next());
                System.out.println("Enter Address: ");
                contacts.setAddress(scanner.next());
                System.out.println("Enter City Name: ");
                contacts.setCity(scanner.next());
                System.out.println("Enter State: ");
                contacts.setState(scanner.next());
                System.out.println("Enetr Zip Code:");
                contacts.setZipCode(scanner.next());
                    contactDetails.add(contacts);
             System.out.println("if you want to add multiple person to Address Book");
             System.out.println("If yes press 1");
             int n = scanner.nextInt();
             if (n==1){
                 addContactDetail();
             }
             else
                 System.out.println("");
          }
            public void displayDetails()
            {
                Iterator itr=contactDetails.iterator();
                while(itr.hasNext()){
                    System.out.println(itr.next());
                }
            }
            public void updateContactDetail(String firstName ,String lastName)
            {

                for (Contacts contact : contactDetails) {
                    System.out.println("First Name: "+contact.getFirstName()+"Last Name :"+contact.getLastName());
                    if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
                    {
                        System.out.println("Enter Choice to Update\t1. Update Email Address\t 2. Update Contact " +"\t3. Update Address"+"\t4.Update City "+"\t5. Update State"+"\t6. Upadate Zip Code");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter E-Mail Address:");
                                String email=scanner.next();
                                contact.setEmail(email);
                                break;
                            case 2:
                                System.out.println("Enter contact Number:");
                                String contactno=scanner.next();
                                contact.setContactNo(contactno);
                                break;
                            case 3:
                                System.out.println("Enter Address:");
                                String address=scanner.next();
                                contact.setAddress(address);
                                break;
                            case 4:
                                System.out.println("Enter City :");
                                String city=scanner.next();
                                contact.setCity(city);
                                break;
                            case 5:
                                System.out.println("Enter State:");
                                String state=scanner.next();
                                contact.setState(state);
                                break;
                            case 6:
                                System.out.println("Enter Zipcode:");
                                String zipcode=scanner.next();
                                contact.setZipCode(zipcode);
                                break;

                        }
                    }
                    else
                        System.out.println("No record found");
                }

            }
                public void deleteContact()
                {
                    // Traversing Using Iterator

                    //getting the Iterator
                    Iterator<Contacts> deleteRecord = contactDetails.iterator();
                    //Traversing list using hasNext() function till condition of while goes false
                    while (deleteRecord.hasNext()){
                        Contacts nextElement = deleteRecord.next();
                        //iterator inbuild  remove() function to delete single record
                        deleteRecord.remove();
                    }
                    System.out.println("Contact is removed!");
                    displayDetails();
                }
                public static void main(String[] args)
            {
                System.out.println("*_*_*_*_*_*_*_*_*_*_Welcome to Address Book_*_*_*_*_*_*_*_*_*_*");
                AddressBookMain addressbookmain = new AddressBookMain();
                while (true) {
                    System.out.println(" Enter 1 to add\t Enter 2 to Update\t Enter 3 to delete contact\tEnter 4 for Show Contact Details\t Enter 5 to Exit");
                    int ch = scanner.nextInt();
                    switch (ch) {
                        case 1:
                            addressbookmain.addContactDetail();
                            System.out.println("Added Successfully...");
                            break;
                        case 2:
                            System.out.println("Enter First Name  and Last name for which you want to modify info: ");
                            System.out.println("Enter First and last name to update details");
                            String firstName = scanner.nextLine();
                            System.out.println("last name to update details");
                            String lastName = scanner.nextLine();
                            addressbookmain.updateContactDetail(firstName,lastName);
                            break;
                        case 3:
                            addressbookmain.deleteContact();
                            break;

                        case 4 :
                            addressbookmain.displayDetails();
                            break;
                        case 5:
                            System.exit(0);
                    }
                }
           }
}
