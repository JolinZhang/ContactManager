package com.example.jonelezhang.contactmanager;

import java.util.ArrayList;

/**
 * Created by Shadow on 10/29/16.
 */

public interface IContactsManager {

    /**
     * Author: zxq150130 - Zengtai Qi
     * Insert the contact into the list if not exists, otherwise, update it.
     * @param contact The Contact object to add.
     *
     */
    void insertOrUpdate(Contact contact);

    /**
     * Author: zxq150130 - Zengtai Qi
     * @param contact The Contact object to delete.
     */
    void delete(Contact contact);

    /**
     * Author: zxq150130 - Zengtai Qi
     * @return Sorted contacts list.
     */
    ArrayList<Contact> getContacts();

}
