package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
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
}
