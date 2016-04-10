package org.code_freak.com.my_notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MyNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification_layout);
    }

    public void doNotify(View view) {

        switch (view.getId()) {

            case R.id.btnGenerate:

                NotificationCompat.Builder notificationBuilder1 = new NotificationCompat.Builder(this);
                notificationBuilder1.setContentTitle("I did this");
                notificationBuilder1.setSmallIcon(R.drawable.zoo);
                notificationBuilder1.setContentText("Breaking News");
                notificationBuilder1.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.zoocopy));
                notificationBuilder1.setTicker("Announcement");
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, new Intent(this, Redirected_Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);
                notificationBuilder1.setContentIntent(pendingIntent);

                Notification notification = notificationBuilder1.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);
                break;
            case R.id.btnLed:
                NotificationCompat.Builder notificationBuilder2 = new NotificationCompat.Builder(this);
                notificationBuilder2.setContentTitle("I did this");
                notificationBuilder2.setSmallIcon(R.drawable.zoo);
                notificationBuilder2.setContentText("Breaking News");
                notificationBuilder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.zoocopy));
                notificationBuilder2.setTicker("Announcement");
                PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 1, new Intent(this, Redirected_Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);
                notificationBuilder2.setContentIntent(pendingIntent1);

//                Notification notification1 = notificationBuilder2.build();


                NotificationManager nm = ( NotificationManager ) getSystemService( NOTIFICATION_SERVICE );
                Notification notif = notificationBuilder2.build();

                notif.ledARGB = 0xFFff0000;
                notif.flags = Notification.FLAG_SHOW_LIGHTS;
                notif.ledOnMS = 100;
                notif.ledOffMS = 100;
                nm.notify(1, notif);
                break;
            case R.id.btnVibrate:
                NotificationCompat.Builder notificationBuilder3 = new NotificationCompat.Builder(this);
                notificationBuilder3.setContentTitle("I did this");
                notificationBuilder3.setSmallIcon(R.drawable.zoo);
                notificationBuilder3.setContentText("Breaking News");
                notificationBuilder3.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.zoocopy));
                notificationBuilder3.setTicker("Announcement");
                PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 1, new Intent(this, Redirected_Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);
                notificationBuilder3.setContentIntent(pendingIntent2);
                NotificationManager nmv = ( NotificationManager ) getSystemService( NOTIFICATION_SERVICE );
                Notification notifi = notificationBuilder3.build();
                notifi.defaults |= Notification.DEFAULT_VIBRATE;
                notifi.defaults |= Notification.DEFAULT_SOUND;

                nmv.notify(1,notifi);

                break;
            case R.id.btnSound:
                NotificationCompat.Builder notificationBuilder4 = new NotificationCompat.Builder(this);
                notificationBuilder4.setContentTitle("I did this");
                notificationBuilder4.setSmallIcon(R.drawable.zoo);
                notificationBuilder4.setContentText("Breaking News");
                notificationBuilder4.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.zoocopy));
                notificationBuilder4.setTicker("Announcement");
                PendingIntent pendingIntent3 = PendingIntent.getActivity(this, 1, new Intent(this, Redirected_Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);
                notificationBuilder4.setContentIntent(pendingIntent3);
                NotificationManager nmm = ( NotificationManager ) getSystemService( NOTIFICATION_SERVICE );
                Notification notifie = notificationBuilder4.build();
                //notifi.defaults |= Notification.DEFAULT_VIBRATE;
                notifie.defaults |= Notification.DEFAULT_SOUND;

                nmm.notify(1,notifie);
                break;
            case R.id.btnToast:
                Toast.makeText(getBaseContext(),"dhfkshf",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnAll:
                NotificationCompat.Builder notificationBuilder5 = new NotificationCompat.Builder(this);
                notificationBuilder5.setContentTitle("I did this");
                notificationBuilder5.setSmallIcon(R.drawable.zoo);
                notificationBuilder5.setContentText("Breaking News");
                notificationBuilder5.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.zoocopy));
                notificationBuilder5.setTicker("Announcement");
                PendingIntent pendingIntent4 = PendingIntent.getActivity(this, 1, new Intent(this, Redirected_Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);
                notificationBuilder5.setContentIntent(pendingIntent4);
                NotificationManager nma = ( NotificationManager ) getSystemService( NOTIFICATION_SERVICE );
                Notification notifies = notificationBuilder5.build();
                notifies.defaults |= Notification.DEFAULT_VIBRATE;
                notifies.defaults |= Notification.DEFAULT_SOUND;
                notifies.ledARGB = 0xFFff0000;
                notifies.flags = Notification.FLAG_SHOW_LIGHTS;
                notifies.ledOnMS = 100;
                notifies.ledOffMS = 100;
                nma.notify(1,notifies);
                break;
        }
    }

}