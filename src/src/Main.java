package src;

import src.StudentFinder.Student;
import src.StudentFinder.StudentReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main{
    public static JFrame frame=new JFrame("Lesson 10 - Student Finder");
    private static JButton searchButton,sortScreen;
    private static JTextField inID;
    private static JTextArea out;
    private static StudentReader sr;
    private static Student[] s=new Student[100];
    protected static SortingAssignment sa;
    protected static PersonArray pa;
    protected static HockeyPlayer hp;
    public static void main(String[] args) {
        sr=new StudentReader();
        s=sr.loadStudents(s);
        frame.setSize(475,375);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLayout(null);
        sortScreen=new JButton();
        sortScreen.setBounds(315,5,150,30);
        sortScreen.setText("Sorting");
        sortScreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(false);
            }
        });
        searchButton=new JButton();
        searchButton.setBounds(5,5,150,30);
        searchButton.setText("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long tempL=-1;
                try{
                    tempL=Long.parseLong(inID.getText());
                }
                catch(NumberFormatException ex){}
                if(tempL==-1)
                {
                    out.setText(tempL + " Not found");
                }
                else
                {
                    try
                    {
                        int person=search(s,tempL);
                        out.setText(s[person].getName());
                        out.append("\n" + s[person].getAddress());
                        out.append("\n" + s[person].getID());
                    }
                    catch(ArrayIndexOutOfBoundsException ex)
                    {
                        out.setText("Not found");
                    }
                }
            }
        });
        inID=new JTextField();
        inID.setBounds(160,5,150,30);
        out=new JTextArea();
        out.setEditable(false);
        out.setBounds(5,40,460,300);
        sa=new SortingAssignment();
        pa=new PersonArray();
        hp=new HockeyPlayer();
        frame.add(sortScreen);
        frame.add(out);
        frame.add(inID);
        frame.add(searchButton);
        frame.setVisible(true);
    }
    public static int search (Student[] a, long searchValue){
       int left = 0;
       int right = a.length-1;
       while (left <= right){
          int midpoint = (left + right) / 2;
          int result = (a[midpoint]).compareTo(searchValue); 
          if (result == 0)
             return midpoint;
          else if (result < 0)
             left = midpoint + 1;
          else
             right = midpoint-1;
       }
       return -1;	   
    }
    public static void mainVisible(boolean tf)
    {
        frame.setTitle("Lesson 10 - Student Finder");
        frame.setSize(475,375);
        out.setVisible(tf);
        inID.setVisible(tf);
        searchButton.setVisible(tf);
        sortScreen.setVisible(tf);
        if(tf)sa.visible(false);
        else sa.visible(true);
    }
}
