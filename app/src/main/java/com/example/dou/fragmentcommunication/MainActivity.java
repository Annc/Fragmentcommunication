package com.example.dou.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox mIsMarry;
    private BottomFragment bottomFragment;
    private String test = "test";

    public String getTest() {
        return test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomFragment = new BottomFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container,bottomFragment).commit();

        mIsMarry = (CheckBox)findViewById(R.id.checkBox);
        mIsMarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //activity中获得所属的fragment
                //fragment是使用xml fragment标签的
 //               BottomFragment bottomFragment = (BottomFragment)getFragmentManager().findFragmentById(R.id.fragment_bottom);


                //通过tag的方式
                //getFragmentManager().findFragmentByTag("fragment_bottom_tag");
                if(mIsMarry.isChecked()){
                    if(bottomFragment != null){
                        //Fragment获取它的UI
                        TextView textResult = (TextView)bottomFragment.getView().findViewById(R.id.txt_result);
                        //获取fragment的成员变量
                        String name = bottomFragment.getPersonName();
                        textResult.setText(name + "已婚");
                    }
                }
                else {
                    if(bottomFragment != null){
                        //Fragment获取它的UI
                        TextView textResult = (TextView)bottomFragment.getView().findViewById(R.id.txt_result);
                        //获取fragment的成员变量
                        String name = bottomFragment.getPersonName();
                        textResult.setText(name + "未婚");
                    }

                }
            }
        });
    }
}
