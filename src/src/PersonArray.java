package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
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
    public PersonArray()
    {
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
                
            }
        });
        clear=new JMenuItem("Delete All");
        clear.setIcon(new ImageIcon(PersonArray.class.getResource("/src/PersonArrayItems/Clear.png")));
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                people=new Person[1];
                people[0]=null;
                
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
        mb.setVisible(false);
        frame.setJMenuBar(mb);
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
        mb.setVisible(tf);
        js.setVisible(tf);
        back.setVisible(tf);
    }
}
