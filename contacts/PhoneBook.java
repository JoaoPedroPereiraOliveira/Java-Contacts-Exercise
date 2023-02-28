package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 123L;
    String file = "PhoneBook.txt";
    private List<Contacts> contactsList;

    public PhoneBook() {
        this.contactsList = new ArrayList<>();
    }

    public void addContact(Contacts contacts){
        contactsList.add(contacts);
    }

    public void removeContact(int record){
        contactsList.remove(record);
    }

    public String getContactType(int record){
        return contactsList.get(record).getClass().getSimpleName();
    }

    public Contacts getContact(int record){
        return contactsList.get(record);
    }

    public void getInfo(int record) {
        System.out.println(contactsList.get(record).toString());
    }
    public List<Contacts> getContactsList() {
        return contactsList;
    }
    public void getName(int record) {
        switch (contactsList.get(record).getClass().getSimpleName()) {
            case "Person":
                Person person = (Person) contactsList.get(record);
                System.out.println(person.getNameString());
                break;
            case "Organization":
                Organization organization = (Organization) contactsList.get(record);
                System.out.println(organization.getNameString());
                break;
        }
    }

    public int getSize(){
        return  contactsList.size();
    }

    public List<Integer> getList() {
        if (contactsList.size() == 0) {
            System.out.println("The list is empty!");
            return null;
        }

        List<Integer> newContactList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < contactsList.size(); i++) {
            index++;
            System.out.print(index + ". ");
            switch (contactsList.get(i).getClass().getSimpleName()) {
                case "Person":
                    Person person = (Person) contactsList.get(i);
                    System.out.println(person.getName() + " " + person.getSurname());
                    newContactList.add(i);
                    break;
                case "Organization":
                    Organization organization = (Organization) contactsList.get(i);
                    System.out.println(organization.getName() + " ");
                    newContactList.add(i);
                    break;
            }
        }
        return newContactList;
    }

    public List<Integer> queryList(String query) {
        List<Integer> newContactList = new ArrayList<>();
        query = query.toLowerCase();

        for (int i = 0; i < contactsList.size(); i++) {
            switch (contactsList.get(i).getClass().getSimpleName()) {
                case "Person":
                    Person person = (Person) contactsList.get(i);

                    if (person.getName().toLowerCase().contains(query) ||
                            person.getSurname().toLowerCase().contains(query) ||
                            person.getNumber().toLowerCase().contains(query)) {
                        newContactList.add(i);
                    }
                    break;
                case "Organization":
                    Organization organization = (Organization) contactsList.get(i);

                    if (organization.getName().toLowerCase().contains(query) ||
                            organization.getNumber().toLowerCase().contains(query)) {
                        newContactList.add(i);
                    }
                    break;
            }
        }
        return newContactList;
    }
}
