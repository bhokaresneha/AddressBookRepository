package com.bridgelabz;

import java.util.*;
public class AddressBookMain  {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails = new ArrayList();
    static char choice;
    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    public static void AddressBook(AddressBookMain addressBookSystem) {

        do {
            System.out.println("Enter Name For Address Book");
            String AddressBookName = scanner.next();

            if (hashmap.containsKey(AddressBookName)) {
                System.out.println("The AddressBook already contains");
                break;
            }else {
                ArrayList<Contacts> contactDetails = new ArrayList<>();
                addressBookSystem.displayActionMenu(addressBookSystem, contactDetails);
                hashmap.put(AddressBookName, contactDetails);
            }
            System.out.println("AddressBook Added" + hashmap + " ");
            System.out.println("To Add More Address Books  press Y otherwise press N");
            choice = scanner.next().charAt(0);
        }while (choice != 'n' && choice != 'N');
    }

    public static ArrayList<Contacts> addContactDetail(ArrayList<Contacts> contactDetails)
    {
        Contacts contacts = new Contacts();
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
    public void displayDetails()
    {
        for (Contacts contactDetailsValue : contactDetails) {
            System.out.println(contactDetailsValue);
            System.out.println("-----------------------------");
        }

    }
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
    public  void displayActionMenu(AddressBookMain addressBooksystem,ArrayList<Contacts> contactDetails ) {
        int ans;
        do {
            System.out.println(" Enter your choice \n1.Add Detail\n2.Update Detail \n3.Delete Detail\n4.Display ALl Details");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addressBooksystem.addContactDetail(contactDetails);
                    System.out.println("Added Successfully...");
                    break;
                case 2:
                    addressBooksystem.updateContactDetail(contactDetails);
                    System.out.println("Record Updated Successfully...");

                    break;
                case 3:
                    addressBooksystem.deleteContact(contactDetails);
                    break;

                case 4:
                    addressBooksystem.displayDetails();
                    break;

            }
            System.out.println("To add more Records press Y otherwise press N");
            choice = scanner.next().charAt(0);
        }while (choice != 'n' && choice != 'N');
    }

    public static void main(String[] args) {

//        System.out.println("Welcome to Address Book Program!");

        AddressBookMain addressbookmain = new AddressBookMain();
        System.out.println("*_*_*_*_*_*_*_*_*_*_Welcome to Address Book_*_*_*_*_*_*_*_*_*_*");
        addressbookmain.AddressBook(addressbookmain);

    }

}
