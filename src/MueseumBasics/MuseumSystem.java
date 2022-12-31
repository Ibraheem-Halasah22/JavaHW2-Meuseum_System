package MueseumBasics;
import DateUtilities.Date;
import DateUtilities.Day;
import MyUtilities.Converter;
import MyUtilities.Language;

import java.util.ArrayList;
import java.util.Calendar;

public class MuseumSystem {
    private ArrayList<Day> daysOfWork = new ArrayList<Day>(6);
    private ArrayList<Guide> guides;
    private ArrayList<Visitor> visitors;
    private ArrayList<Ticket> Tickets;

    public int visitorIdIndexFinder(int id) {
        for (Visitor v : this.getVisitors()) if (v.getvId() == id) return this.getVisitors().indexOf(v);


        return -1;
    }

    public boolean visitorIdIsExist(int id) {
        if (visitorIdIndexFinder(id) >= 0) return true;
        return false;

    }
    public int guideIdIndexFinder(int id) {
        for (Guide g : this.getGuides()) if (g.geteId() == id) return this.getGuides().indexOf(g);
        return -1;
    }
    public boolean guideIdIsExist(int id) {
        if (this.guideIdIndexFinder(id) >= 0) return true;


        else return false;

    }

    public int seniorsCounter(){
        int count = 0;
        for(Visitor v : this.visitors)
            if(v.isSenior())count++;

        return count;
    }
    public int regularsCounter(){
        int count = 0;
        for(Visitor v : this.visitors)
            if(!v.isSenior())count++;

        return count;
    }
    public int dailyCounter(){
        int count = 0;
        for(Ticket t : Tickets ) if(t.getTicketType() == TicketType.DAILY) count++;
        return count;
    }
    public int monthlyCounter(){
        int count = 0;
        for(Ticket t : Tickets ) if(t.getTicketType() == TicketType.MONTHLY) count++;
        return count;
    }
    public int yearlyCounter(){
        int count = 0;
        for(Ticket t : Tickets ) if(t.getTicketType() == TicketType.YEARLY) count++;
        return count;
    }

    public ArrayList<Guide> getAvailableGuides(Calendar c , Language l){
        ArrayList<Guide> ar = new ArrayList<Guide>();
        for(Guide g : guides){
            if(g.getLanguages().contains(l) && g.getDaysOfWork().contains(Converter.calToDay(c))){
                if(g.hasEmptyPlace(c) > 0) ar.add(g);
            }
        }

        return ar;

    }


    public MuseumSystem() {
        guides = new ArrayList<Guide>();
        visitors = new ArrayList<Visitor>();
        Tickets = new ArrayList<Ticket>();


        //////////////////////////////
//        Visitor s = new SeniorVisitor();
//        s.setName("Khalid");
//        s.setvId(1);
//        s.setSenior(true);
//        s.setId(1000);
//
//        s.setDob(new Date());











                //////////////////////////
        daysOfWork.add(Day.SATURDAY);
        daysOfWork.add(Day.SUNDAY);
        daysOfWork.add(Day.MONDAY);
        daysOfWork.add(Day.TUESDAY);
        daysOfWork.add(Day.WEDNESDAY);
        daysOfWork.add(Day.THURSDAY);


    }
    public ArrayList<Guide> getGuides() {
        return guides;
    }

    public void setGuides(ArrayList<Guide> guides) {
        this.guides = guides;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }
    public void setVisitors(ArrayList<Visitor> visitors) {
        this.visitors = visitors;
    }

    public ArrayList<Ticket> getTickets() {
        return Tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        Tickets = tickets;
    }

    public ArrayList<Day> getDaysOfWork() {
        return daysOfWork;
    }

    public void setDaysOfWork(ArrayList<Day> daysOfWork) {
        this.daysOfWork = daysOfWork;
    }
}
