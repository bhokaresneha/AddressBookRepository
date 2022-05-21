package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;


public class AddressBookOperation implements AddressBookInterface {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails=new ArrayList<>();
    static char choice;
    // static AddressBookOperation contacts =new AddressBookOperation();
    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    static String AddressBookName;
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
             //*-*-*-*-*-*-*-*-*-*-*-Multiple Address Books Menu -*-*-*-*-*-*-*-*-*-*-*

    public  void AddressBook(AddressBookOperation addressBookOperation) {
        do {
            System.out.println("Enter your choice \n1.Add New Address Book \n2.Display Address Books Names\n3.Search based on City or State" +
                    "\n4.Count Persons belonging from Same City or State \n5.Sort Contact using Name \n6.Sort Contact using City, StateOr Zip-Code ");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addAddressBook(addressBookOperation);
                    break;
                case 2:
                    displayAddressBook();
                    break;
                case 3:
                   /* System.out.println("Enter city name or state name to search records");
                    String name = scanner.next();
                    searchInMultipleAddressBook(name);
                   */
                    searchInMultipleAddressBook();
                    break;
                case 4:
                    System.out.println("Enter city name or state name to Count Persons belonging from same city or state");
                    String countname = scanner.next();
                    countPersonFromSameCityOrState(countname);
                    break;
                case 5:
                    sortByName();
                case 6:
                    sortByCityStateOrZipCode();
                default:
                    System.out.println("\nInvalid Option Entered!!!!! Please Enter Valid Option to Add New Address Book");


            }
            System.out.println("\n To Perform More operations on Multiple Books press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');


    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //*-*-*-*-*-*-*-*-*-*-*-Adding Multiple Books-*-*-*-*-*-*-*-*-*-*-*

    public void addAddressBook(AddressBookOperation addressBookOperation)
    {
        do {
            System.out.println("Enter Name For Address Book");
            AddressBookName = scanner.next();
            if (hashmap.containsKey(AddressBookName)) {
                System.out.println("The AddressBook already contains");
                break;
            } else {
                ArrayList<Contacts> details = new ArrayList<>();
                addressBookOperation.displayActionMenu(details);
                hashmap.put(AddressBookName, details);
            }
            System.out.println("AddressBook Added" + hashmap + " ");
            System.out.println("To Add or Perform More Operations on Address Books  press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');
    }

 /////////////////////////////////////////////////////////////////////////////////////////////////////////////
          //*-*-*-*-*-*-*-*-*-*-*-Adding Details in Address Book-*-*-*-*-*-*-*-*-*-*-*

    // Adding Details in Address Book -to ensure there is no Duplicate Entry of the same Person in a particular Address Book - Duplicate Check is done
    public  ArrayList<Contacts> addContactDetail(ArrayList<Contacts> contactDetails) {
        Contacts contacts = new Contacts();
        if (contactDetails.size() == 0) {
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

        } else {
            System.out.println("Enter First Name");
            String firstname = scanner.next();
            for (Contacts contact : contactDetails) {
                //    System.out.println("First Name: "+contact.getFirstName());
                if (contact.getFirstName().equals(firstname)) {
                    System.out.print("Name already present");
                } else {
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Updating Details-*-*-*-*-*-*-*-*-*-*-*

    public void updateContactDetail(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter First Name for which you want to modify info: ");
        String firstName = scanner.next();

        /*  Iterate to search for first name */

        for (Contacts contact : contactDetails) {
            // System.out.println("First Name: " + contact.getFirstName());
            if (contact.getFirstName().equals(firstName)) {
                System.out.println("Enter your Choice to Update Detail\n1. Update First Name\t2.Update Last Name\t3.Update Email Address\t4. Update Contact \t5. Update Address" +
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
                        String email = scanner.next();
                        contact.setEmail(email);
                        break;
                    case 4:
                        System.out.println("Enter contact Number:");
                        String contactno = scanner.next();
                        contact.setContactNo(contactno);
                        break;
                    case 5:
                        System.out.println("Enter Address:");
                        String address = scanner.next();
                        contact.setAddress(address);
                        break;
                    case 6:
                        System.out.println("Enter City :");
                        String city = scanner.next();
                        contact.setCity(city);
                        break;
                    case 7:
                        System.out.println("Enter State:");
                        String state = scanner.next();
                        contact.setState(state);
                        break;
                    case 8:
                        System.out.println("Enter Zipcode:");
                        String zipcode = scanner.next();
                        contact.setZipCode(zipcode);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }
                System.out.println("Details updated");
            } else
                System.out.println("No record found");
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Deleting Details-*-*-*-*-*-*-*-*-*-*-*

    public  void deleteContact(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter First Name for which you want to delete contact: ");
        String firstname = scanner.next();

        Iterator<Contacts> removeContact = contactDetails.iterator();

        /*  Checking the next element where
         *   condition holds true till there is single element
         *   in the List using hasNext() method
         */

        while (removeContact.hasNext()) {

            /*  Move cursor to next element */

            Contacts nextElement = removeContact.next();
            if (nextElement.getFirstName().equals(firstname)) {
                removeContact.remove();
                System.out.println("Contact is removed!");
                break;
            } else {
                System.out.println("Contact not found.");
            }
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Displaying Details From Single Address Book-*-*-*-*-*-*-*-*-*-*-*
    public void displayDetails(ArrayList<Contacts> contactDetails){
        for (Contacts contact : contactDetails) {
            System.out.print(contact + " ");
        }
    }

    //Displaying All Address Books With records which present in it
    public void displayAddressBook()
    {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet())
            for (Contacts v:entry.getValue())
            {
                System.out.println("\n Address Book=>"+entry.getKey());
                System.out.println ("FirstName \t LastName \t Email \t Contact Number \t Address \t City \t State \t Zip Code ");
                System.out.println (v.getFirstName()+"\t"+v.getLastName()+"\t"+ v.getEmail()+"\t"+v.getContactNo()+"\t"+v.getAddress()+
                        "\t"+v.getCity()+"\t"+v.getState()+"\t"+v.getZipCode());
            }
    }


    /*public void searchInMultipleAddressBook(String name){
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()){
            for (Contacts v:entry.getValue()){
                if (v.getCity().equals(name)|| v.getState().equals(name)){
                    System.out.println("\n Record Found in=>");
                    System.out.println("\n Address Book=>"+entry.getKey()+"\t Person Details=>"+v.getFirstName()+"\t"+v.getLastName());
                }
            }}
        System.out.printf("No record found:");
    }
*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Searching in Multiple Address Book -*-*-*-*-*-*-*-*-*-*-*

    public void searchInMultipleAddressBook(){
        do {
            System.out.println("Enter your Choice \n1.Search By City \n2.Search by State \n3.Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter City Name to Search records");
                    String cityname = scanner.next();
                    for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
                        List<Contacts> sort = entry.getValue()
                                .stream()
                                .filter(searchCity -> searchCity.getCity().equals(cityname)).collect(Collectors.toList());
                        for (Contacts item : sort) {
                            System.out.println(item.toString() + " ");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter State Name to Search records");
                    String statename = scanner.next();
                    for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
                        List<Contacts> sort = entry.getValue()
                                .stream()
                                .filter(searchCity -> searchCity.getCity().equals(statename)).collect(Collectors.toList());
                        for (Contacts item : sort) {
                            System.out.println(item.toString() + " ");
                        }
                    }
                    break;
                case 3:
                    System.out.println("EXIT");
                    break;
            }
            System.out.println("\nTo Search More records in Address Books by City Or State  press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Searching in Single Address Book -*-*-*-*-*-*-*-*-*-*-*
    public void searchInSingleAddressBook(ArrayList<Contacts> contactDetails) {
        int flag = 0;
        ArrayList<Contacts> match = new ArrayList<>();
        System.out.println("Enter City Name or State Name to search a particular person");
        String data = scanner.next();
        for (Contacts contact : contactDetails) {
            //    System.out.println("First Name: "+contact.getFirstName());
            if (contact.getCity().equals(data) || contact.getState().equals(data)) {
                flag = 1;
                match.add(contact);
            }
        }
        if (flag == 1) {
            System.out.println("...Match Found...");
            for (Contacts p : match) {
                System.out.println("Person Name =>"+p.getFirstName()+"\tCity=>"+p.getCity()+"\tState =>"+p.getState());
            }
        } else {
            System.out.println("Match Not Found!!!");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Counting records based on city and state  -*-*-*-*-*-*-*-*-*-*-*

    public void countPersonFromSameCityOrState(String name) {
        int count = 0;
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            for (Contacts v : entry.getValue()) {
                if (v.getCity().equals(name) || v.getState().equals(name)) {
                    count++;
                }
            }
        }
        System.out.printf(count + "\tPersons belonging From =>" + name);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Sorting details by Name in Multiple Address Book -*-*-*-*-*-*-*-*-*-*-*
    public void sortByName(){
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()){
                List<Contacts> sort =entry.getValue()
                        .stream()
                        .sorted(Comparator.comparing(contactInfo -> contactInfo.getFirstName()))
                        .toList();
            for (Contacts item : sort) {
                System.out.println(item.toString() + " ");
            }
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Sorting details by State City Or Zip-Code in Multiple Address Book -*-*-*-*-*-*-*-*-*-*-*
    public void sortByCityStateOrZipCode(){
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()){
            List<Contacts> sort =entry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contactInfo -> contactInfo.getCity()+contactInfo.getState()+contactInfo.getZipCode()))
                    .toList();
            for (Contacts item : sort) {
                System.out.println(item.toString()+"");
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Single Address Books Menu -*-*-*-*-*-*-*-*-*-*-*
    public  ArrayList<Contacts> displayActionMenu(ArrayList<Contacts> details) {
        do {
            System.out.println(" Enter your choice \n1.Add Detail\n2.Update Detail \n3.Delete Detail\n4.Display ALl Details\n5.Search Records based on city or state" +
                    "\n6.Exit");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addContactDetail(details);
                    break;
                case 2:
                    updateContactDetail(details);
                    break;
                case 3:
                    deleteContact(details);
                    break;
                case 4:
                    displayDetails(details);
                    break;
                case 5:
                    searchInSingleAddressBook(details);
                    break;
                case 6:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Invalid Choice !! Please Enter Valid Choice ");
            }
            System.out.println("\n To perform more operations on Particular Address Book press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');
        return null;
    }

}