package org.code_freak.com.text_to_speech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class T_To_S extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private EditText etName;
    private TextView tvResult;
    private TextToSpeech tts;
    private Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t__to__s_layout);
        etName= (EditText) findViewById(R.id.etName);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tts = new TextToSpeech(this,this);
        btnResult = (Button) findViewById(R.id.btnGreet);
    }

    public void Greet(View view){
        tvResult.setText("hellllooooooooooo" +etName.getText());
    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // Note that a language may not be available, and the result will indicate this.
            int result = tts.setLanguage(Locale.US);
            // Try this someday for some interesting results.
            // int result mTts.setLanguage(Locale.FRANCE);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Lanuage data is missing or the language is not supported.
                Log.e("Kuldeep", "Language is not available.");
            } else {
                // Check the documentation for other possible result codes.
                // For example, the language may be available for the locale,
                // but not for the specified country and variant.

                // The TTS engine has been successfully initialized.
                // Allow the user to press the button for the app to speak again.
                btnResult.setEnabled(true);
                // Greet the user.
                tts.speak("hello"+" "+etName.getText(),TextToSpeech.QUEUE_FLUSH,null);
            }
        } else {
            // Initialization failed.
            Log.e("Kuldeep", "Could not initialize TextToSpeech.");
        }

    }

}
