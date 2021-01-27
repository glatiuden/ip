package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper methods used to validate and format inputs.
 */
public class DukeHelper {

    /**
     * Returns a formatted date String.
     * @param date date to be formatted
     * @return formatted date String
     */
    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return date.format(formatter);
    }

    /**
     * Returns a formatted date String.
     * @param dateString a date String to be formatted
     * @return formatted date String
     */
    public static String formatDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        LocalDate date = LocalDate.parse(dateString);
        return date.format(formatter);
    }

    /**
     * Returns true if the String is a valid date.
     * @param dateString a date String to be checked
     */
    public static boolean isValidDate(String dateString) {
        try {
            LocalDate.parse(dateString);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    /**
     * Returns true if the String is a number.
     * @param numberString a number String to be checked
     */
    public static boolean isNumeric(String numberString) {
        try {
            Integer.parseInt(numberString);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
