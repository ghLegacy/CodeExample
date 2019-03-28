package com.ghlegacy.codesample;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 
 * @author Mkhair
 */
public class Person
{
       private String givenName;
       private String surName;
       private int age;
       private String phone;
       private String address;
    
     /**
     * Access method for the givenName property.
     * 
     * @return   the current value of the givenName property
     */
    public String getGivenName()
    {
        return this.givenName;
    }
    
    /**
     * Sets the value of the givenName property.
     * 
     * @param givenName the new value of the givenName property
     */
    public void setGivenName( String aGivenName )
    {
        this.givenName = aGivenName;
    }
    
    /**
     * Access method for the surName property.
     * 
     * @return   the current value of the surName property
     */
    public String getSurName()
    {
        return this.surName;
    }
    
    /**
     * Sets the value of the surName property.
     * 
     * @param surName the new value of the surName property
     */
    public void setSurName( String aSurName )
    {
        this.surName = aSurName;
    }
    
    /**
     * Access method for the age property.
     * 
     * @return   the current value of the age property
     */
    public int getAge()
    {
        return this.age;
    }
    
    /**
     * Sets the value of the age property.
     * 
     * @param age the new value of the age property
     */
    public void setAge( int aAge )
    {
        this.age = aAge;
    }
    
    /**
     * Access method for the phone property.
     * 
     * @return   the current value of the phone property
     */
    public String getPhone()
    {
        return this.phone;
    }
    
    /**
     * Sets the value of the phone property.
     * 
     * @param phone the new value of the phone property
     */
    public void setPhone( String aPhone )
    {
        this.phone = aPhone;
    }
    
    /**
     * Access method for the address property.
     * 
     * @return   the current value of the address property
     */
    public String getAddress()
    {
        return this.address;
    }
    
    /**
     * Sets the value of the address property.
     * 
     * @param address the new value of the address property
     */
    public void setAddress( String aAddress )
    {
        this.address = aAddress;
    }
    
    /**
     * @return
     */
    public static List<Person> createShortList()
    {
        List<Person> personList = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setGivenName( "GivenName" );
        p1.setAddress( "Address" );
        p1.setPhone( "1234" );
        p1.setSurName( "Blue" );
        
        personList.add( p1 );
        
        Person p2 = new Person();
        p2.setGivenName( "GivenName" );
        p2.setAddress( "Address" );
        p2.setPhone( "1234" );
        p2.setSurName( "Red" );
        personList.add( p2 );
        return personList;
    }
    
    public void printName()
    {
        System.out.println( "Your name is tex" );
        
    }
}
