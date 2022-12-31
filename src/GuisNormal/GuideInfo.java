package GuisNormal;

import DateUtilities.Date;
import DateUtilities.Day;
import MueseumBasics.Guide;
import MueseumBasics.Visitor;
import MueseumBasics.VisitorRecord;
import MyUtilities.Converter;
import MyUtilities.Language;

import javax.swing.*;
import java.awt.*;

public class GuideInfo extends JPanel {
    JPanel finds;
    JPanel textAreaPanel;
    JPanel searchPanel, daySearchPanel, langSearchPanel;
    JButton searchButton, listByDayBut, listByLangBut;
    JTextField searchTextField;
    JTextArea textArea;
    JComboBox<String> langs;
    JComboBox<String> days;
    String[] lnagsArray = {"English", "Arabic", "Russian", "Spanish"};
    String[] daysArray = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"};

    public GuideInfo() {

        this.setLayout(new BorderLayout());


        finds = new JPanel();
        finds.setLayout(new GridLayout(3, 1));

        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchButton = new JButton("Search by Employee ID");
        searchTextField = new JTextField(9);
        searchPanel.add(new JLabel("Employee ID"));
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        finds.add(searchPanel);

        daySearchPanel = new JPanel();
        daySearchPanel.setLayout(new FlowLayout());
        daySearchPanel.add(new JLabel("Guide's working days: "));
        days = new JComboBox<String>(daysArray);
        daySearchPanel.add(days);
        listByDayBut = new JButton("List all available guides");
        daySearchPanel.add(listByDayBut);

        finds.add(daySearchPanel);

        langSearchPanel = new JPanel();
        langSearchPanel.setLayout(new FlowLayout());
        langSearchPanel.add(new JLabel("Language"));
        langs = new JComboBox<String>(lnagsArray);
        langSearchPanel.add(langs);
        listByLangBut = new JButton("List all guides");
        langSearchPanel.add(listByLangBut);

        finds.add(langSearchPanel);

        textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new FlowLayout());
        textArea = new JTextArea(22, 80);
        textArea.setEditable(false);
        textAreaPanel.add(textArea);


        this.add(finds, BorderLayout.NORTH);
        this.add(textAreaPanel, BorderLayout.CENTER);

        searchButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(searchTextField.getText().trim());
                int index = MyFrame.museumSystem.guideIdIndexFinder(id);
                Guide g;

                if (index >= 0) {

                    g = MyFrame.museumSystem.getGuides().get(index);
                    System.out.println(g.getDob().toDateString());
                    Date d = g.getDob();
                    int age = Converter.ageCalculator(g.getDob());
                    String s = "";
                    s = s.concat("Guide's name: " + g.getName() + "\n");
                    s = s.concat("Age " + age + "\n");
                    s = s.concat("Employment ID " + String.valueOf(g.geteId()) + "\n");
                    s = s.concat("Hire date: " + d.toDateString() + "\n");
                    s = s.concat("Maximum number of tours " + String.valueOf(g.getToursPerDay()) + "\n");

                    s += "Spoken languages:  ";
                    for (Language l : g.getLanguages()) {
                        s += String.valueOf(l);
                        s += " ";
                    }

                    s = s.concat("\n");
                    textArea.setText(s);

                } else {
                    textArea.setText("This guide isn't available!");
                    return;
                }
            } catch (Exception exception) {
                textArea.setText("Please enter the ID as a valid number");
                //exception.printStackTrace();
            }
        });
        listByLangBut.addActionListener(e -> {
           String string = langs.getSelectedItem().toString().trim();
           String s = "A List of guides who speak " + string +": \n";
            int count = 0;
           for(Guide g : MyFrame.museumSystem.getGuides()){
               if(g.getLanguages().contains(Language.stringToLanguage(string))){
                   s = s.concat(String.valueOf(++count) + "- ");
                   s = s.concat(g.getName());
                   s = s.concat("  ");
                   s = s.concat(String.valueOf(g.geteId()));
                   s= s.concat("\n");
               }
           }

           textArea.setText(s);
        });

        listByDayBut.addActionListener(e -> {
            String string = days.getSelectedItem().toString().trim();
            String s = "A List of guides on " + string +": \n";
            int count = 0;
            for(Guide g : MyFrame.museumSystem.getGuides()){
                if(g.getDaysOfWork().contains(Day.valueOf(string.toUpperCase()))){
                    s = s.concat(String.valueOf(++count) + "- ");
                    s = s.concat(g.getName());
                    s = s.concat("  ");
                    s = s.concat(String.valueOf(g.geteId()));
                    s= s.concat("\n");
                }
            }

            textArea.setText(s);
        });

    }
}
