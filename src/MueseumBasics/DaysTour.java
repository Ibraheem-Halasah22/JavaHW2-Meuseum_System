package MueseumBasics;

import DateUtilities.Date;

import java.util.Calendar;

public class DaysTour extends Calendar {

    int count;

    public DaysTour(Calendar c) {
        for (int f = 0; f < Calendar.FIELD_COUNT; f++) super.set(f, c.get(f));
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    protected void computeTime() {

    }

    @Override
    protected void computeFields() {

    }

    @Override
    public void add(int field, int amount) {

    }

    @Override
    public void roll(int field, boolean up) {

    }

    @Override
    public int getMinimum(int field) {
        return 0;
    }

    @Override
    public int getMaximum(int field) {
        return 0;
    }

    @Override
    public int getGreatestMinimum(int field) {
        return 0;
    }

    @Override
    public int getLeastMaximum(int field) {
        return 0;
    }
}
