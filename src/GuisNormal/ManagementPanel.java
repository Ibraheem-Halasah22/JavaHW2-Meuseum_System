package GuisNormal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;


import MueseumBasics.*;
import MyUtilities.*;
import DateUtilities.*;
public class ManagementPanel extends JPanel {

    JPanel allCompsPanel, textAreaPanel;
    JButton addVisBut, addGuiBut, issTicBut;
    JTextField visNameField, visIDField, visDObField;
    JRadioButton senior, regular;
    ButtonGroup senAndReg;
    JTextField guidNameField, guidIDField, guidDObField;
    JPanel WDsPanel;
    JCheckBox sat, sun, mon , tue, wen, thu,fri;
    JPanel guidLangsPanel;
    JCheckBox rus, ar, en, span;
    JRadioButton t1,t2, t3;
    ButtonGroup t;
    JPanel tourPerDayPanel;
    JTextField visNo, visDate, visDay;
    JPanel visDatePanel;
    JPanel typePanel;
    JRadioButton daily, monthly, yearly;
    ButtonGroup typeGroup;
    JPanel tourPanel;
    JCheckBox bookTourCheckBox;
    JComboBox<String> langs;
    JComboBox<String> guides;
    JTextArea textArea;

    String [] lnagsArray = {"English", "Arabic", "Russian","Spanish"};

    String [] tmpString = {"",""};
    Calendar selCal;
    int tickSelection =0;
    boolean dateFlag = false;
    Day selDay;
    private static int personalIDCounter = 100;
    private static int tickIDCounter = 200;
    private static int recIDCounter;

    ArrayList<Guide> guides1;

    static int selGuideIndex =-1;

