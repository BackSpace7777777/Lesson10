package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import src.PersonArrayItems.Person;

public class PersonArray extends Main{
    private JMenuBar mb;
    private JMenu file,edit,sortBy;
    private JMenuItem add,remove,age,name,clear;
    private Person[] people=new Person[1];
    private JList list;
    private DefaultListModel ml;
    private JScrollPane js;
    private JButton back;
    private JTextField ageF,nameF;
    private JLabel ageL,nameL;
    private JRadioButton male,female;
    public PersonArray()
    {
        people[0]=null;
        nameF=new JTextField();
        nameF.setBounds(210,135,150,30);
        nameF.setVisible(false);
        ageF=new JTextField();
        ageF.setBounds(210,100,150,30);
        ageF.setVisible(false);
        ageL=new JLabel();
        ageL.setBounds(160,100,50,30);
        ageL.setText("Age:");
        ageL.setVisible(false);
        nameL=new JLabel();
        nameL.setBounds(160,135,50,30);
        nameL.setText("Name:");
        nameL.setVisible(false);
        male=new JRadioButton();
        male.setSelected(true);
        male.setBounds(160,310,60,30);
        male.setText("Male");
        male.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                male.setSelected(true);
                female.setSelected(false);
            }
        });
        male.setVisible(false);
        female=new JRadioButton();
        female.setBounds(220,310,120,30);
        female.setText("Female");
        female.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                female.setSelected(true);
                male.setSelected(false);
            }
        });
        female.setVisible(false);
        back=new JButton();
        back.setBounds(5,5,150,30);
        back.setText("Back");
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visible(false);
                mainVisible(true);
            }
        });
        ml=new DefaultListModel();
        list=new JList();
        js=new JScrollPane();
        list.setBounds(5,40,150,300);
        list.setVisible(false);
        list.setModel(ml);
        js.setViewportView(list);
        js.setVisible(false);
        js.setBounds(list.getBounds());
        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        sortBy=new JMenu("Sort By");
        add=new JMenuItem("Add");
        add.setIcon(new ImageIcon(PersonArray.class.getResource("/src/PersonArrayItems/Add.png")));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    addPerson(nameF.getText(),Byte.parseByte(ageF.getText()),male.isSelected());
                }
                catch(NumberFormatException ex){}
            }
        });
        remove=new JMenuItem("Remove"); 
        remove.setIcon(new ImageIcon(PersonArray.class.getResource("/src/PersonArrayItems/Delete.png")));
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        age=new JMenuItem("Age");
        age.setIcon(new ImageIcon(PersonArray.class.getResource("/src/PersonArrayItems/SortAge.png")));
        age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        name=new JMenuItem("Name");
        name.setIcon(new ImageIcon(PersonArray.class.getResource("/src/PersonArrayItems/SortName.png")));
        name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sorting();
                refreshToML();
            }
        });
        clear=new JMenuItem("Delete All");
        clear.setIcon(new ImageIcon(PersonArray.class.getResource("/src/PersonArrayItems/Clear.png")));
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                people=new Person[1];
                people[0]=null;
                refreshToML();
            }
        });
        file.add(clear);
        edit.add(add);
        edit.add(remove);
        sortBy.add(age);
        sortBy.add(name);
        mb.add(file);
        mb.add(edit);
        mb.add(sortBy);
        frame.add(back);
        frame.add(js);
        frame.add(male);
        frame.add(ageL);
        frame.add(female);
        frame.add(nameL);
        frame.add(ageF);
        frame.add(nameF);
        mb.setVisible(false);
        frame.setJMenuBar(mb);
    }
    private void addPerson(String name,byte age,boolean gender)
    {
        int index=-1;
        for(int i=0;i<people.length;i++)
        {
            if(people[i]==null)
            {
                index=i;
                break;
            }
        }
        if(index!=-1)
        {
            people[index]=new Person(name,gender,age);
            System.out.println(index + " if");
        }
        else
        {
            addingToPeople();
            people[people.length-1]=new Person(name,gender,age);
            System.out.println(people.length + " else");
        }
        refreshToML();
    }
    private void refreshToML()
    {
        try
        {
            ml.removeAllElements();
            for(int i=0;i<people.length;i++)
            {
                ml.addElement(people[i].getName());
            }
        }
        catch(NullPointerException ex){}
    }
    private void addingToPeople()
    {
        Person[] temp=new Person[people.length+1];
        for(int i=0;i<people.length;i++)temp[i]=people[i];
        people=new Person[temp.length];
        for(int i=0;i<temp.length;i++)people[i]=temp[i];
    }
    public void visible(boolean tf)
    {
        if(tf)
        {
            frame.setTitle("Lesson 10 - Person Array");
            frame.setSize(475,400);
        }
        list.setVisible(tf);
        mb.setVisible(tf);
        js.setVisible(tf);
        back.setVisible(tf);
        male.setVisible(tf);
        female.setVisible(tf);
        ageL.setVisible(tf);
        nameL.setVisible(tf);
        ageF.setVisible(tf);
        nameF.setVisible(tf);
    }
    private void sorting()
    {
        String temp[]=new String[people.length];
        for(int i=0;i<temp.length;i++)temp[i]=people[i].getName();
        Arrays.sort(temp);
        for(int i=0;i<temp.length;i++)
        {
            
        }
    }
}
