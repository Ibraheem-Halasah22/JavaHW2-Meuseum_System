package MueseumBasics;

import DateUtilities.Date;



public class Employee extends Person {
    private int employment_id;
    private Date hireDate;

    public int geteId() {
        return employment_id;
    }



    public void seteId(int employment_id) {
        if (employment_id >= 0 && employment_id <= 9999999)
            this.employment_id = employment_id;
        else throw new IllegalArgumentException();
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }



    @Override
    public String toString() {
        return super.getName() + super.getId() + super.getDob().toDateString()  + this.geteId()
                + this.getHireDate().toDateString();
    }

}
