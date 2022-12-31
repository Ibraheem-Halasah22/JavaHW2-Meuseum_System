package MueseumBasics;

import DateUtilities.Date;

public class VisitorRecord {
    private int record_id;
    private Date enteringDate;
    private boolean withATour;
    private String guide;
    private String language;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public Date getEnteringDate() {
        return enteringDate;
    }

    public void setEnteringDate(Date enteringDate) {
        this.enteringDate = enteringDate;
    }

    public boolean isWithATour() {
        return withATour;
    }

    public void setWithATour(boolean withATour) {
        this.withATour = withATour;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString(){
        String s = record_id + " " + enteringDate.toDateString() + " with a tour? ";
        if(withATour){
            s+=(" yes guide: " + guide +" lang: " + language);
        }
        else s+= " no ";
        return s;
    }
}
