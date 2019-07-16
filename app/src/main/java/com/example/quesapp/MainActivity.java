package com.example.quesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements Login_Fragment.OnaddListener,navigationfragment.OnadddocListener,Question.OnaddsListener,subjects.OnsubjectListener{


    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        


        fragmentManager = getSupportFragmentManager();


        if (savedInstanceState == null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frameContainer, new Login_Fragment(),
                            Utils.Login_Fragment).commit();
        }

        findViewById(R.id.close_activity).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        finish();

                    }
                });

    }


   
       
    @Override
    public void onBackPressed() {

        
        Fragment SignUp_Fragment = fragmentManager
                .findFragmentByTag(Utils.SignUp_Fragment);
        Fragment ForgotPassword_Fragment = fragmentManager
                .findFragmentByTag(Utils.ForgotPassword_Fragment);



        if (SignUp_Fragment != null)
            replaceLoginFragment();
        else if (ForgotPassword_Fragment != null)
            replaceLoginFragment();
        else
            super.onBackPressed();
    }

    void replaceLoginFragment() {
    }

    @Override
    public void add() {
      getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new subjects()).addToBackStack(null).commit();

    }


    @Override
    public void adddoc() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new Question()).addToBackStack(null).commit();


    }



    @Override
    public void adds() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Next_question()).commit();

    }

    @Override
    public void subject() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new navigationfragment()).addToBackStack(null).commit();


    }
}