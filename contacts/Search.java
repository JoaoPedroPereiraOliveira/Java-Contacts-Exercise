package contacts;

import java.util.List;
import java.util.Scanner;

public class Search {
    Scanner scanner;
    Actions actions;
    String option;
    Record record;
    List<Integer> query;

    public Search(Scanner scanner, Actions actions) {
        this.scanner = scanner;
        this.actions = actions;
        this.record = new Record(scanner, actions);
    }

    public void Start() {
        this.query = actions.Search();
        System.out.println();
        System.out.print("[search] Enter action ([number], back, again): ");
        this.option = scanner.nextLine().toLowerCase();

        if (!ValidInput.isIntiger(this.option)) {
            ActionsString();
        } else if (Integer.parseInt(this.option) > 0 && Integer.parseInt(this.option) <= query.size()) {
            ActionsNumbers(Integer.parseInt(this.option));
        } else {
            Start();
        }
    }

    public void ActionsString() {
        switch (this.option) {
            case "back": return;
            case "again": this.Start();
            default: Start();
        }
    }

    public void ActionsNumbers(int option) {
        actions.Get(this.query.get(option - 1));
        record.Start();
    }
}
