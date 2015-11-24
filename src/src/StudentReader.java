package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class StudentReader {
    private String[] names=new String[1],address=new String[1],id=new String[1];
    private int whileIndex=0;
    private FileReader fr;
    private BufferedReader br;
    public StudentReader()
    {
        try
        {
            fr=new FileReader("Students.txt");
            br=new BufferedReader(fr);
            for(int i=0;i<100;i++)
            {
                names[i]=br.readLine();
                address[i]=br.readLine();
                id[i]=br.readLine();
                names=addToStringArray(names);
                address=addToStringArray(address);
                id=addToStringArray(id);
            }
        }
        catch(IOException ex){System.out.println("30 " + ex);}
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
