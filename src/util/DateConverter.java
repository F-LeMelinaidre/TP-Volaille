package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DateConverter {

    public static Calendar StringToCalendar(String date, String patern) {
        Calendar         calendar = Calendar.getInstance();
        SimpleDateFormat sdf      = new SimpleDateFormat(patern);
        try {
            calendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            //logger.error("\u001B[31mFormat de date invalide ! Format attendu dd/mm/yyyy\u001B[0m");
        }
        return calendar;
    }

    public static LocalDate CalendarToLocalDate(Calendar date) {
        return LocalDate.of(date.get(Calendar.YEAR),
                            date.get(Calendar.MONTH) + 1,
                            date.get(Calendar.DAY_OF_MONTH));
    }
}
