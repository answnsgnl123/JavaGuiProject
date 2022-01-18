package com.makegui.moon;

import javax.naming.Name;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Screen extends JFrame{
    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JList listPeople;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JTextField NametextField;
    private JTextField PhonetextField;
    private JTextField EmailtextField;
    private JTextField DobtextField;
    private JTextField upEmailtextField;
    private JLabel LabelAge;
    private JPanel panelMain;
    private JLabel LabelYears;
    private ArrayList<Person> people;
    private DefaultListModel listPeopleModel;


    Screen() {
        super("My ProJect");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        people = new ArrayList<Person>();
        listPeopleModel = new DefaultListModel();
        listPeople.setModel(listPeopleModel);
        saveNewButton.setEnabled(false);




        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Person p = new Person(
                            NametextField.getText(),
                            upEmailtextField.getText(),
                            PhonetextField.getText(),
                            DobtextField.getText()
                    );
                    people.add(p);
                    refreshPeopleList();
            }
        });
        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int personNumber = listPeople.getSelectedIndex();
                if (personNumber >= 0){
                    Person p = people.get(personNumber);
                    p.setName(NametextField.getText());
                    p.setEmail(upEmailtextField.getText());
                    p.setPhoneNumber(PhonetextField.getText());
                    p.setDate0fBirth(DobtextField.getText());
                    refreshPeopleList();

                }

            }
        });
        listPeople.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int personNumber = listPeople.getSelectedIndex();
                if (personNumber >= 0) {
                    Person p = people.get(personNumber);
                    NametextField.setText(p.getName());
                    upEmailtextField.setText(p.getEmail());
                    PhonetextField.setText(p.getPhoneNumber());
                    DobtextField.setText(p.getDate0fBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    LabelYears.setText(Integer.toString(p.getAge()) + "Years");

                    saveNewButton.setEnabled(true);
                }
                else{
                    saveNewButton.setEnabled(false);
                }
            }
        });


    }
    public void refreshPeopleList() {
        listPeopleModel.removeAllElements();
        System.out.println("Remove");
        for (Person p : people) {
            System.out.println("add list person" + p.getName());
            listPeopleModel.addElement(p.getName());
        }
    }
    public void addPerson(Person p){
        people.add(p);
        refreshPeopleList();
    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);

        Person shyun = new Person("박성현","shyun@gmail.com","0010-5012-9229","01/01/1999");
        Person jeonge = new Person("최정은","jeonge@gmail.com","0010-6369-0068","01/01/1999");
        Person Jun = new Person("문준휘","Moon@gmail.com","010-9876-1779","01/01/1999");

        screen.addPerson(shyun);
        screen.addPerson(jeonge);
        screen.addPerson(Jun);
    }
}
