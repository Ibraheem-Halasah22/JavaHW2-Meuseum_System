package MueseumBasics;
import java.util.*;
import java.util.Date;

public abstract class Visitor extends Person {
    private int visitorId;
    private int visits_count;
    private ArrayList<VisitorRecord> Visits;
    private boolean isSenior;

    public Visitor() {
        Visits = new ArrayList<VisitorRecord>();
    }

    public static SeniorVisitor promote(RegularVisitor RV){
        SeniorVisitor NSV = new SeniorVisitor();
        NSV.setId(RV.getId());
        NSV.setName(RV.getName());
        NSV.setAddress(RV.getAddress());

        NSV.setvId(RV.getvId());
        NSV.setVisits(RV.getVisits());

        NSV.setDob(RV.getDob());
        NSV.setSenior(true);
        System.out.println("Promoted");


        return NSV;
    }
    public int getvId() {
        return visitorId;
    }

    public void setvId(int visitorId) {
        if ((visitorId > 99999999) || (visitorId < 0))
            throw new IllegalArgumentException();
        this.visitorId = visitorId;
    }



    public int getVisits_count() {
        return Visits.size();
    }



    public ArrayList<VisitorRecord> getVisits() {
        return Visits;
    }

    public void setVisits(ArrayList<VisitorRecord> visits) {
        Visits = visits;

    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }


    @Override
    public String toString(){
        return this.getName()+this.getId() +this.getDob().toDateString()+ this.getvId() +this.getAddress() +this.getVisits_count() ;
    }

}
