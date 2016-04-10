package org.code_freak.com.sms_send_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class Sms_Send_App extends AppCompatActivity {
    private EditText etPhone;
    private EditText etMsg;
    String msg;
    String phnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms__send__app_layout);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etMsg = (EditText) findViewById(R.id.etMsg);
      msg = etMsg.getText().toString();
        phnum = etPhone.getText().toString();
    }

    public void Send(View view){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phnum,null,msg,null,null);
    }
}
