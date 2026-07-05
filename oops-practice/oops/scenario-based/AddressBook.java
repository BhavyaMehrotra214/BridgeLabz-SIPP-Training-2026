import java.util.*;
class Contact implements Comparable<Contact> {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public int compareTo(Contact c) {
        return this.name.compareToIgnoreCase(c.name);
    }

    @Override
    public String toString() {
        return "Name : " + name +
                "\nPhone: " + phone +
                "\nEmail: " + email;
    }
}

public class AddressBook {
    static ArrayList<Contact> contactList = new ArrayList<>();
    static HashMap<String, Contact> contactMap = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();
    static void addContact(String name, String phone, String email) {

        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number! Contact not added.");
            return;
        }

        Contact c = new Contact(name, phone, email);

        contactList.add(c);
        contactMap.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added Successfully.");
    }
    static void searchContact(String name) {

        Contact c = contactMap.get(name);

        if (c != null)
            System.out.println(c);
        else
            System.out.println("Contact not found.");
    }
    static void deleteContact(String name) {

        Contact c = contactMap.remove(name);

        if (c != null) {
            contactList.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact Deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    static void displayContacts() {

        Collections.sort(contactList);

        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty.");
            return;
        }

        System.out.println("Contact List");

        for (Contact c : contactList) {
            System.out.println(c);
            System.out.println("------");
        }
    }

    public static void main(String[] args) {

        addContact("Bhavya", "9876543210", "bhavya@gmail.com");
        addContact("Aman", "9876500000", "aman@gmail.com");
        addContact("Riya", "9999999999", "riya@gmail.com");

        // Duplicate Phone
        addContact("Rahul", "9876543210", "rahul@gmail.com");

        System.out.println("\nSearch Contact:");
        searchContact("Aman");

        System.out.println("\nDelete Contact:");
        deleteContact("Riya");

        System.out.println("\nSorted Contact List:");
        displayContacts();
    }
}