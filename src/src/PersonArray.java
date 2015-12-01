package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PersonArray extends Main{
    private JMenuBar mb;
    private JMenu file,edit;
    private JMenuItem add,remove;
    public PersonArray()
    {
        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
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
        edit.add(add);
        mb.add(file);
        mb.add(edit);
        frame.setJMenuBar(mb);
    }
    public void visible(boolean tf)
    {
        frame.setJMenuBar(mb);
    }
}
