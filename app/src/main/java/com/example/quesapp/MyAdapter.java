package com.example.quesapp;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {



    private List <List_data> list_data;
    private Context context;
    private Button button;




    public MyAdapter(List <List_data> list_data, Context context) {
        this.list_data = list_data;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);




        return new ViewHolder(view);
    }






    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final List_data listData = list_data.get(position);

        holder.textViewQuestion.setText(listData.getQuestion());
        holder.option1.setText(listData.getOption1());
        holder.option2.setText(String.valueOf(listData.getOption2()));
        holder.option3.setText(String.valueOf(listData.getOption3()));
        holder.option4.setText(String.valueOf(listData.getOption4()));
        holder.option5.setText(String.valueOf(listData.getOption5()));

    }



    @Override
    public int getItemCount() {
        return list_data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewQuestion;
        public CheckBox option1,option2,option3,option4,option5;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewQuestion= itemView.findViewById(R.id.tv_question);
            option1 = itemView.findViewById(R.id.cb1);
            option2 = itemView.findViewById(R.id.cb2);
            option3 = itemView.findViewById(R.id.cb3);
            option4 = itemView.findViewById(R.id.cb4);
            option5=itemView.findViewById(R.id.cb5);
        }
    }

}

