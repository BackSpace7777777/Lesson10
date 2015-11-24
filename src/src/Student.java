package src;
public class Student {
    private String name,address;
    private long ID;
    public Student(String name,String address,long ID)
    {
        this.name=name;
        this.address=address;
        this.ID=ID;
    }
    public long getID()
    {
        return ID;
    }
    public String getAddress()
    {
        return address;
    }
    public String getName()
    {
        return name;
    }
}
