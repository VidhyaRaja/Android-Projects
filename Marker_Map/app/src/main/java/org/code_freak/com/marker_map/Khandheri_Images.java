package org.code_freak.com.marker_map;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Khandheri_Images extends AppCompatActivity {
    private TextView tvDescription;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khandheri__images_layout);
        ViewPager view_pagerKhandheri = (ViewPager) findViewById(R.id.view_pagerKhandheri);
        ImageAdapterKhandheri adapter = new ImageAdapterKhandheri(this);
        view_pagerKhandheri.setAdapter(adapter);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvDescription.setText("Initially, the stadium was being used for Ranji Trophy matches, when the spectator stands were still being constructed.[1] With the stands completed, the ground can hold 28,000 fans. The stadium is a part of a larger sports complex that will include venues for other sports such as badminton, basketball, and volleyball. It will host Saurashtra Cricket Association matches along with Madhavrao Scindia Cricket Ground.");
        tvTitle.setText("Khndheri Cricket Stadium");
        tvTitle.setTextColor(Color.BLUE);
    }
}
