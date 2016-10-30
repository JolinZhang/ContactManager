package com.example.jonelezhang.contactmanager;

import java.util.ArrayList;

/**
 * Created by Shadow on 10/29/16.
 */

public interface IContactsManager {

    ArrayList<Contact> contacts = new ArrayList<Contact>();

    /**
     * Insert the contact into the list if not exists, otherwise, update it.
     * @param contact
     *
     */
    void insertOrUpdate(Contact contact);

    void delete(Contact contact);

    /**
     *
     * @return Sorted contacts list.
     */
    ArrayList<Contact> getContacts();

}
