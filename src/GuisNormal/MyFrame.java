package GuisNormal;
import DateUtilities.Day;
import MueseumBasics.MuseumSystem;
import MyUtilities.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import javax.swing.event.*;


public class MyFrame extends JFrame {
    //static Mu
    static MuseumSystem museumSystem = new MuseumSystem();
    JPanel butsPanel, infosPanel;
    JButton guideBut, visitBut, manageBut;
    JLabel nameL, addL, workDaysL;
    VisitorInfo visitorInfo = new VisitorInfo();
    GuideInfo guideInfo = new GuideInfo();
    ManagementPanel managementPanel = new ManagementPanel();

    public MyFrame() {
        super("Museum Management System");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout(0,10));
        this.setSize(1000, 700);
        butsPanel = new JPanel();
        butsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(visitorInfo);
        visitorInfo.setVisible(false);

        this.add(guideInfo);
        guideInfo.setVisible(false);

        this.add(managementPanel);
        managementPanel.setVisible(false);

        guideBut = new JButton("Guide Information");
        guideBut.addActionListener(e -> {
            super.add(guideInfo,BorderLayout.CENTER);
            visitorInfo.setVisible(false);
            managementPanel.setVisible(false);
            guideInfo.setVisible(true);
            this.setSize(1000, 700);
            guideInfo.textArea.setText("");
            guideInfo.searchTextField.setText("");
        });
        butsPanel.add(guideBut);
        visitBut = new JButton("Visitor Information");




        visitBut.addActionListener((e)-> {
            super.add(visitorInfo,BorderLayout.CENTER);
            guideInfo.setVisible(false);
            managementPanel.setVisible(false);
            visitorInfo.setVisible(true);
            this.setSize(1000, 700);
            visitorInfo.textArea.setText("");
            visitorInfo.subsButtonsGroup.clearSelection();
            visitorInfo.subsCountLabel.setText("   ");
            visitorInfo.regulars.setSelected(false);
            visitorInfo.seniors.setSelected(false);
            visitorInfo.calculateSeniorsAndRegularsLabel.setText("   ");


        });
        butsPanel.add(visitBut);
        manageBut = new JButton("Management");
        butsPanel.add(manageBut);
        manageBut.addActionListener(e -> {
            super.add(managementPanel,BorderLayout.CENTER);
            visitorInfo.setVisible(false);
            guideInfo.setVisible(false);
            managementPanel.setVisible(true);
            this.setSize(1000,825);
            managementPanel.textArea.setText("");
        });

        infosPanel = new JPanel();
        infosPanel.setLayout(new GridLayout(3,1,0,0));
        infosPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);


        nameL = new JLabel("Museum Name: The Worst Museum 🙂");

        nameL.setFont(new Font(nameL.getFont().getFontName(),Font.BOLD,16));
        infosPanel.add(nameL);

        addL = new JLabel("Museum Address: The Hell");
        infosPanel.add(addL);

        String s = "Museum's working days: ";
        for(Day d : museumSystem.getDaysOfWork()){
            s += d; s+="  ";}
        workDaysL = new JLabel(s);
        infosPanel.add(workDaysL);
        JPanel butsAndInfosPanael = new JPanel();
        butsAndInfosPanael.setLayout(new BorderLayout(0,0));
        butsAndInfosPanael.add(butsPanel,BorderLayout.NORTH);
        butsAndInfosPanael.add(infosPanel,BorderLayout.CENTER);





        super.add(butsAndInfosPanael,BorderLayout.NORTH);




    }
}
