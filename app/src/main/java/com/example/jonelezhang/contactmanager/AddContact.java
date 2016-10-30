package com.example.jonelezhang.contactmanager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Jonelezhang on 10/28/16.
 */

public class AddContact extends Fragment {
    private AppCompatButton save;
    private EditText firstName;
    private EditText lastName;
    private EditText phoneNumber;
    private EditText email;
    private Contact content;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_contact,container, false);
        setHasOptionsMenu(true);

        save = (AppCompatButton) v.findViewById(R.id.save);
        firstName = (EditText) v.findViewById(R.id.firstName);
        lastName = (EditText) v.findViewById(R.id.lastName);
        phoneNumber = (EditText) v.findViewById(R.id.phoneNumber);
        email = (EditText) v.findViewById(R.id.email);

        //show contact info
        Bundle bundle = getArguments();
        if(bundle != null){
            content =(Contact) getArguments().getSerializable("Icontact");
            firstName.setText(content.getFirstName());
            lastName.setText(content.getLastName());
            phoneNumber.setText(content.getPhoneNumber());
            email.setText(content.getEmail());
            save.setVisibility(View.VISIBLE);
        }else{
            content = new Contact();
        }



        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count>0){
                    save.setVisibility(View.VISIBLE);
                }else{
                    save.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        //save contact
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setFirstName(firstName.getText().toString());
                content.setLastName(lastName.getText().toString());
                content.setPhoneNumber(phoneNumber.getText().toString());
                content.setEmail(email.getText().toString());
                ContactsManager.getInstance().insertOrUpdate(content);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.delete_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                getActivity().getSupportFragmentManager().popBackStack();

                ContactsManager.getInstance().delete(content);

                return true;
            default:
                return false;

        }
    }
}
