package com.example.quesapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class subjects extends Fragment {


    GridLayout gridLayout;
    OnsubjectListener subjectlsitener;

    public interface OnsubjectListener
    {
        public void subject();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subjects, container, false);
        gridLayout=(GridLayout)view.findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

        return view;

    }
    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(getActivity(),"Clicked at index "+ finalI,
                    //       Toast.LENGTH_SHORT).show();
                    if(finalI==0){
                        subjectlsitener.subject();
                    }
                    if(finalI==1){
                        subjectlsitener.subject();
                    }
                    if(finalI==2){
                        subjectlsitener.subject();
                    }
                    if(finalI==3){
                        subjectlsitener.subject();
                    }
                    if(finalI ==4){
                        subjectlsitener.subject();

                    }
                    if(finalI==5){
                        subjectlsitener.subject();
                    }


                }
            });
        }
    }
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

        subjectlsitener = (OnsubjectListener) activity;

    }



}
