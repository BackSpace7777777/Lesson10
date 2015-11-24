package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class StudentReader {
    private String[] names=new String[1],address=new String[1],id=new String[1];
    private int whileIndex=0;
    public StudentReader()
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(
    getClass().getResourceAsStream("/src/students.txt")));
            String o,t,tt;
            for(int i=0;i<100;i++)
            {
                o=br.readLine();
                t=br.readLine();
                tt=br.readLine();
                try
                {
                    names[i]=o;
                }catch(ArrayIndexOutOfBoundsException ex)
                {
                    names=addToStringArray(names);
                    names[i]=o;
                }
                try
                {
                    address[i]=t;
                }
                catch(ArrayIndexOutOfBoundsException ex)
                {
                    address=addToStringArray(address);
                    address[i]=t;
                }
                try
                {
                    id[i]=tt;
                }
                catch(ArrayIndexOutOfBoundsException ex)
                {
                    id=addToStringArray(id);
                    id[i]=tt;
                }
            }
        }
        catch(IOException ex){System.out.println(ex);}
    }
    public long getID(int index)
    {
        return Long.parseLong(id[index]);
    }
    public String getAddress(int index)
    {
        return address[index];
    }
    public String getName(int index)
    {
        return names[index];
    }
    private String[] addToStringArray(String[] array)
    {
        String temp[]=new String[array.length+1];
        for(int i=0;i<array.length;i++)
        {
            temp[i]=array[i];
        }
        array=new String[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            array[i]=temp[i];
        }
        return array;
    }
}
