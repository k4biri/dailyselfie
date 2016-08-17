package com.mpandg.dailyselfie.Utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mpandg.dailyselfie.MainActivity;
import com.mpandg.dailyselfie.R;

/**
 * Created by Ali Kabiri on 8/17/2016.
 * Find me here: ali@kabiri.org
 */
public class NotificationReciever extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 10;

    @Override
    public void onReceive(Context context, Intent intent) {

        // this intent is used when the user clicks the notification.
        Intent reminderIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, reminderIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // create the notification.
        Notification.Builder notificationBuilder = new Notification.Builder(context)
                .setContentTitle(context.getResources().getString(R.string.notification_title))
                .setContentText(context.getResources().getString(R.string.time_for_selfie))
                .setSmallIcon(android.R.drawable.ic_menu_camera)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        
        // get reference to notification manager.
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // show the notification.
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }
}
