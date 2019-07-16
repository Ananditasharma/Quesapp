package com.example.quesapp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Question extends Fragment {
    private static final String HI ="http://hnsc.in/myadmin/json/question.php";
  
    
    private TextView txtDay, txtHour, txtMinute, txtSecond;
    private TextView tvEventStart;
    private RecyclerView rv;
    private List <List_data> list_data;

    private MyAdapter adapter;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;




    private String EVENT_DATE_TIME = "2019-12-31 10:30:00";
    private String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private LinearLayout linear_layout_1, linear_layout_2;
    private TextView tv_days, tv_hour, tv_minute, tv_second;
    private Handler handler = new Handler();
    private Runnable runnable;

    public int counter;

    TextView tv1,tv2,tv3,counttime;
    CheckBox a,b,c,d,e;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    int q,s;
    OnaddsListener addsListener;

    public interface OnaddsListener
    {
        public void adds();
    }



    public Question() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        linear_layout_1 = view.findViewById(R.id.linear_layout_1);
        linear_layout_2 = view.findViewById(R.id.linear_layout_2);
        tv_days = view.findViewById(R.id.tv_days);
        tv_hour = view.findViewById(R.id.tv_hour);
        tv_minute = view.findViewById(R.id.tv_minute);
        tv_second = view.findViewById(R.id.tv_second);

        countDownStart();

        tv1 = view.findViewById(R.id.tv_question);
        tv2 = view.findViewById(R.id.response);

        bt1 = view.findViewById(R.id.btn_one);
        bt2 = view.findViewById(R.id.btn_two);
        bt3 = view.findViewById(R.id.btn_three);

        bt9 = view.findViewById(R.id.btn_nine);
        a = view.findViewById(R.id.cb1);
        b = view.findViewById(R.id.cb2);
        c = view.findViewById(R.id.cb3);
        d = view.findViewById(R.id.cb4);
        e=view.findViewById(R.id.cb5);
        q = 0;
        s = 0;
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addsListener.adds();

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Loading...");
                progressDialog.show();


                    request = new JsonArrayRequest(HI, new Response.Listener <JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jsonObject = null;
                            for (int i = 1; i < response.length(); i++) {
                                try {
                                    JSONObject ob = response.getJSONObject(i);

                                        List_data listData = new List_data(ob.getInt("id"),
                                                ob.getString("question"),
                                                ob.getString("option1"),
                                                ob.getString("option2"),
                                                ob.getString("option3"),
                                                ob.getString("option4"),
                                                ob.getString("option5"));


                                        list_data.add(listData);
                                    } catch(JSONException e){
                                        e.printStackTrace();
                                    }

                                }

                            //  setupData(list_data);
                            progressDialog.dismiss();
                            adapter.notifyDataSetChanged();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            progressDialog.dismiss();

                        }
                    });
                    requestQueue = Volley.newRequestQueue(getContext());
                    requestQueue.add(request);

                }

        });

        return view;

    }






    private void countDownStart() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    handler.postDelayed(this, 1000);
                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                    Date event_date = dateFormat.parse(EVENT_DATE_TIME);
                    Date current_date = new Date();
                    if (!current_date.after(event_date)) {
                        long diff = event_date.getTime() - current_date.getTime();
                        long Days = diff / (24 * 60 * 60 * 1000);
                        long Hours = diff / (60 * 60 * 1000) % 24;
                        long Minutes = diff / (60 * 1000) % 60;
                        long Seconds = diff / 1000 % 60;
                        //
                        tv_days.setText(String.format("%02d", Days));
                        tv_hour.setText(String.format("%02d", Hours));
                        tv_minute.setText(String.format("%02d", Minutes));
                        tv_second.setText(String.format("%02d", Seconds));
                    } else {
                        linear_layout_1.setVisibility(View.VISIBLE);
                        linear_layout_2.setVisibility(View.GONE);
                        handler.removeCallbacks(runnable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }


    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

 
        addsListener=(OnaddsListener) activity;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView) view.findViewById(R.id.recyclerview);
        list_data = new ArrayList <>();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new MyAdapter(list_data, getContext());
        rv.setAdapter(adapter);
        getdata();

    }

    private void getdata() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        request = new JsonArrayRequest(HI, new Response.Listener <JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject ob = response.getJSONObject(i);
                        List_data listData = new List_data(ob.getInt("id"),
                                ob.getString("question"),
                                ob.getString("option1"),
                                ob.getString("option2"),
                                ob.getString("option3"),
                                ob.getString("option4"),
                                ob.getString("option5"));


                        list_data.add(listData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                //  setupData(list_data);
                progressDialog.dismiss();
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.toString());
                progressDialog.dismiss();

            }
        });
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);


    }

    private void setupData(List <List_data> list_data) {

        adapter = new MyAdapter(list_data, getContext());
        rv.setAdapter(adapter);

    }
}







