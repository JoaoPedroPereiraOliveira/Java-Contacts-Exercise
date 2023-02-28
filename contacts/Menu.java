package contacts;

import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Actions actions;
    String option;
    Search search;
    ContactList contactList;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.actions = new Actions(scanner, new PhoneBook());
        this.search = new Search(this.scanner, this.actions);
        this.contactList = new ContactList(this.scanner, this.actions);
    }

    public void Start() {
        System.out.print("[menu] Enter action (add, list, search, count, exit): ");
        this.option = scanner.nextLine().toLowerCase();
        Actions();
    }

    public void Actions() {
        switch (this.option) {
            case "add":
                this.actions.Add();
                break;
            case "list":
                this.contactList.Start();
                break;
            case "search":
                this.search.Start();
                break;
            case "count":
                this.actions.getCount();
                break;
            case "exit": return;
            default: Start();
        }

        System.out.println();
        this.Start();
    }
}
