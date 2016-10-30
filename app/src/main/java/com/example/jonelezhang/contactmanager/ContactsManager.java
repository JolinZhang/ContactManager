package com.example.jonelezhang.contactmanager;

import java.util.ArrayList;

/**
 * Created by Shadow on 10/29/16.
 */

public class ContactsManager implements IContactsManager {

    public static ContactsManager INSTANCE = new ContactsManager();

    private ContactsManager() {}

    public static ContactsManager getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertOrUpdate(Contact contact) {

    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public ArrayList<Contact> getContacts() {
        return null;
    }
}
