package contacts;

import java.util.List;
import java.util.Scanner;

public class ContactList {
    Scanner scanner;
    Actions actions;
    String option;
    Record record;
    List<Integer> listIndexes;

    public ContactList(Scanner scanner, Actions actions) {
        this.scanner = scanner;
        this.actions = actions;
        this.record = new Record(scanner, actions);
    }

    public void Start() {
        listIndexes = actions.List();
        System.out.println();
        System.out.print("[list] Enter action ([number], back): ");
        this.option = scanner.nextLine().toLowerCase();

        if (!ValidInput.isIntiger(this.option)) {
            ActionsString();
        } else if (Integer.parseInt(this.option) > 0 && Integer.parseInt(this.option) <= listIndexes.size()) {
            ActionsNumbers(Integer.parseInt(this.option));
        } else {
            Start();
        }
    }

    public void ActionsString() {
        switch (this.option) {
            case "back": break;
            default: Start();
        }
    }

    public void ActionsNumbers(int option) {
        actions.Get(this.listIndexes.get(option - 1));
        record.Start();
    }
}
