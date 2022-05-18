package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;


public class AddressBookOperation extends AddressBookMain{

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails = new ArrayList();
    static char choice;
    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();

    // Creating Multiple Address Books
    public static void AddressBook(AddressBookOperation addressBookOperation) {

        do {
            System.out.println("Enter Name For Address Book");
            String AddressBookName = scanner.next();

            if (hashmap.containsKey(AddressBookName)) {
                System.out.println("The AddressBook already contains");
                break;
            }else {
                 ArrayList<Contacts> details = new ArrayList<>();
                addressBookOperation.displayActionMenu(addressBookOperation, details);
                hashmap.put(AddressBookName, details);
            }
            System.out.println("AddressBook Added" + hashmap + " ");
            System.out.println("To Add More Address Books  press Y otherwise press N");
            choice = scanner.next().charAt(0);
        }while (choice != 'n' && choice != 'N');

    }

    // Adding Details in Address Book -to ensure there is no Duplicate Entry of the same Person in a particular Address Book - Duplicate Check is done
    public static ArrayList<Contacts> addContactDetail(ArrayList<Contacts> contactDetails)
    {
        Contacts contacts = new Contacts();
        if(contactDetails.size()==0) {
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
            System.out.println("Contact details added!");
            return contactDetails;

        }
        else {

            System.out.println("Enter First Name");
            String firstname=scanner.next();
            for (Contacts contact : contactDetails) {
            //    System.out.println("First Name: "+contact.getFirstName());
                if (contact.getFirstName().equals(firstname) )
                {
                    System.out.print("Name already present");
                }
                else {
                    contacts.setFirstName(firstname);
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
                    System.out.println("Contact details added!");
                    return contactDetails;

                }
          }
      }
        return contactDetails;
    }

    // Displaying Details From ContactDetails Arraylist
    public void displayDetails(ArrayList<Contacts> contactDetails)
    {   for (Contacts contact : contactDetails) {

        System.out.print(contact + " ");}
    }

    // Function for updating Contact Details
    public void updateContactDetail(ArrayList<Contacts> contactDetails)
    {
        System.out.println("Enter First Name for which you want to modify info: ");
        String firstName = scanner.next();

        /*  Iterate to search for first name */

        for (Contacts contact : contactDetails) {
            System.out.println("First Name: "+contact.getFirstName());
            if (contact.getFirstName().equals(firstName) )
            {
                System.out.println("Enter your Choice to Update Detail\n1. Update First Name\t2.Update Last Name\t3.Update Email Address\t4. Update Contact \t5. Update Address"+
                        "\t6.Update City \t7. Update State \t8. Upadate Zip Code");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        String UpdatedFirstName = scanner.next();
                        contact.setFirstName(UpdatedFirstName);
                        break;
                    case 2:
                        String lastName = scanner.next();
                        contact.setLastName(lastName);
                        break;

                    case 3:
                        System.out.println("Enter E-Mail Address:");
                        String email=scanner.next();
                        contact.setEmail(email);
                        break;
                    case 4:
                        System.out.println("Enter contact Number:");
                        String contactno=scanner.next();
                        contact.setContactNo(contactno);
                        break;
                    case 5:
                        System.out.println("Enter Address:");
                        String address=scanner.next();
                        contact.setAddress(address);
                        break;
                    case 6:
                        System.out.println("Enter City :");
                        String city=scanner.next();
                        contact.setCity(city);
                        break;
                    case 7:
                        System.out.println("Enter State:");
                        String state=scanner.next();
                        contact.setState(state);
                        break;
                    case 8:
                        System.out.println("Enter Zipcode:");
                        String zipcode=scanner.next();
                        contact.setZipCode(zipcode);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }
                System.out.println("Details updated");
            }
            else
                System.out.println("No record found");
        }

    }

    // function for deleting Contact details
    public void deleteContact(ArrayList<Contacts> contactDetails)
    {
        System.out.println("Enter First Name for which you want to delete contact: ");
        String firstname = scanner.next();

        Iterator<Contacts> removeContact = contactDetails.iterator();

        /*  Checking the next element where
         *   condition holds true till there is single element
         *   in the List using hasNext() method
         */

        while (removeContact.hasNext()){

        /*  Move cursor to next element */

            Contacts nextElement = removeContact.next();
            if (nextElement.getFirstName().equals(firstname) ) {
                removeContact.remove();
                System.out.println("Contact is removed!");
                break;
            }
            else {
                System.out.println("Contact not found.");
            }
        }
    }

    //Function for operations which you want to perform on Address Book
    public  void displayActionMenu(AddressBookOperation addressBookOperation,ArrayList<Contacts> details ) {
        do {
            System.out.println(" Enter your choice \n1.Add Detail\n2.Update Detail \n3.Delete Detail\n4.Display ALl Details");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addressBookOperation.addContactDetail(details);
                    System.out.println("Added Successfully...");
                    break;
                case 2:
                    addressBookOperation.updateContactDetail(details);
                    System.out.println("Record Updated Successfully...");

                    break;
                case 3:
                    addressBookOperation.deleteContact(details);
                    break;

                case 4:
                    addressBookOperation.displayDetails(details);
                    break;


            }
            System.out.println("To perform more operations on Address Book press Y otherwise press N");
            choice = scanner.next().charAt(0);
        }while (choice != 'n' && choice != 'N');
    }
}
