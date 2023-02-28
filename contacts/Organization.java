package contacts;

public class Organization extends Contacts {
    private String address;

    public Organization(String name, String address, String number) {
        super(name, number);
        this.address = address;
    }

    public String getNameString() {
        return getName();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "Organization name: " + this.getName() + "\n" +
                "Address: " + this.getAddress() + "\n" +
                "Number: " + this.getNumber() + "\n" +
                "Time created: " + this.getTimeCreated() + "\n" +
                "Time last edit: " + this.getTimeEdited() + "\n";
    }
}
