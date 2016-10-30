package com.example.jonelezhang.contactmanager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jonelezhang on 10/28/16.
 */

public class AddContact extends Fragment {
    private android.support.v7.widget.AppCompatButton save;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_contact,container, false);
        setHasOptionsMenu(false);

        save = (android.support.v7.widget.AppCompatButton)getActivity().findViewById(R.id.save);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

            }
        });
    }
}
