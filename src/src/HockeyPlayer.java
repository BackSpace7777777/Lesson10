package src;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import src.HockeyPlayerItems.Player;

public class HockeyPlayer extends Main{
    private Player[] players=new Player[1];
    private DefaultListModel ml;
    private JScrollPane js;
    private JList list;
    private JTextArea info;
    public HockeyPlayer()
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/src/HockeyPlayerItems/Players.txt")));
        String p;
        String tempName,tempTeam,tempPos;
        long tempSal;
        double tempWeight;
        try
        {
            while((p=br.readLine())!=null)
            {
                tempName=p.split(",")[0];
                tempTeam=p.split(",")[1];
                tempPos=p.split(",")[2];
                tempSal=Long.parseLong(p.split(",")[3]);
                tempWeight=Double.parseDouble(p.split(",")[4]);
                addPlayer(tempName,tempTeam,tempPos,tempSal,tempWeight);
            }
        }
        catch(Exception ex){}
        ml=new DefaultListModel();
        list=new JList();
        js=new JScrollPane();
        list.setBounds(5,5,150,300);
        list.setVisible(false);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                showPlayer(list.getSelectedIndex());
            }
        });
        list.setModel(ml);
        js.setViewportView(list);
        js.setVisible(false);
        js.setBounds(list.getBounds());
        for(int i=0;i<players.length;i++)ml.addElement(players[i].getName());
        info=new JTextArea();
        info.setBounds(160,5,200,300);
        info.setBorder(BorderFactory.createEtchedBorder());
        info.setVisible(false);
        info.setEditable(false);
        frame.add(info);
        frame.add(js);
    }
    public void visible(boolean tf)
    {
        frame.setTitle("Lesson 10 - Hockey Players");
        list.setVisible(tf);
        js.setVisible(tf);
        info.setVisible(tf);
    }
    private void showPlayer(int i)
    {
        info.setText(players[i].getName());
        info.append("\n-------------------------------");
    }
    private void addPlayer(String n,String t,String p,long s,double w)
    {
        boolean hasNullSpot=false;
        int index=-1;
        for(int i=0;i<players.length;i++)
        {
            if(players[i]==null)
            {
                hasNullSpot=true;
                index=i;
            }
        }
        if(hasNullSpot)
        {
            players[index]=new Player(n,t,p,s,w);
        }
        else
        {
            players=addToArray(players);
            players[players.length-1]=new Player(n,t,p,s,w);
        }
    }
    private Player[] addToArray(Player[] array)
    {
        Player tempObject[]=new Player[array.length+1];
        for(int i=0;i<array.length;i++)tempObject[i]=array[i];
        array=new Player[tempObject.length];
        for(int i=0;i<tempObject.length;i++)array[i]=tempObject[i];
        return array;
    }
}
