/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.PersonArrayItems;
public class Person {
    private String name;
    private boolean gender;
    private byte age;
    public Person(String name,boolean gender,byte age)
    {
        this.name=name;
        this.gender=gender;
        this.age=age;
    }
    public String getName()
    {
        return name;
    }
    public boolean getGender()
    {
        return gender;
    }
    public byte getAge()
    {
        return age;
    }
}
