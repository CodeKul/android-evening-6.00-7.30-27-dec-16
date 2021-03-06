package com.melayer.statusbarnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private static final int NOTI_SAM = 1458;
    private static final int REQ_NEW = 9658;

    private Notification notification;
    private StringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new StringBuilder();
        findViewById(R.id.btnNotify).setOnClickListener(this::notify);
    }

    private void notify(View view) {

        builder.append("\n").append(System.currentTimeMillis());
        NotificationCompat.InboxStyle inStyle = new NotificationCompat.InboxStyle();
        inStyle.setBigContentTitle("codekul ");
        inStyle.addLine(builder.toString());

        Intent intent = new Intent(this, NotificationActivity.class);
        intent.putExtra("notiData", String.valueOf(System.currentTimeMillis()));

        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_NEW, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
        remoteViews.setImageViewResource(R.id.imageView,R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.textView, getResources().getString(R.string.app_name));

        notification =
        new NotificationCompat.Builder(this)
                .setContentTitle(getResources().getString(R.string.title))
                .setContentText(getResources().getString(R.string.text))
                .setContentInfo(getResources().getString(R.string.info))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setShowWhen(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .addAction(R.mipmap.ic_launcher,"Action1", pendingIntent)
                .setCustomContentView(remoteViews)
                .setCustomBigContentView(remoteViews)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTI_SAM , notification);
    }
}
