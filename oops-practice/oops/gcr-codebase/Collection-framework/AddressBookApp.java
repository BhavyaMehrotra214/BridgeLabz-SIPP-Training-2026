import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

public class AddressBookApp {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, Contact> contactMap = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();

    public static void addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number not allowed.");
            return;
        }

        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        contactMap.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added.");
    }

    public static void searchContact(String name) {
        if (contactMap.containsKey(name))
            System.out.println(contactMap.get(name));
        else
            System.out.println("Contact Not Found");
    }

    public static void deleteContact(String name) {
        Contact c = contactMap.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }

    public static void displayContacts() {
        Collections.sort(contacts, (a, b) -> a.name.compareToIgnoreCase(b.name));

        System.out.println("\nContacts:");
        for (Contact c : contacts)
            System.out.println(c);
    }

    public static void main(String[] args) {
        addContact("Palak", "9267489999", "palak@gmail.com");
        addContact("Aman", "9999999999", "aman@gmail.com");

        searchContact("Palak");
        deleteContact("Aman");
        displayContacts();
    }
}