    private static int tickIDGenerator(){
        ++tickIDCounter;
        return tickIDCounter;
    }
    private static int recIDGenerator(){
        return ++recIDCounter;

    }
    private static int personalIDGenerator(){
        personalIDCounter++;
        return personalIDCounter;
    }
    public ManagementPanel() {


        this.setLayout(new BorderLayout());

        allCompsPanel = new JPanel();
        allCompsPanel.setLayout(new GridLayout(17,2,0,0));

        addVisBut = new JButton("Add Visitor");

        addGuiBut = new JButton("Add Guide");
        addGuiBut.setFont(new Font(addGuiBut.getFont().getFontName(),Font.BOLD,addGuiBut.getFont().getSize()));

        issTicBut = new JButton("Issue Ticket");

        senAndReg = new ButtonGroup();


        allCompsPanel.add(new JLabel("Visitor's Name"));
        visNameField = new JTextField();
        allCompsPanel.add(visNameField);
        allCompsPanel.add(new JLabel("Visitor's ID"));
        visIDField = new JTextField();
        allCompsPanel.add(visIDField);
        allCompsPanel.add(new JLabel("Visitor's Date of Birth"));
        visDObField = new JTextField();
        allCompsPanel.add(visDObField);

        regular = new JRadioButton("Regular Visitor");
        senAndReg.add(regular);
        regular.setSelected(true);
        regular.setEnabled(false);
        allCompsPanel.add(regular);
        senior = new JRadioButton("Senior Visitor");
        allCompsPanel.add(senior);
        senior.setEnabled(false);
        senAndReg.add(senior);

        allCompsPanel.add(addVisBut);
        allCompsPanel.add(new JLabel(" "));
        allCompsPanel.add(new JLabel("Guide's Name"));
        guidNameField = new JTextField();
        allCompsPanel.add(guidNameField);
        allCompsPanel.add(new JLabel("Guide's ID"));
        guidIDField = new JTextField();
        allCompsPanel.add(guidIDField);

        JLabel guidDOBLabel = new JLabel("Guide's Date of Birth");
        guidDOBLabel.setFont(new Font(guidDOBLabel.getFont().getFontName(),Font.BOLD,guidDOBLabel.getFont().getSize()));
        allCompsPanel.add(guidDOBLabel);
        guidDObField = new JTextField();
        allCompsPanel.add(guidDObField);

        JLabel guidWDLabel = new JLabel("Guide's Days of Work");
        guidWDLabel.setFont(new Font(guidWDLabel.getFont().getFontName(),Font.BOLD,guidWDLabel.getFont().getSize()));
        allCompsPanel.add(guidWDLabel);

        WDsPanel = new JPanel();
        WDsPanel.setLayout(new FlowLayout());
        sun = new JCheckBox("Sun");
        WDsPanel.add(sun);
        mon = new JCheckBox("Mon");
        WDsPanel.add(mon);
        tue = new JCheckBox("Tue");
        WDsPanel.add(tue);
        wen = new JCheckBox("Wen");
        WDsPanel.add(wen);
        thu = new JCheckBox("Thu");
        WDsPanel.add(thu);
        fri = new JCheckBox("Fri");
        WDsPanel.add(fri);
        fri.setEnabled(false);
        sat = new JCheckBox("Sat");
        WDsPanel.add(sat);
        allCompsPanel.add(WDsPanel);

        allCompsPanel.add(new JLabel("Day'sMax.Tours "));
        tourPerDayPanel = new JPanel();
        tourPerDayPanel.setLayout(new FlowLayout());
        t = new ButtonGroup();
        t1 = new JRadioButton("1");
        t.add(t1);
        tourPerDayPanel.add(t1);
        t2 = new JRadioButton("2");
        t.add(t2);
        tourPerDayPanel.add(t2);
        t3 = new JRadioButton("3");
        t.add(t3);
        tourPerDayPanel.add(t3);

        allCompsPanel.add(tourPerDayPanel);

        JLabel guidLangLabel = new JLabel("Guide's Languages");
        guidLangLabel.setFont(new Font(guidLangLabel.getFont().getFontName(),Font.BOLD,guidLangLabel.getFont().getSize()));
        allCompsPanel.add(guidLangLabel);

        guidLangsPanel = new JPanel();
        guidLangsPanel.setLayout(new FlowLayout());
        ar = new JCheckBox("ARABIC");
        guidLangsPanel.add(ar);
        en = new JCheckBox("ENGLISH");
        guidLangsPanel.add(en);
        span = new JCheckBox("SPANISH");
        guidLangsPanel.add(span);
        rus = new JCheckBox("RUSSIAN");
        guidLangsPanel.add(rus);
        allCompsPanel.add(guidLangsPanel);




        allCompsPanel.add(addGuiBut);
        allCompsPanel.add(new JLabel(" "));

        allCompsPanel.add(new JLabel("Visitor Number"));
        visNo = new JTextField();
        allCompsPanel.add(visNo);
        allCompsPanel.add(new JLabel("Expected Visit Date\\Day"));

        visDatePanel = new JPanel();
        visDatePanel.setLayout(new GridLayout(1,2));
        visDate = new JTextField();
        visDay = new JTextField();
        visDay.setEditable(false);
        visDate.setEditable(false);
        visDatePanel.add(visDate);
        visDatePanel.add(visDay);
        allCompsPanel.add(visDatePanel);
        allCompsPanel.add(new JLabel("Ticket's Type/Subscription"));

        typePanel = new JPanel();
        typePanel.setLayout(new FlowLayout());
        typeGroup = new ButtonGroup();
        daily = new JRadioButton("Daily");
        typeGroup.add(daily);
        typePanel.add(daily);
        monthly = new JRadioButton("Monthly");
        typeGroup.add(monthly);
        typePanel.add(monthly);
        yearly = new JRadioButton("Yearly");
        typeGroup.add(yearly);
        typePanel.add(yearly);
        allCompsPanel.add(typePanel);

        allCompsPanel.add(new JLabel("Book a tour for this visit?"));

        tourPanel = new JPanel();
        tourPanel.setLayout(new FlowLayout());
        bookTourCheckBox = new JCheckBox("yes ");
        tourPanel.add(bookTourCheckBox);

        tourPanel.add(new JLabel("Language"));
        langs = new JComboBox<String>(lnagsArray);
        tourPanel.add(langs);
        tourPanel.add(new JLabel("Guide"));
        guides = new JComboBox<String>(tmpString);
        //guides.setSelectedIndex(-1);
        tourPanel.add(guides);
        bookTourCheckBox.setEnabled(false);
        guides.setEnabled(false);
        langs.setEnabled(false);
        allCompsPanel.add(tourPanel);

        allCompsPanel.add(issTicBut);
        allCompsPanel.add(new JLabel(" "));

        textAreaPanel = new JPanel();
        textArea = new JTextArea(6,80);
        textArea.setEditable(false);
        textAreaPanel.add(textArea);

        this.add(allCompsPanel,BorderLayout.NORTH);
        this.add(textAreaPanel,BorderLayout.CENTER);

        TickTypeHandler tickTypeHandler = new TickTypeHandler();
        daily.addActionListener(tickTypeHandler);
        monthly.addActionListener(tickTypeHandler);
        yearly.addActionListener(tickTypeHandler);

        addVisBut.addActionListener(e -> {
            int id;
            try {
                id = Integer.parseInt(visIDField.getText().trim());
                if(MyFrame.museumSystem.visitorIdIsExist(id)) throw new InputMismatchException();

            }
            catch (InputMismatchException exc){
                textArea.setText("This visitor ID is already available!");
                return;
            }
            catch (Exception exc){
                textArea.setText("Please enter the ID as a valid number");
                return;
            }
            Calendar calendar = null;
            try{
                calendar = Converter.StringToCalender(visDObField.getText().trim());
            } catch (Exception exception) {
                textArea.setText("Please enter the date of birth at the valid formula");
                return;
            }
            Date dob = new Date(calendar);

            String name = visNameField.getText().trim();
            if(name.isEmpty()){
                textArea.setText("Please enter the name");
                return;
            }
            RegularVisitor regularVisitor = new RegularVisitor();
            regularVisitor.setDob(dob);
            regularVisitor.setvId(id);
            regularVisitor.setName(name);
            regularVisitor.setId(personalIDGenerator());
            MyFrame.museumSystem.getVisitors().add(regularVisitor);
            textArea.setText("Visitor " + name + " added successfully");


        });


        addGuiBut.addActionListener(e -> {
            int id;
            try {
                id = Integer.parseInt(guidIDField.getText().trim());
                if(MyFrame.museumSystem.guideIdIsExist(id)) throw new InputMismatchException();

            }
            catch (InputMismatchException exc){
                textArea.setText("This Employee ID is already available!");
                return;
            }
            catch (Exception exc){
                textArea.setText("Please enter the ID as a valid number");
                return;
            }
            Guide guide = new Guide();
            Calendar calendar1 = Calendar.getInstance();
            Date date = new Date(calendar1);
            guide.setHireDate(date);
            try{
                calendar1 = Converter.StringToCalender(guidDObField.getText().trim());
            } catch (Exception exception) {
                textArea.setText("Please enter the date of birth at the valid formula");
                return;
            }
           // System.out.println(calendar1);
            Date dob = new Date(calendar1);
            String name = guidNameField.getText().trim();
            if(name.isEmpty()){
                textArea.setText("Please enter the name");
                return;
            }
            int max;
            if(t1.isSelected()) max = 1;
            else if(t2.isSelected()) max = 2;
            else if(t3.isSelected()) max = 3;
            else {
                textArea.setText("Please select the maximum tours per day");
                return;
            }

            if(ar.isSelected()) guide.getLanguages().add(Language.ARABIC);
            if(en.isSelected()) guide.getLanguages().add(Language.ENGLISH);
            if(span.isSelected()) guide.getLanguages().add(Language.SPANISH);
            if(rus.isSelected()) guide.getLanguages().add(Language.RUSSIAN);
            if(guide.getLanguages().isEmpty()){
                textArea.setText("Please specify at least one language");
                return;
            }

            if (sat.isSelected()) guide.getDaysOfWork().add(Day.SATURDAY);
            if (sun.isSelected()) guide.getDaysOfWork().add(Day.SUNDAY);
            if (mon.isSelected()) guide.getDaysOfWork().add(Day.MONDAY);
            if (tue.isSelected()) guide.getDaysOfWork().add(Day.TUESDAY);
            if (wen.isSelected()) guide.getDaysOfWork().add(Day.WEDNESDAY);
            if (thu.isSelected()) guide.getDaysOfWork().add(Day.THURSDAY);
            if(guide.getDaysOfWork().isEmpty()){
                textArea.setText("Please specify at least one working day");
                return;
            }

            guide.setId(personalIDGenerator());

            guide.setDob(dob);
            guide.setToursPerDay(max);
            guide.seteId(id);
            guide.setName(name);
            MyFrame.museumSystem.getGuides().add(guide);
            textArea.setText("Guide " + name + " added successfully");
            t.clearSelection();
        });

        bookTourCheckBox.addActionListener(e -> {
            if(!bookTourCheckBox.isSelected()){
                visDate.setEditable(true);
                langs.setEnabled(false);
                guides.setEnabled(false);
            }
            else {
                visDate.setEditable(false);
                langs.setEnabled(true);
                guides.setEnabled(true);
                //guides.setSelectedIndex(-1);
            }

        });

        langs.addActionListener(e -> {

            String selLangStr =(String)langs.getSelectedItem();
            selLangStr = selLangStr.toString().trim();
            //System.out.println(selLangStr);
            Language selLang = Language.stringToLanguage(selLangStr);
            //System.out.println(selLang);
            guides1 = MyFrame.museumSystem.getAvailableGuides(selCal,selLang);

            ArrayList<String> avGuides = new ArrayList<>();
          //  guides = new JComboBox<String>();
            guides.removeAllItems();
            for (int i= 0 ; i<guides1.size(); i++){
               // System.out.println(guides1.get(i).getName());
                avGuides.add( guides1.get(i).getName() + "  " +guides1.get(i).geteId());
               // System.out.println(avGuides.get(i));
                guides.insertItemAt(avGuides.get(i),i);


            }

            //tourPanel.remove(guides);
            //tourPanel.add(guides);

            for (int i= 0 ; i<guides1.size(); i++){
              //  guides.addItem(avGuides[i]);
            }
        });

        visDate.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {

                Calendar calendar = null;
                Calendar calendar1 = Calendar.getInstance();
                try {
                    calendar = Converter.StringToCalender(visDate.getText().trim());
                    //System.out.println(visDate.getText());
                    //Date d = new Date(calendar);
                    //System.out.println(d.toDateString());
                    int willDays = Converter.daysDifferenceCalc(calendar1,calendar);
                    if( willDays <0 ) {
                        textArea.setText("This date was passed!!!!!");
                        dateFlag = false;

                    }
                    else if((willDays > 1 && tickSelection ==1) || (willDays > 30 && tickSelection ==2)
                    || (willDays > 365 && tickSelection ==3)){
                        textArea.setText("The type of the ticket isn't reach this date");
                        dateFlag = false;

                    }
                    else dateFlag = true;

                }


                catch (Exception exception){
                    dateFlag = false;

                }
                if(dateFlag) {bookTourCheckBox.setEnabled(true);
                selDay = Converter.calToDay(calendar);
                if(selDay == Day.FRIDAY) {
                    textArea.setText("Can't visit on Friday");
                    bookTourCheckBox.setEnabled(false);
                    dateFlag = false;
                    return;
                }
                visDay.setText(String.valueOf(selDay));
                textArea.setText("");
                selCal = calendar;
                }
                else {
                    bookTourCheckBox.setEnabled(false);
                    visDay.setText("");
                }
            }
        });






        issTicBut.addActionListener(e -> {
            try {

                if (!MyFrame.museumSystem.visitorIdIsExist(Integer.parseInt(visNo.getText().trim()))) {
                    textArea.setText("This visitor isn't available!");
                    return;
                }
            }
            catch (Exception exception){
                textArea.setText("Please enter the ID as a valid number");
            }
            if(!dateFlag){
                textArea.setText("Please specify a valid date for visit");
                return;
            }

            int price=0;
            VisitorRecord visitorRecord = new VisitorRecord();
            visitorRecord.setEnteringDate(new Date(selCal));
            visitorRecord.setRecord_id(recIDGenerator());
            Visitor v =
            MyFrame.museumSystem.getVisitors().get(MyFrame.museumSystem.guideIdIndexFinder(Integer.parseInt(visNo.getText().trim())));

            if (bookTourCheckBox.isSelected()){
                if(guides1.isEmpty()){
                    textArea.setText("There's no available guides");
                    return;
                }

            }
            else{
                price +=  Ticket.GUIDE_FEES;
                if(guides1.get(guides.getSelectedIndex()).hasEmptyPlace(selCal) == 1){
                    Guide.tmp.setCount(Guide.tmp.getCount()+1);
                }
                else if(guides1.get(guides.getSelectedIndex()).hasEmptyPlace(selCal) == 2){
                    DaysTour daysTour = new DaysTour(selCal);
                    daysTour.setCount(1);
                    guides1.get(guides.getSelectedIndex()).getDaysTours().add(daysTour);
                }
            }

            Ticket ticket = new Ticket();
            ticket.setTickVisitor(v);
            switch (tickSelection){
                case 1:
                    ticket.setTicketType(TicketType.DAILY);
                    price += Ticket.DAILY_PRICE;
                    break;
                case 2:
                    ticket.setTicketType(TicketType.MONTHLY);
                    price += Ticket.MONTHLY_PRICE;
                    break;
                case 3:
                    ticket.setTicketType(TicketType.YEARLY);
                    price+= Ticket.YEARLY_PRICE;
                    break; default:
                        throw new IllegalArgumentException();

            }
            ticket.setIssue_date(new Date(Calendar.getInstance()));


            if(v.isSenior()){
                SeniorVisitor sv = (SeniorVisitor) v;
                ticket.setPrice((int) (price - (price * sv.getDiscountRate())));
            }
            else ticket.setPrice(price);




            if(!v.isSenior() && (v.getVisits_count()==3)){
                v = Visitor.promote((RegularVisitor) v);

            }
            v.getVisits().add(visitorRecord);
            MyFrame.museumSystem.getTickets().add(ticket);

            String ticketInfo ="Ticket Info:-\n";
            ticketInfo += ("Visitor name: " + ticket.getTickVisitor().getName()+"\n;");
            ticketInfo+= ("Visit day: " + visitorRecord.getEnteringDate().toDateString() + "  " +visDay.getText()+"\n");
            ticketInfo +="With a tour ? ";
            if(bookTourCheckBox.isSelected()){
                ticketInfo+="yes  ";
                ticketInfo += (langs.getSelectedItem().toString() +"  "+ guides.getSelectedItem().toString() +"\n");
            }
            else {
                ticketInfo+="no\n";

            }

            ticketInfo+=("Price: "+String.valueOf(ticket.getPrice()));
            textArea.setText(ticketInfo);
            dateFlag = false;
            tickSelection = 0;
            typeGroup.clearSelection();
            visDate.setEditable(false);
            langs.setEnabled(false);
            guides.removeAllItems();
            guides.setEnabled(false);
            visDate.setText("At:dd/mm/yyyy");
            visDay.setText("");
            guides.setSelectedIndex(-1);
        });

    }
    class TickTypeHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dateFlag = false;
            visDate.setEditable(true);
            visDate.setText("At:dd/mm/yyyy");
            guides.setSelectedIndex(-1);
            guides.setEnabled(false);
            langs.setEnabled(false);
            visDay.setText("");
            bookTourCheckBox.setEnabled(false);
            bookTourCheckBox.setSelected(false);
            if(daily.isSelected()) tickSelection=1;
            else if(monthly.isSelected()) tickSelection = 2;
            else if (yearly.isSelected()) tickSelection = 3;
        }
    }
}
