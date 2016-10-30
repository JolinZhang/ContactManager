package com.example.jonelezhang.contactmanager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Jonelezhang on 10/28/16.
 */

public class ContactList extends Fragment {
    private RecyclerView contractList;
    private ContactsAdapter contactsAdapter;
    private ArrayList<Contact> Icontacts;

    /**
     * Author: rxz151130 - Ru Zhang
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        contractList = (RecyclerView) view.findViewById(R.id.contacts_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        contractList.setLayoutManager(mLayoutManager);

        Icontacts = ContactsManager.getInstance().getContacts();
        contactsAdapter = new ContactsAdapter(getActivity(), Icontacts);
        contractList.setAdapter(contactsAdapter);

        setHasOptionsMenu(true);

        return view;
    }

    /**
     * Author: rxz151130 - Ru Zhang
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.option_menu, menu);

    }

    /**
     * Author: rxz151130 - Ru Zhang
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                AddContact addContact = new AddContact();
                //  Go to contact adding page.
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contacts, addContact)
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return false;
        }
    }
}
