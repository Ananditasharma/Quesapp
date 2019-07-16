package com.example.quesapp;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class navigationfragment extends Fragment {
    Button b1,b2,b3,b4,b5;
    OnadddocListener adddocListener;


    public interface OnadddocListener
    {
        public void adddoc();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        b1=view.findViewById(R.id.btn_1);
        b2=view.findViewById(R.id.btn_2);
        b3=view.findViewById(R.id.btn_3);
        b4 = view.findViewById(R.id.btn_4);
        b5=view.findViewById(R.id.btn_5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adddocListener.adddoc();

            }
        });

        return view;
    }
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

        adddocListener =(OnadddocListener) activity;
    }

}
