package org.code_freak.com.marker_map;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Imperial_Images extends AppCompatActivity {
    private TextView tvDescription;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperial__images_layout);
        ViewPager view_pagerImperial = (ViewPager) findViewById(R.id.view_pagerImperial);
        ImageAdapterImperial adapter = new ImageAdapterImperial(this);
        view_pagerImperial.setAdapter(adapter);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvDescription.setText("In the business district of Rajkot, this elegant hotel with a courtyard atrium is 1.5 km from the historical artifacts at the Watson Museum, and 2.8 km from Rajkot Railway Station");
        tvTitle.setText("Imperial Palace");
        tvTitle.setTextColor(Color.BLUE);
    }
}
