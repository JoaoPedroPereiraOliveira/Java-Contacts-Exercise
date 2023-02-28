package contacts;

import java.util.Scanner;

public class Record {
    Scanner scanner;
    Actions actions;
    String option;

    public Record(Scanner scanner, Actions actions) {
        this.scanner = scanner;
        this.actions = actions;
    }

    public void Start() {
        System.out.println();
        System.out.print("[record] Enter action (edit, delete, menu): ");
        this.option = scanner.nextLine().toLowerCase();
        Actions();
    }

    public void Actions() {
        switch (this.option) {
            case "edit":
                this.actions.edit();
                Start();
                return;
            case "delete":
                this.actions.delete();
                return;
            case "menu": return;
            default: Start();
        }
    }
}
