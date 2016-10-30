package com.example.jonelezhang.contactmanager;

import java.util.UUID;

/**
 * Created by Shadow on 10/29/16.
 */

public class Contact implements Comparable {

    private String id = "";

    private String firstName = "";
    private String lastName = "";
    private String phoneNumber = "";
    private String email = "";

    public Contact() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object o) {
        if (this.hashCode() == o.hashCode()) { return true; }
        return false;
    }

    public Contact clone() {
        Contact newContact = new Contact();
        newContact.setId(this.getId());
        newContact.setFirstName(this.firstName);
        newContact.setLastName(this.lastName);
        newContact.setEmail(this.email);
        newContact.setPhoneNumber(this.phoneNumber);
        return newContact;
    }

    @Override
    public int compareTo(Object o) {
        Contact that = (Contact) o;
        String thisNameString = this.getFirstName() + this.getLastName();
        String thatnameStirng = that.getFirstName() + that.getLastName();
        return (thisNameString).compareTo(thatnameStirng);
    }

}
