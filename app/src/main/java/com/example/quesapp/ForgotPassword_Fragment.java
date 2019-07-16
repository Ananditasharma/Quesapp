package com.example.quesapp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.quesapp.R;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.quesapp.R.drawable.text_selector;

public class ForgotPassword_Fragment extends Fragment implements
        OnClickListener {
    private static View view;

    private static EditText emailId;
    private static TextView submit, back;
    private static FragmentManager fragmentManager;


    public ForgotPassword_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forgotpassword_layout, container,
                false);
        initViews();
        setListeners();
        return view;
    }


    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        emailId = (EditText) view.findViewById(R.id.registered_emailid);
        submit = (TextView) view.findViewById(R.id.forgot_button);
        back = (TextView) view.findViewById(R.id.backToLoginBtn);

        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            back.setTextColor(csl);
            submit.setTextColor(csl);

        } catch (Exception e) {
        }

    }


    private void setListeners() {
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToLoginBtn:


                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, new Login_Fragment(),
                                Utils.Login_Fragment).commit();
                break;

            case R.id.forgot_button:

                // Call Submit button task
                submitButtonTask();
                break;

        }

    }

    private void submitButtonTask() {
        String getEmailId = emailId.getText().toString();


        Pattern p = Pattern.compile(Utils.regEx);


        Matcher m = p.matcher(getEmailId);


        if (getEmailId.equals("") || getEmailId.length() == 0)

            new CustomToast().Show_Toast(getActivity(), view,
                    "Please enter your Email Id.");


        else if (!m.find())
            new CustomToast().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");


        else
            Toast.makeText(getActivity(), "Get Forgot Password.",
                    Toast.LENGTH_SHORT).show();
    }
}
