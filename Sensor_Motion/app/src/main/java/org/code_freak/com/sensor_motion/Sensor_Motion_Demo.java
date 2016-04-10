package org.code_freak.com.sensor_motion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensor_Motion_Demo extends AppCompatActivity implements SensorEventListener{

    private SensorManager sm;
    private TextView tvResult;
    private Sensor sensor;
//    StringBuilder b = new StringBuilder();
    float [] history = new float[2];
  //  String[] dir = {"NONE","NONE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor__motion__demo_layout);
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tvResult = (TextView)findViewById(R.id.tvResult);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float xChange = history[0] - event.values[0];

        float yChange = history[1] - event.values[1];
        history[0] = event.values[0];
        history[1] = event.values[1];
        if(xChange > 2){
            tvResult.setText("LEFT");

        }
        else if (xChange<-2){
            tvResult.setText("RIGHT");
        }
        if(yChange > 2)
            tvResult.setText("DOWN");
        else if (yChange<-2)
            tvResult.setText("TOP");

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
