package MyUtilities;

import DateUtilities.Day;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.InputMismatchException;

public abstract class Converter {
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

    public static Calendar StringToCalender(String s) throws ParseException {
        Date d = sdf1.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        return c;

    }

    public static int ageCalculator(Calendar c0) {
        Date d = c0.getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        return diff1.getYears();

    }

    public static int daysDifferenceCalc(Calendar initial, Calendar ffinal) {
        long mSecs = ffinal.getTimeInMillis() - initial.getTimeInMillis();
        double secs = mSecs / 1000.0;
        double hrs = secs / 3600.0;
        double days = hrs / 24.0;
        return (int) days;


    }

    public static boolean daySimChecker(Calendar initial, Calendar ffinal){
        return initial.get(Calendar.YEAR)==ffinal.get(Calendar.YEAR) && initial.get(Calendar.MONTH) == ffinal.get(Calendar.MONTH)
                && initial.get(Calendar.DAY_OF_MONTH) == ffinal.get(Calendar.DAY_OF_MONTH);
    }


    public static Day calToDay(Calendar calendar){
        if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) return Day.SATURDAY;
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) return Day.SUNDAY;
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY) return Day.MONDAY;
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY) return Day.TUESDAY;
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY)return Day.WEDNESDAY;
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY) return Day.THURSDAY;
        else if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY) return Day.FRIDAY;

        else throw new IllegalArgumentException();

    }


}
