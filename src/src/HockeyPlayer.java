package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import src.HockeyPlayerItems.Player;

public class HockeyPlayer extends Main{
    private Player[] players=new Player[1];
    private Player[] team;
    private DefaultListModel ml;
    private JScrollPane js;
    private JList list;
    private JTextArea info;
    private JMenu file,edit,filter;
    private JMenuItem showAll,showBySelectedTeam,deletePlayer;
    private JMenuBar mb;
    private boolean showAllB=true;
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
        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        filter=new JMenu("Filter");
        mb.add(file);
        mb.add(edit);
        mb.add(filter);
        mb.setVisible(false);
        showBySelectedTeam=new JMenuItem("Show by Selected Team");
        showBySelectedTeam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                team=showByTeam(players[list.getSelectedIndex()].getTeam());
                showAllB=false;
            }
        });
        showAll=new JMenuItem("Show All");
        showAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllB=true;
                showPlayers(players);
            }
        });
        filter.add(showAll);
        filter.add(showBySelectedTeam);
        deletePlayer=new JMenuItem("Delete Player");
        deletePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(showAllB)
                {
                    
                }
                else
                {
                    
                }
            }
        });
        ml=new DefaultListModel();
        list=new JList();
        js=new JScrollPane();
        list.setBounds(5,5,150,300);
        list.setVisible(false);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(showAllB)
                    showPlayer(list.getSelectedIndex(),players);
                else
                    showPlayer(list.getSelectedIndex(),team);
            }
        });
        list.setModel(ml);
        js.setViewportView(list);
        js.setVisible(false);
        js.setBounds(list.getBounds());
        showPlayers(players);
        info=new JTextArea();
        info.setBounds(160,5,350,300);
        info.setBorder(BorderFactory.createEtchedBorder());
        info.setVisible(false);
        info.setEditable(false);
        frame.add(info);
        frame.add(js);
        frame.setJMenuBar(mb);
    }
    public void visible(boolean tf)
    {
        frame.setTitle("Lesson 10 - Hockey Players");
        frame.setSize(520,375);
        list.setVisible(tf);
        js.setVisible(tf);
        mb.setVisible(tf);
        info.setVisible(tf);
    }
    private Player[] deletePlayer(int i,Player[] array)
    {
        Player[] tempPlayer=new Player[array.length-1];
        return tempPlayer;
    }
    private Player[] showByTeam(String team)
    {
        Player[] tempPlayers=new Player[1];
        int index=0;
        for(int i=0;i<players.length;i++)
        {
            if(players[i].getTeam().equals(team))
            {
                try
                {
                    tempPlayers[index]=new Player(players[i].getName(),players[i].getTeam(),players[i].getPos(),players[i].getSal(),players[i].getWeight());
                }catch(ArrayIndexOutOfBoundsException ex)
                {
                    tempPlayers=addToArray(tempPlayers);
                    tempPlayers[index]=new Player(players[i].getName(),players[i].getTeam(),players[i].getPos(),players[i].getSal(),players[i].getWeight());
                }
                index++;
            }
        }
        showPlayers(tempPlayers);
        return tempPlayers;
    }
    private void showPlayers(Player[] p)
    {
        ml.removeAllElements();
        for(int i=0;i<p.length;i++)
        {
            ml.addElement(p[i].getName());
        }
    }
    private void showPlayer(int i,Player[] array)
    {
        try
        {
            info.setText(array[i].getName());
            info.append("\n-------------------------------\n");
            info.append(array[i].getName() + " plays for the " + array[i].getTeam());
            info.append("\n" + array[i].getName() + " has the position of " + array[i].getPos());
            info.append("\n" + array[i].getName() + " has a weight of " + Math.round(array[i].getWeight()) + "lb or " + Math.round(array[i].getWeight()*0.453592) + "kg");
        }
        catch(Exception ex){}
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
