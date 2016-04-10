package org.code_freak.com.list_view_demo_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Common_Activity extends AppCompatActivity {
    //FrameLayout FL;
    RelativeLayout RL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);
        Intent intentCommon= getIntent();
        String color_code = intentCommon.getStringExtra(List_View_Color.color_code);
        TextView tvCommon = (TextView)findViewById(R.id.tvCommon);
        tvCommon.setText(color_code+ " selected");
        RL = (RelativeLayout)findViewById(R.id.RL);
       RL.setBackgroundColor( Color.parseColor(color_code));
        /*Integer a = Integer.parseInt(color_code);
        FL = (FrameLayout)findViewById(R.id.FL);
        FL.setBackgroundColor(a);*/
    }
}
