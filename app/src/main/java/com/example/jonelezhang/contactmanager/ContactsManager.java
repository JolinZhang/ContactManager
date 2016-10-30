package com.example.jonelezhang.contactmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Shadow on 10/29/16.
 */

public class ContactsManager implements IContactsManager {

    public static ContactsManager INSTANCE = new ContactsManager();

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    private ContactsManager() {}

    /**
     * Author: zxq150130 - Zengtai Qi
     */
    public static ContactsManager getInstance() {
        INSTANCE.contacts = FileManager.getInstance().readFromPersistence();
        return INSTANCE;
    }

    private HashSet<Contact> contacts = new HashSet<>();

    /**
     * Author: zxq150130 - Zengtai Qi
     * @param contact The Contact object to add. If not exists, insert it. Otherwise update the old one.
     */
    @Override
    public void insertOrUpdate(Contact contact) {
        contacts.remove(contact);
        contacts.add(contact);
        FileManager.getInstance().saveToPersistence(contacts);
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @param contact The contact object to delete. If not exists, nothing will happen.
     */
    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
        FileManager.getInstance().saveToPersistence(contacts);
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * @return The sorted contacts list.
     */
    @Override
    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> result = new ArrayList<>(contacts);
        Collections.sort(result);
        return result;
    }

    /**
     * Author: zxq150130 - Zengtai Qi
     * Clear the storage (Only for testing using.)
     */
    public void clearForTesting() {
        contacts.clear();
    }
}
