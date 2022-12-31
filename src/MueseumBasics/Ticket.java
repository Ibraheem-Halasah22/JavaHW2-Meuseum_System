package MueseumBasics;

import DateUtilities.Date;


public class Ticket {
    private Date issue_date;
    private int price;
    private int tickId;
    private Visitor tickVisitor;
    private TicketType ticketType;
    public static final int DAILY_PRICE = 15;
    public static final int MONTHLY_PRICE = 70;
    public static final int YEARLY_PRICE = 200;
    public static final int GUIDE_FEES = 20;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0) throw new IllegalArgumentException();
        else this.price = price;
    }

    public int getTickId() {
        return tickId;
    }

    public void setTickId(int tickId) {
        if ((tickId > 99999999) || (tickId < 0))
            throw new IllegalArgumentException();
        this.tickId = tickId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Visitor getTickVisitor() {
        return tickVisitor;
    }

    public void setTickVisitor(Visitor tickVisitor) {
        this.tickVisitor = tickVisitor;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }
}
