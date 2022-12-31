package MueseumBasics;

import DateUtilities.*;
import MyUtilities.Converter;
import MyUtilities.Language;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;


public class Guide extends Employee {
    private int toursPerDay;
    private ArrayList<Language> Languages;
    private ArrayList<Day> daysOfWork;
    private LinkedList<DaysTour> daysTours = new LinkedList<DaysTour>();


    public void langAdder(Language l) {

            this.getLanguages().add(l);


    }

    public void dayAdder(Day d) {

            this.getDaysOfWork().add(d);


    }


    public static DaysTour tmp;
    public int hasEmptyPlace(Calendar c){

        for(DaysTour dt : daysTours){
            if (Converter.daySimChecker(c,dt)){

                if(dt.getCount() == toursPerDay){
                    return 0;}

                else { tmp = dt; return 1;}
            }
        }
        return 2;

    }

    public Guide() {
        Languages = new ArrayList<Language>();
        daysOfWork = new ArrayList<Day>();


    }

    public int getToursPerDay() {
        return toursPerDay;
    }

    public void setToursPerDay(int toursPerDay) {
        this.toursPerDay = toursPerDay;
    }

    public ArrayList<Language> getLanguages() {
        return Languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        Languages = languages;
    }

    public ArrayList<Day> getDaysOfWork() {
        return daysOfWork;
    }

    public void setDaysOfWork(ArrayList<Day> daysOfWork) {
        this.daysOfWork = daysOfWork;
    }

    public LinkedList<DaysTour> getDaysTours() {
        return daysTours;
    }

    public void setDaysTours(LinkedList<DaysTour> daysTours) {
        this.daysTours = daysTours;
    }

    @Override
    public String toString() {
        return super.getName() + super.getId() + super.getDob().toDateString() + this.geteId()
                + this.getHireDate().toDateString();
    }


}
