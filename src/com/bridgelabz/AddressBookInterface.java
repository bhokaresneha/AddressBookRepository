package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookInterface {

    void AddressBook(AddressBookOperation addressBookOperation);
    void addAddressBook(AddressBookOperation addressBookOperation);
    ArrayList<Contacts> addContactDetail(ArrayList<Contacts> contactDetails);
    void updateContactDetail(ArrayList<Contacts> contactDetails) ;
    void deleteContact(ArrayList<Contacts> contactDetails) ;
    void displayDetails(ArrayList<Contacts> contactDetails);
     void displayAddressBook();
    //void searchInMultipleAddressBook(String name);
    void searchInMultipleAddressBook();
    void searchInSingleAddressBook(ArrayList<Contacts> contactDetails);
    void countPersonFromSameCityOrState(String name);
    void sortByName();
    void sortByCityStateOrZipCode();
    ArrayList<Contacts> displayActionMenu(ArrayList<Contacts> details) ;

}
