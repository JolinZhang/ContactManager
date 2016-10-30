package com.example.jonelezhang.contactmanager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jonelezhang on 10/28/16.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>{
    private ArrayList<Contact> Icontacts;
    private Context context;

    public ContactsAdapter(Context context, ArrayList<Contact> Icontacts){
        this.Icontacts = Icontacts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_cell_layout,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Contact Icontact = Icontacts.get(position);
        holder.firstName.setText(Icontact.getFirstName());
        holder.lastName.setText(Icontact.getLastName());
        holder.phoneNumber.setText(Icontact.getPhoneNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddContact addContact = new AddContact();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Icontact", Icontact);
                addContact.setArguments(bundle);

                FragmentTransaction transaction =((Contacts)context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contacts, addContact)
                        .addToBackStack(null)
                        .commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return Icontacts.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView firstName;
        public TextView lastName;
        public TextView phoneNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = (TextView) itemView.findViewById(R.id.firstName);
            lastName = (TextView) itemView.findViewById(R.id.lastName);
            phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);
        }
    }
}
