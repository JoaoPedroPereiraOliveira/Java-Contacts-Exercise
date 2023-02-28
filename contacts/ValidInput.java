package contacts;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidInput {
    public static LocalDate setBirthDate(String birthDate) {
        try {
            LocalDate.parse(birthDate);
        } catch (DateTimeException e) {
            System.out.println("Bad birth date!");
            return null;
        }
        return LocalDate.parse(birthDate);
    }

    public static String setGender(String gender) {
        if (!gender.equals("M") && !gender.equals("F")) {
            System.out.println("Bad gender!");
            return "[no data]";
        }
        return gender;
    }

    public static String setPhoneNumber(String number) {
        if (!ValidInput.isPhoneNumber(number)) {
            System.out.println("Wrong number format!");
            return "[no data]";
        }
        return number;
    }

    public static boolean isPhoneNumber(String number) {
        // Can be split into Groups
        String[] splitedNumber;
        splitedNumber = number.split("( )|(-)");

        // Groups 0 and 1 have repeated parentheses
        if (splitedNumber.length > 1) {
            if ((splitedNumber[0].charAt(0) == '(' || splitedNumber[0].charAt(0) == '+') &&
                    splitedNumber[0].charAt(splitedNumber[0].length() - 1) == ')' &&
                    splitedNumber[1].charAt(0) == '(' &&
                    splitedNumber[1].charAt(splitedNumber[1].length() - 1) == ')') {
                return false;
            }
        }

        // Groups 2+ have parentheses
        for (int i = 2; i < splitedNumber.length; i++) {
            if (splitedNumber[i].charAt(0) == '(' &&
                    splitedNumber[i].charAt(splitedNumber[i].length() - 1) == ')') {

                return false;
            }
        }

        // First Group 1 symbol in length
        if (splitedNumber[0].contains("+") && splitedNumber[0].charAt(1) != '('
                && splitedNumber[0].length() > 3) {
            return false;
        }

        // Groups 1+ should be at least 2 symbols in length
        for (int i = 1; i < splitedNumber.length; i++) {
            if (splitedNumber[i].length() < 2) {
                return false;
            }
            Pattern pattern = Pattern.compile("^[0-9A-Za-z+]+$|^\\([0-9A-Za-z+]+\\)$|^\\+\\([0-9A-Za-z+]+\\)$");
            Matcher matcher = pattern.matcher(splitedNumber[0]);
            int count = 0;
            if (!matcher.find()) {
                return false;
            }
        }

        Pattern pattern = Pattern.compile("^[0-9A-Za-z+]+$|^\\([0-9A-Za-z+]+\\)$|^\\+\\([0-9A-Za-z+]+\\)$");
        Matcher matcher = pattern.matcher(splitedNumber[0]);
        int count = 0;
        if (!matcher.find()) {
            return false;
        }
        while (count != splitedNumber.length - 1) {
            count++;
            matcher = pattern.matcher(splitedNumber[count]);
            if (!matcher.find()) {
                return false;
            }
        }

        return true;
    }

    public static int isValidContact(String record, int size){
        if (!isIntiger(record)) {
            return -1;
        }

        int i = Integer.parseInt(record) - 1;

        if (i >= 0 && i < size) {
            return i;
        }

        return -1;
    }

    public static boolean isIntiger(String recordString) {
        if (recordString == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(recordString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
