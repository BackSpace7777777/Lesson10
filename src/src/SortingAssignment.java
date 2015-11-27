package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class SortingAssignment extends Main{
    private JList list;
    private DefaultListModel ml;
    private JButton generate,bubble,exchange,insertion,quick,back;
    private JScrollPane js;
    public SortingAssignment()
    {
        back=new JButton();
        back.setBounds(5,5,150,30);
        back.setText("Main Menu");
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(true);
            }
        });
        ml=new DefaultListModel();
        list=new JList();
        js=new JScrollPane();
        list.setBounds(5,5,150,250);
        list.setVisible(false);
        list.setModel(ml);
        js.setViewportView(list);
        js.setVisible(false);
        js.setBounds(list.getBounds());
        for(int i=0;i<199;i++)
        ml.addElement("Lol");
        frame.add(js);
        frame.add(list);
    }
    public void visible(boolean tf)
    {
        if(tf)
        {
            frame.setTitle("Lesson 10 - Sorting");
        }
        js.setVisible(tf);
        list.setVisible(tf);
        back.setVisible(tf);
    }
    
}
