package com.example.jonelezhang.contactmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shadow on 10/30/16.
 */

public class ContactsModelTest {

    private Contact shane;

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    @Before
    public void setUp() {
        shane = new Contact();
        shane.setFirstName("Shane");
        shane.setLastName("Qi");
        shane.setPhoneNumber("4698453217");
        shane.setEmail("qizengtai@gmail.com");
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    @Test
    public void contactCloneTest() throws  Exception {
        Contact shaneClone = shane.clone();

        assertEquals(shane.getId(), shaneClone.getId());
        assertEquals(shane.getFirstName(), shaneClone.getFirstName());
        assertEquals(shane.getLastName(), shaneClone.getLastName());
        assertEquals(shane.getEmail(), shaneClone.getEmail());
        assertEquals(shane.getPhoneNumber(), shaneClone.getPhoneNumber());

    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    @Test
    public void contactHashcodeTest() throws Exception {
        Contact someone = new Contact();
        someone.setId(shane.getId());

        assertEquals(someone.hashCode(), shane.hashCode());
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    @Test
    public void contactComparingTest() throws Exception {
        Contact jolin = new Contact();
        jolin.setFirstName("Jolin");
        jolin.setLastName("Zhang");

        Contact michael = new Contact();
        michael.setFirstName("Michael");
        michael.setLastName("Bluth");

        assertEquals(true, shane.compareTo(jolin) > 0);
        assertEquals(true, shane.compareTo(michael) > 0);
        assertEquals(false, jolin.compareTo(michael) > 0);

    }

}
