package org.code_freak.com.image_animation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Image_Animation extends AppCompatActivity {

    private static int RESULT_LOAD_IMG = 1;
    private static final int CAMERA_REQUEST = 12;
    String imgDecodableString;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__animation_layout);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        Intent data = getIntent(); //get the intent that starts this activity, in this case: gallery intent

        Intent incomingIntent = getIntent();
        try {
            Uri imageUri = (Uri) incomingIntent.getExtras().get(Intent.EXTRA_STREAM);
            ivImage.setImageURI(imageUri);
        } catch (NullPointerException ex) {
            Log.e("kuldeep", ex.toString());
        }
    }

    public void PickFromGalary(View view) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    public void getImageFromCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {


            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivImage.setImageBitmap(photo);
        }

        // When an Image is picked
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                && null != data) {
            // Get the Image from data

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            // Get the cursor
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            //ImageView imgView = (ImageView) findViewById(R.id.i);
            // Set the Image in ImageView after decoding the String
            ivImage.setImageBitmap(BitmapFactory
                    .decodeFile(imgDecodableString));

        } else {
            Toast.makeText(this, "You haven't picked Image",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void Animate(View view) {
        switch (view.getId()) {

            case R.id.btnClock:
                Animation animation = AnimationUtils.loadAnimation(this,R.anim.button_rotate);
                animation.setRepeatCount(Animation.INFINITE);
                ivImage.startAnimation(animation);
                animation.setDuration(3000);
               // ivImage.clearAnimation();
                break;
        }

    }
}