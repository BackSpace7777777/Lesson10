package src.HockeyPlayerItems;
public class Player{
    private String name,team,pos;
    private long sal;
    private double weight;
    public Player(String name,String team,String pos,long sal,double weight)
    {
        this.name=name;
        this.team=team;
        this.pos=pos;
        this.sal=sal;
        this.weight=weight;
    }
    public double getWeight()
    {
        return weight;
    }
    public long getSal()
    {
        return sal;
    }
    public String getName()
    {
        return name;
    }
    public String getTeam()
    {
        return team;
    }
    public String getPos()
    {
        return pos;
    }
}
