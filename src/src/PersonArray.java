package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PersonArray extends Main{
    private JMenuBar mb;
    private JMenu file,edit,sortBy;
    private JMenuItem add,remove,age,name;
    public PersonArray()
    {
        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        sortBy=new JMenu("Sort By");
        add=new JMenuItem("Add");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        remove=new JMenuItem("Remove"); 
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        age=new JMenuItem("Age");
        age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        name=new JMenuItem("Name");
        name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        edit.add(add);
        edit.add(remove);
        sortBy.add(age);
        sortBy.add(name);
        mb.add(file);
        mb.add(edit);
        mb.add(sortBy);
        mb.setVisible(false);
        frame.setJMenuBar(mb);
    }
    public void visible(boolean tf)
    {
        if(tf)
        {
            frame.setTitle("Lesson 10 - Person Array");
            frame.setSize(475,375);
        }
        mb.setVisible(tf);
    }
}
