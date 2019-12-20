package com.example.pizzaselector;


public class PizzaPlace {
    private String name;
    private String phoneNum;
    private String website;

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

    /**
     * Sets the name of the pizza place
     * @param _newName new name to be entered
     */
    public void setName(String _newName){
        this.name = _newName;
    }

    /**
     * Sets the phone number of the pizza place
     * @param _newPhoneNum new phone number for the pizza place
     */
    public void setPhoneNum(String _newPhoneNum){
        this.phoneNum = _newPhoneNum;
    }

    /**
     * Sets the website of the pizza place
     * @param _newWebsite new website for the pizza place
     */
    public void setWebsite(String _newWebsite){
        this.website = _newWebsite;
    }

    public String toString(){
        if(website.equals("")){
            String s = "Name: "+getName()+" Phone: "+getPhoneNum();
            return s;
        }
        String s= "Name: "+getName()+" Phone: "+getPhoneNum()+" Website: "+getWebSite();
        return s;
    }

}
