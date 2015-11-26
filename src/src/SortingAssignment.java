package src;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class SortingAssignment extends Main{
    private JList list;
    private DefaultListModel ml;
    private JButton generate,bubble,exchange,insertion,quick;
    public SortingAssignment()
    {
        list=new JList();
        list.setBounds(5,5,150,250);
        list.setVisible(false);
        frame.add(list);
    }
    public void visible(boolean tf)
    {
        list.setVisible(tf);
    }
    
}
