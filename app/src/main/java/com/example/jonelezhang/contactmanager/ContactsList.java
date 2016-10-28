package com.example.jonelezhang.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ContactsList extends AppCompatActivity {
    private RecyclerView contractList;
    private ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        contractList = (RecyclerView) findViewById(R.id.contacts_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        contractList.setLayoutManager(mLayoutManager);

        contractList.setHasFixedSize(true);
        contactsAdapter = new ContactsAdapter();
        contractList.setAdapter(contactsAdapter);



    }
}
