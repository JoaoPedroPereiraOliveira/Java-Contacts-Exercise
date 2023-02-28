package contacts;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Actions {
    Scanner scanner;
    PhoneBook phoneBook;

    public Actions(Scanner scanner, PhoneBook phoneBook) {
        this.scanner = scanner;
        this.phoneBook = phoneBook;
    }

    protected void Add() {
        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine().toLowerCase();
        switch (type) {
            case "person":
                addPerson();
                break;
            case "organization":
                addOrganization();
                break;
            default:
                System.out.println("Incorrect type.");
                return;
        }
        System.out.println("The record added.");
    }

    public void addPerson() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter the birth date: ");
        LocalDate birthDate = ValidInput.setBirthDate(scanner.nextLine());

        System.out.print("Enter the gender (M, F): ");
        String gender = ValidInput.setGender(scanner.nextLine());

        System.out.print("Enter the number: ");
        String number = ValidInput.setPhoneNumber(scanner.nextLine());

        phoneBook.addContact(new Person(name, surname, birthDate, gender, number));
    }

    public void addOrganization() {
        System.out.print("Enter the organization name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the number: ");
        String number = ValidInput.setPhoneNumber(scanner.nextLine());

        phoneBook.addContact(new Organization(name, address, number));
    }

    protected List<Integer> List() {
        return phoneBook.getList();
    }

    protected List<Integer> Search() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();

        List<Integer> queryList = phoneBook.queryList(query);

        System.out.println("Found " + queryList.size() + " results:");
        int index = 0;
        for (int contactIndex : queryList) {
            index++;
            System.out.print(index + ". ");
            phoneBook.getName(queryList.get(index - 1));
        }

        return queryList;
    }

    protected void Get(int record) {
        phoneBook.getInfo(record);
    }

    public void delete() {
        if (phoneBook.getSize() == 0) {
            System.out.println("No records to remove!");
            return;
        }

        phoneBook.getList();

        System.out.print("Select a record: ");
        int record = -1;
        while (record == -1) {
            record = ValidInput.isValidContact(scanner.nextLine(), phoneBook.getSize());
        }
        phoneBook.removeContact(record);
    }

    public void edit() {
        if (phoneBook.getSize() == 0) {
            System.out.println("No records to edit!");
            return;
        }

        List<Integer> listToEdit = phoneBook.getList();
        int record = -1;

        if (listToEdit.size() > 1) {
            System.out.print("Select a record: ");
            while (record == -1) {
                record = ValidInput.isValidContact(scanner.nextLine(), phoneBook.getSize());
            }
        } else if (listToEdit.size() == 0) {
            return;
        } else {
            record = 0;
        }

        switch (phoneBook.getContactType(record)) {
            case "Person":
                editPerson((Person) phoneBook.getContact(record));
                break;
            case "Organization":
                editOrganization((Organization) phoneBook.getContact(record));
                break;
        }

        System.out.println("Saved");

        phoneBook.getInfo(record);
    }

    public void editPerson(Person contact) {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine().toLowerCase();

        switch (field) {
            case "name":
                System.out.print("Enter name: ");
                contact.setName(scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter surname: ");
                contact.setSurname(scanner.nextLine());
                break;
            case "birth":
                System.out.print("Enter birth date: ");
                contact.setBirthDate(ValidInput.setBirthDate(scanner.nextLine()));
                break;
            case "gender":
                System.out.print("Enter gender: ");
                contact.setGender(ValidInput.setGender(scanner.nextLine()));
                break;
            case "number":
                System.out.print("Enter number: ");
                contact.setNumber(ValidInput.setPhoneNumber(scanner.nextLine()));
                break;
            default:
                System.out.println("Incorrect field.");
        }
    }

    public void editOrganization(Organization contact) {
        System.out.print("Select a field (name, address, number): ");
        String field = scanner.nextLine().toLowerCase();

        switch (field) {
            case "name":
                System.out.print("Enter name: ");
                contact.setName(scanner.nextLine());
                break;
            case "address":
                System.out.print("Enter address: ");
                contact.setAddress(scanner.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                contact.setNumber(ValidInput.setPhoneNumber(scanner.nextLine()));
                break;
            default:
                System.out.println("Incorrect field.");
        }
    }

    public void getCount(){
        System.out.print("The Phone Book has ");
        System.out.print(phoneBook.getSize());
        System.out.println(" records.");
    }
}
