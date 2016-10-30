package com.example.jonelezhang.contactmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Shadow on 10/29/16.
 */

public class ContactsManager implements IContactsManager {

    /**
     * Singleton declaring.
     */
    public static ContactsManager INSTANCE = new ContactsManager();
    private ContactsManager() {}
    public static ContactsManager getInstance() {
        INSTANCE.contacts = FileManager.getInstance().readFromPersistence();
        return INSTANCE;
    }

    /**
     *
     */
    private HashSet<Contact> contacts = new HashSet<>();

    /**
     *
     * @param contact
     */
    @Override
    public void insertOrUpdate(Contact contact) {
        contacts.remove(contact);
        contacts.add(contact);
        FileManager.getInstance().saveToPersistence(contacts);
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
        FileManager.getInstance().saveToPersistence(contacts);
    }

    @Override
    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> result = new ArrayList<>(contacts);
        Collections.sort(result);
        return result;
    }

    public void clearForTesting() {
        contacts.clear();
    }
}
