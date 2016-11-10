package com.example.dou.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by Dou on 2016/4/26.
 */
public class BottomFragment extends Fragment {
    private String personName = "jack";
    private Button buttonJudgement;

    public String getPersonName() {
        return personName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom, container, false);
        buttonJudgement = (Button)view.findViewById(R.id.btn_jugement);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /**
         * 这不是一种好的方式，让fragment和activity通信
         */

        //获得activity中的控件
        final CheckBox checkBox = (CheckBox)getActivity().findViewById(R.id.checkBox);
        buttonJudgement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox != null){
                    if(checkBox.isChecked()){
                        //获得activity中的变量
                        String a = ((MainActivity)getActivity()).getTest();
                        Toast.makeText(getActivity(),a+"选中",3000).show();
                    }
                    else {
                        String a = ((MainActivity)getActivity()).getTest();
                        Toast.makeText(getActivity(),a+"未选中",3000).show();
                    }
                }

            }
        });
    }
}
