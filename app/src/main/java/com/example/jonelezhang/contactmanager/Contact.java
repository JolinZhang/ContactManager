package com.example.jonelezhang.contactmanager;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Shadow on 10/29/16.
 */

public class Contact implements Comparable,Serializable{

    private String id = "";

    private String firstName = "";
    private String lastName = "";
    private String phoneNumber = "";
    private String email = "";

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public Contact() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public String getId() {
        return id;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public String getEmail() {
        return email;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Author: zxq150130 - Zengtai Qi
     * @return The hashCode of id string. (Working with equals() method making sure Contact can be stored correctly in HashSet.)
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @param o Another Contact instance.
     * @return Whether the two objects equal to each other. (Working with hashCode() method making sure Contact can be stored correctly in HashSet.)
     */
    public boolean equals(Object o) {
        if (this.hashCode() == o.hashCode()) { return true; }
        return false;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @return Another Contact instance with exactly same content (including id).
     */
    public Contact clone() {
        Contact newContact = new Contact();
        newContact.setId(this.getId());
        newContact.setFirstName(this.firstName);
        newContact.setLastName(this.lastName);
        newContact.setEmail(this.email);
        newContact.setPhoneNumber(this.phoneNumber);
        return newContact;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @param o Another Contact instance.
     * @return Deciding the order of objects in sorting.
     */
    @Override
    public int compareTo(Object o) {
        Contact that = (Contact) o;
        //  Use first name and last name in sorting.
        String thisNameString = this.getFirstName() + this.getLastName();
        String thatnameStirng = that.getFirstName() + that.getLastName();
        return (thisNameString).compareTo(thatnameStirng);
    }

}
