package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main implements Comparable{
    public static JFrame frame=new JFrame("Searching program");
    private static JButton searchButton;
    private static JTextField inID;
    private static JTextArea out;
    private static StudentReader sr;
    private static Student[] s=new Student[100];
    public static void main(String[] args) {
        sr=new StudentReader();
        s=sr.loadStudents(s);
        frame.setSize(375,375);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLayout(null);
        searchButton=new JButton();
        searchButton.setBounds(5,5,150,30);
        searchButton.setText("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long tempL=Long.parseLong(inID.getText());
                int temp=search(s,tempL);
                if(temp==-1)
                {
                    out.setText(tempL + " Not found");
                }
                else
                {
                    out.setText(s[temp].getName());
                }
            }
        });
        inID=new JTextField();
        inID.setBounds(160,5,150,30);
        out=new JTextArea();
        out.setEditable(false);
        out.setBounds(5,40,360,300);
        frame.add(out);
        frame.add(inID);
        frame.add(searchButton);
        frame.setVisible(true);
    }
    public static int search (Object[] a, Object searchValue){
	   int left = 0;
	   int right = a.length-1;
	   while (left <= right){
	      int midpoint = (left + right) / 2;
	      int result = ((Comparable)a[midpoint]).compareTo(searchValue); 
	      if (result == 0)
	         return midpoint;
	      else if (result < 0)
	         left = midpoint + 1;
	      else
	         right = midpoint-1;
	   }
	   return -1;	   
    }
    public int compareTo(Object o) {
        
    }
}
