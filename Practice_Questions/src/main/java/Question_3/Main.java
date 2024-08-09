package Question_3;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ContactCache cache = new ContactCache();

        cache.loadData();

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option to search : ");
        System.out.println(" 1. Search By Name");
        System.out.println(" 2. Search By Phone number ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter name you want to search : ");
                String name = sc.nextLine();
                List<Contact> contactByName = (List<Contact>) cache.searchByName(name);
                if (!contactByName.isEmpty()) {
                    System.out.println("Contact found : " );
                    for (Contact contact : contactByName) {
                        System.out.println(contact);
                    }
                }
                else {
                    System.out.println("No contact found with the name : " + name);
                }
                break;

            case 2:
                System.out.println("Enter the phone number you want to search : ");
                String phone_number = sc.nextLine();
                List<Contact> contactByPhone = (List<Contact>) cache.searchByPhoneNumber(phone_number);
                if (!contactByPhone.isEmpty()) {
                    System.out.println("Contact found : " );
                    for (Contact contact : contactByPhone) {
                        System.out.println(contact);
                    }
                }
                else {
                    System.out.println("No phone number found with the number as : " + phone_number );
                }
                break;

            default:
                System.out.println("Invalid Option ");
                break;
        }
        sc.close();
    }
}

class Contact {
    private String name;
    private String phone_number;

    public Contact(String name, String phone_number) {
        this.name = name;
        this.phone_number= phone_number;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public String toString() {
        return "Contact{name= '" + name + " ', phoneNumber= ' " + phone_number + "'}";
    }
}

class ContactCache {
    private Map<String, List<Contact>> cache;

    public ContactCache() {
        cache = new HashMap<>();
    }

    public void addContact(Contact contact) {
        cache.computeIfAbsent(contact.getName(), k -> new ArrayList<>()).add(contact);
        cache.computeIfAbsent(contact.getPhone_number(), k -> new ArrayList<>()).add(contact);
    }

    public Contact searchByName(String name) {
        return (Contact) cache.getOrDefault(name, new ArrayList<>());
    }

    public Contact searchByPhoneNumber(String phoneNumber) {
        return (Contact) cache.getOrDefault(phoneNumber, new ArrayList<>());
    }

    public void loadData() throws Exception{
        String jdbc_url = "jdbc:mysql://localhost:3306/dummy";
        String user = "root";
        String password = "root";

        String sql_query = "SELECT name, phone_number FROM contact";

        try(
                Connection con = DriverManager.getConnection(jdbc_url, user, password);
                PreparedStatement pst = con.prepareStatement(sql_query);
                ResultSet rs = pst.executeQuery()
        ) {
            while (rs.next()) {
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");
                Contact contact = new Contact(name, phoneNumber);
                addContact(contact);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}