package com.example.jonelezhang.contactmanager;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContactsManagerTest {

    private Contact shane;
    private Contact jolin;
    private Contact michael;


    @Before
    public void setUp() {
        shane = new Contact();
        shane.setFirstName("Shane");
        shane.setLastName("Qi");
        shane.setPhoneNumber("4698453217");
        shane.setEmail("qizengtai@gmail.com");

        jolin = new Contact();
        jolin.setFirstName("Jolin");
        jolin.setLastName("Zhang");
        jolin.setPhoneNumber("2146420217");
        jolin.setEmail("zhangru0026@gmail.com");

        michael = new Contact();
        michael.setFirstName("Michael");
        michael.setLastName("Bluth");
        michael.setPhoneNumber("911");
        michael.setEmail("michael@icloud.com");

        ContactsManager.getInstance().clearForTesting();
        ContactsManager.getInstance().insertOrUpdate(shane);
        ContactsManager.getInstance().insertOrUpdate(jolin);
        ContactsManager.getInstance().insertOrUpdate(michael);

    }

    @Test
    public void getContactsTest() throws Exception {

        ArrayList<Contact> list = ContactsManager.getInstance().getContacts();

        assertEquals(jolin.getId(), list.get(0).getId());
        assertEquals(michael.getId(), list.get(1).getId());
        assertEquals(shane.getId(), list.get(2).getId());

    }

    @Test
    public void insertOrUpdateTest() throws Exception {
        ContactsManager.getInstance().insertOrUpdate(new Contact());

        assertEquals(4, ContactsManager.getInstance().getContacts().size());

        Contact clone = shane.clone();
        clone.setFirstName("fake shane");
        ContactsManager.getInstance().insertOrUpdate(clone);

        assertEquals(4, ContactsManager.getInstance().getContacts().size());

        for (Contact contact: ContactsManager.getInstance().getContacts()) {
            if (contact.getFirstName() == "fake shane") {
                assertTrue(true);
                return;
            }
        }

        assertFalse(true);

    }

    @Test
    public void deleteTest() throws Exception {
        ContactsManager.getInstance().delete(shane);
        assertEquals(2, ContactsManager.getInstance().getContacts().size());
        assertEquals(false, ContactsManager.getInstance().getContacts().contains(shane));

        Contact clone = jolin.clone();
        clone.setFirstName("");
        ContactsManager.getInstance().delete(clone);
        assertEquals(1, ContactsManager.getInstance().getContacts().size());
        assertEquals(false, ContactsManager.getInstance().getContacts().contains(jolin));

    }
}