package GuisNormal;

import MueseumBasics.Visitor;
import MueseumBasics.VisitorRecord;
import MyUtilities.Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitorInfo extends JPanel implements ActionListener {
    JCheckBox regulars;
    JCheckBox seniors;
    JPanel selections;
    JPanel calculateSeniorsAndRegulars, searchPanel, subsCountPanel;
    JPanel textAreaPanel;
    JButton searchButton;
    JLabel calculateSeniorsAndRegularsLabel, subsCountLabel;
    JTextField searchTextField;
    JRadioButton monthlyRadioButton, dailyRadioButton, yearlyRadioButton;
    ButtonGroup subsButtonsGroup;
    JTextArea textArea;
    public VisitorInfo(){
        this.setLayout(new BorderLayout(0,10));
        selections = new JPanel();
        selections.setLayout(new GridLayout(4,1,0,15));
        calculateSeniorsAndRegulars = new JPanel();
        calculateSeniorsAndRegulars.setLayout(new FlowLayout());




        regulars = new JCheckBox("Regular visitors");
        regulars.addActionListener(this);
        calculateSeniorsAndRegulars.add(regulars);

        seniors = new JCheckBox("Senior visitors");
        seniors.addActionListener(this);
        calculateSeniorsAndRegulars.add(seniors);

        calculateSeniorsAndRegularsLabel = new JLabel("   ");
        calculateSeniorsAndRegulars.add(calculateSeniorsAndRegularsLabel);


        //selections.add(new JLabel(""));
        selections.add(new JLabel(""));
        selections.add(calculateSeniorsAndRegulars);


        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(new JLabel("Visitor's ID"));
        searchTextField = new JTextField(10);
        searchPanel.add(searchTextField);
        searchButton = new JButton("Search by visitor ID");
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);

        selections.add(searchPanel);

        subsCountPanel = new JPanel();
        subsCountPanel.setLayout(new FlowLayout());
        dailyRadioButton = new JRadioButton("Daily");
        dailyRadioButton.addActionListener(this);
        monthlyRadioButton = new JRadioButton("Monthly");
        monthlyRadioButton.addActionListener(this);
        yearlyRadioButton = new JRadioButton("Yearly");
        yearlyRadioButton.addActionListener(this);
        subsButtonsGroup = new ButtonGroup();
        subsButtonsGroup.add(dailyRadioButton);
        subsButtonsGroup.add(monthlyRadioButton);
        subsButtonsGroup.add(yearlyRadioButton);
        subsCountLabel = new JLabel("    ");
        subsCountPanel.add(new JLabel("Total number of subs/visits: "));
        subsCountPanel.add(dailyRadioButton);
        subsCountPanel.add(monthlyRadioButton);
        subsCountPanel.add(yearlyRadioButton);
        subsCountPanel.add(subsCountLabel);

        selections.add(subsCountPanel);




        textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new FlowLayout());
        textArea = new JTextArea(22,80);
        textArea.setEditable(false);
        textAreaPanel.add(textArea);




        this.add(selections,BorderLayout.NORTH);
        this.add(textAreaPanel,BorderLayout.CENTER);

        RadioHandler radioHandler = new RadioHandler();
        dailyRadioButton.addActionListener(radioHandler);
        yearlyRadioButton.addActionListener(radioHandler);
        monthlyRadioButton.addActionListener(radioHandler);
        searchButton.addActionListener(e -> {
            try{
                int id = Integer.parseInt(searchTextField.getText().trim());
                int index = MyFrame.museumSystem.visitorIdIndexFinder(id);
                Visitor v;
                if(index >= 0){
                    v = MyFrame.museumSystem.getVisitors().get(index);
                    String s = "";
                    s += ("Information of visitor " + v.getName() +":\n");
                    s+= ("ID " + String.valueOf(v.getId())+"\n");
                    s+= ("Visitor ID " + String.valueOf(v.getvId())+"\n");
                    s+= ("Age "+ String.valueOf(Converter.ageCalculator(v.getDob()))+"\n");
                    s+= "Visit history:-\n";
                    for(VisitorRecord vr : v.getVisits()){
                        s+= vr.toString();
                        s+="\n";
                    }

                    textArea.setText(s);

                }
                else {

                    textArea.setText("This visitor isn't available!");
                    return;
                }
            }
            catch (Exception exception){
                exception.printStackTrace();
                textArea.setText("Please enter the ID as a valid number");
            }
        });

        //class MueseumBasics.RegularVisitor
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == regulars || e.getSource() == seniors){
            if(regulars.isSelected() && !seniors.isSelected())
                calculateSeniorsAndRegularsLabel.setText(String.valueOf(MyFrame.museumSystem.regularsCounter()));

            else if(seniors.isSelected() && !regulars.isSelected())
                calculateSeniorsAndRegularsLabel.setText(String.valueOf(MyFrame.museumSystem.seniorsCounter()));
            else if(seniors.isSelected() && regulars.isSelected())
                calculateSeniorsAndRegularsLabel.setText(String.valueOf(MyFrame.museumSystem.seniorsCounter()
                +MyFrame.museumSystem.regularsCounter()));
            else calculateSeniorsAndRegularsLabel.setText("   ");
        }
    }
    class RadioHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(dailyRadioButton.isSelected()) subsCountLabel.setText(String.valueOf(MyFrame.museumSystem.dailyCounter()));
            else if(monthlyRadioButton.isSelected()) subsCountLabel.setText(String.valueOf(MyFrame.museumSystem.monthlyCounter()));
            else if(yearlyRadioButton.isSelected()) subsCountLabel.setText(String.valueOf(MyFrame.museumSystem.yearlyCounter()));
            else subsCountLabel.setText("   ");
        }
    }
}
