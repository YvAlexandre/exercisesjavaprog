package be.ing.utilities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtils {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate parse(String date){
        return LocalDate.parse(date,dtf);
    }

    public static String format(LocalDate date){
        return date.format(dtf);
    }
}
