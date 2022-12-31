package MueseumBasics;

import DateUtilities.Date;
import MyUtilities.Language;

public class Person {
    private String name;
    private String address;
    private int id;
    private Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if ((id > 999999999) || (id < 0))
            throw new IllegalArgumentException();
        this.id = id;



    }

}
