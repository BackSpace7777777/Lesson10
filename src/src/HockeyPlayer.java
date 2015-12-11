package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import src.HockeyPlayerItems.Team;

public class HockeyPlayer {
    private Team[] teams=new Team[1];
    public HockeyPlayer()
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/src/HockeyPlayerItems/Players.txt")));
        String p;
        try
        {
            while((p=br.readLine())!=null)
            {
                
            }
        }
        catch(Exception ex){}
    }
    public void visible(boolean tf)
    {
        
    }
    private Object[] addToArray(Object[] array)
    {
        Object tempObject[]=new Object[array.length+1];
        for(int i=0;i<array.length;i++)tempObject[i]=array[i];
        array=new Object[tempObject.length];
        for(int i=0;i<tempObject.length;i++)array[i]=tempObject[i];
        return array;
    }
}
