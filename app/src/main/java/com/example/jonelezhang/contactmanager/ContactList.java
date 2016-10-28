package com.example.jonelezhang.contactmanager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jonelezhang on 10/28/16.
 */

public class ContactList extends Fragment {
    private RecyclerView contractList;
    private ContactsAdapter contactsAdapter;

    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact_list,container,false);

        contractList = (RecyclerView) view.findViewById(R.id.contacts_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        contractList.setLayoutManager(mLayoutManager);


        contactsAdapter = new ContactsAdapter();
        contractList.setAdapter(contactsAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}