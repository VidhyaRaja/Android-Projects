package org.code_freak.com.marker_map;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Instagram_App extends AppCompatActivity {
    private TextView tvDescription;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram__app_layout);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvDescription.setText("In 2003 the zoo opened a natural history museum in a large hall in the veterinary hospital. The museum opened with the skeletons of two Asiatic lions, as well as panther, deer, wild boar, antelope, black buck, blue bull, and spotted deer. Eggs, beaks, and feathers of various birds were also on display. The museum will be expanded as specimens become available.");
        tvTitle.setText("Sakkar Bagh Zoo");
        tvTitle.setTextColor(Color.BLUE);
    }
}