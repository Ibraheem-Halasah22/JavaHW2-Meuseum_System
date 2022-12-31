package DateUtilities;


import java.util.Calendar;

public class Date extends java.util.Calendar {
    public Date(Calendar c) {
        for (int f = 0; f < Calendar.FIELD_COUNT; f++) super.set(f, c.get(f));
    }

    public static boolean checkIfFriday(Calendar c) {
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) return true;
        else
            return false;

    }

    public static Day calendarToMyDay(Calendar c) {
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) return Day.FRIDAY;
        else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) return Day.SATURDAY;
        else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) return Day.SUNDAY;
        else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) return Day.MONDAY;
        else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) return Day.TUESDAY;
        else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) return Day.WEDNESDAY;
        else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) return Day.THURSDAY;
        else throw new IllegalArgumentException();


    }

    public String toDateString() {
        return super.get(Calendar.DAY_OF_MONTH) + "/" + (super.get(Calendar.MONTH) + 1) + "/" + super.get(Calendar.YEAR);
    }

    public String toDateAndTimeString() {
        return super.get(Calendar.DAY_OF_MONTH) + "/" + (super.get(Calendar.MONTH) + 1) + "/" + super.get(Calendar.YEAR) + "\t" + super.get(Calendar.HOUR) + " : " + super.get(Calendar.MINUTE);
    }

    @Override
    protected void computeTime() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void computeFields() {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(int field, int amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void roll(int field, boolean up) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMinimum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMaximum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getGreatestMinimum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getLeastMaximum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }


}