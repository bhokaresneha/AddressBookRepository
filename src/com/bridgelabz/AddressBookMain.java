ppackage com.bridgelabz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBookMain
{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails = new ArrayList();

     public void addContactDetail()
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
          }
            public void displayDetails()
            {
                for (Contacts contactDetailsValue : contactDetails){
                    System.out.println(contactDetailsValue);
                    System.out.println("-----------------------------");

            }
            }
            public void updateContactDetail()
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
                public void deleteContact()
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
  
             public static void main(String[] args)
            {
                System.out.println("*_*_*_*_*_*_*_*_*_*_Welcome to Address Book_*_*_*_*_*_*_*_*_*_*");
                AddressBookMain addressbookmain = new AddressBookMain();
                while (true) {
                    System.out.println(" Enter your choice \n1.Add Detail\n2.Update Detail \n3.Delete Detail\n4.Display ALl Details\n5.Enter 5 to Exit");
                    int ch = scanner.nextInt();
                    switch (ch) {
                        case 1:
                            addressbookmain.addContactDetail();
                            System.out.println("Added Successfully...");
                            break;
                        case 2:
                            addressbookmain.updateContactDetail();
                            System.out.println("Record Updated Successfully...");

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
