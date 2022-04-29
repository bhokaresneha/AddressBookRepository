package com.bridgelabz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class AddressBookMain
{
    Contacts contacts = new Contacts();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails = new ArrayList();

     public void addContactDetail()
         {
                System.out.println("Enter First Name");
                contacts.setFirstName(scanner.nextLine());
                System.out.println("Enter Last Name");
                contacts.setLastName(scanner.nextLine());
                System.out.println("Enter contact Number:");
                contacts.setContactNo(scanner.nextLine());
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

                    contactDetails.add(contacts);
          }
            public void displayDetails()
            {
                System.out.println(contactDetails);
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
                addressbookmain.addContactDetail();
                addressbookmain.displayDetails();
                System.out.println("Enter First and last name to update details");
                String firstName = scanner.nextLine();
                System.out.println("last name to update details");
                String lastName = scanner.nextLine();
                addressbookmain.updateContactDetail(firstName,lastName);
                System.out.println("Record updated Sucessfully.............");
                addressbookmain.displayDetails();
                addressbookmain.deleteContact();
           }

}
