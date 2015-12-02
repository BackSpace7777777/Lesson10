package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import src.Sorting.SortingMethods;

public class SortingAssignment extends Main{
    private JList list;
    private DefaultListModel ml;
    private JButton generate,bubble,exchange,insertion,quick,back,personArray;
    private JScrollPane js;
    private JTextField arraySize1,totalTime;
    private int[] numbers=new int[1];
    private Random r=new Random();
    private long start,end;
    private Thread t;
    public static JProgressBar jpb;
    private boolean sorting=false;
    public SortingAssignment()
    {
        personArray=new JButton();
        personArray.setBounds(315,40,150,30);
        personArray.setText("Person Array");
        personArray.setVisible(false);
        personArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visible(false);
                pa.visible(true);
            }
        });
        jpb=new JProgressBar();
        jpb.setBounds(160,320,300,20);
        jpb.setVisible(false);
        totalTime=new JTextField();
        totalTime.setBounds(315,5,150,30);
        totalTime.setVisible(false);
        totalTime.setEditable(false);
        arraySize1=new JTextField();
        arraySize1.setBounds(160,5,150,30);
        arraySize1.setVisible(false);
        arraySize1.setText("1");
        back=new JButton();
        back.setBounds(5,5,150,30);
        back.setText("Main Menu");
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(true);
            }
        });
        generate=new JButton();
        generate.setBounds(160,40,150,30);
        generate.setText("Generate");
        generate.setVisible(false);
        generate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sorting==false);
                {
                    try
                    {
                    sorting=true;
                    t=new Thread(new Runnable() {
                        public void run() {
                            start=System.currentTimeMillis();
                            try
                            {
                                numbers=new int[Integer.parseInt(arraySize1.getText())];
                                
                                reset();
                            }
                            catch(Exception ex){arraySize1.setText("1");numbers=new int[1];reset();}
                            end=System.currentTimeMillis();
                            totalTime.setText("Total Time(s): " + (end-start)/1000);
                            sorting=false;
                        }
                    });
                    t.start();
                    }
                    catch(Exception ex){System.out.println(ex);}
                }
            }
        });
        bubble=new JButton();
        bubble.setBounds(160,75,150,30);
        bubble.setText("Bubble Sort");
        bubble.setVisible(false);
        bubble.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sorting==false)
                {
                    sorting=true;
                    t=new Thread(new Runnable() {
                        public void run() {
                            start=System.currentTimeMillis();
                            SortingMethods.bubbleSort(numbers);
                            end=System.currentTimeMillis();
                            totalTime.setText("Total Time(s): " + (end-start)/1000);
                            reloadML();
                            sorting=false;
                        }
                    });
                    t.start();
                }
            }
        });
        exchange=new JButton();
        exchange.setBounds(160,110,150,30);
        exchange.setText("Exchange");
        exchange.setVisible(false);
        exchange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sorting==false)
                {
                    sorting=true;
                    t=new Thread(new Runnable() {
                        public void run() {
                            start=System.currentTimeMillis();
                            SortingMethods.selectionSort(numbers);
                            end=System.currentTimeMillis();
                            totalTime.setText("Total Time(s): " + (end-start)/1000);
                            reloadML();
                            sorting=false;
                        }
                    });
                    t.start();
                }
            }
        });
        insertion=new JButton();
        insertion.setBounds(160,145,150,30);
        insertion.setText("Insertion");
        insertion.setVisible(false);
        insertion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sorting==false)
                {
                    sorting=true;
                    t=new Thread(new Runnable() {
                        public void run() {
                            start=System.currentTimeMillis();
                            SortingMethods.insertionSort(numbers);
                            end=System.currentTimeMillis();
                            totalTime.setText("Total Time(s): " + (end-start)/1000);
                            reloadML();
                            sorting=false;
                        }
                    });
                    t.start();
                }
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
        frame.add(personArray);
        frame.add(js);
        frame.add(back);
        frame.add(generate);
        frame.add(bubble);
        frame.add(exchange);
        frame.add(insertion);
        frame.add(totalTime);
        frame.add(arraySize1);
        frame.add(jpb);
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
        generate.setVisible(tf);
        bubble.setVisible(tf);
        exchange.setVisible(tf);
        arraySize1.setVisible(tf);
        insertion.setVisible(tf);
        totalTime.setVisible(tf);
        personArray.setVisible(tf);
        jpb.setVisible(tf);
    }
    private void reloadML()
    {
        ml.removeAllElements();
        for(int i=0;i<numbers.length;i++)ml.addElement(numbers[i]);
        jpb.setMaximum(50);
        jpb.setValue(50);
    }
    private void reset()
    {
        jpb.setMaximum(numbers.length);
        jpb.setMinimum(0);
        for(int i=0;i<numbers.length;i++)
        {
            numbers[i]=r.nextInt(101);
            jpb.setValue(i);
        }
        reloadML();
    }
}
