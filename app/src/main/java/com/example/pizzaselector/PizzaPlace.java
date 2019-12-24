package com.example.pizzaselector;


import java.net.MalformedURLException;
import java.net.URL;

public class PizzaPlace {
    private String name;
    private String phoneNum;
    private String website;
    private URL siteLink;

    /**
     * Constructor for PizzaPlace that accepts all
     * 3 data values
     * @param _name Name of the store
     * @param _phoneNum Phone number for the store
     * @param _website Website for the store
     */
    public PizzaPlace(String _name, String _phoneNum, String _website){
        this.name = _name;
        this.phoneNum = _phoneNum;
        this.website = _website;
    }

    /**
     * Constructor for PizzaPlace that accepts
     * 2 of the 3 values
     * @param _name Name of store
     * @param _phoneNum Phone number of store
     */
    public PizzaPlace(String _name, String _phoneNum){
        this.name = _name;
        this.phoneNum = _phoneNum;
        this.website = "";
    }

    /**
     * Getter for name
     * @return name : name of store
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for phoneNum
     * @return phoneNum : the phone number for the store
     */
    public String getPhoneNum(){
        return phoneNum;
    }

    /**
     * Getter for website
     * @return website : the website for the store
     */
    public String getWebSite(){
        return website;
    }

    public void setURL(String _URL) {
        try {
            siteLink = new URL(getWebSite());
        }catch(MalformedURLException MURLE){
            System.out.println("Invalid link");
            MURLE.printStackTrace();
        }
    }

    public URL getURL(){
        return siteLink;
    }

    public String toString(){
        if(website.equals("")){
            String s = "Name: "+getName()+" Phone: "+getPhoneNum();
            return s;
        }
        String s = "Name: " + getName() + "\n Phone: " + getPhoneNum() + "\n Website: " + getWebSite();
        return s;
    }

}
