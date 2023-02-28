package contacts;

import java.time.LocalDate;

public class Person extends Contacts {
    private String surname;
    private String gender;
    private LocalDate birthDate;

    public Person(String name, String surname, LocalDate birthDate, String gender, String number) {
        super(name, number);
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getNameString() {
        return getName() + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        if (gender.equals("M") || gender.equals("F")) {
            return gender;
        }
        return "[no data]";
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        if (birthDate == null) {
            return "[no data]";
        }

        return birthDate.toString();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "Name: " + this.getName() + "\n" +
                "Surname: " + this.getSurname() + "\n" +
                "Birth date: " + this.getBirthDate() + "\n" +
                "Gender: " + this.getGender() + "\n" +
                "Number: " + this.getNumber() + "\n" +
                "Time created: " + this.getTimeCreated() + "\n" +
                "Time last edit: " + this.getTimeEdited() + "\n";
    }
}
