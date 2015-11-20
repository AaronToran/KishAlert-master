package com.bert.kishalert;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import java.util.Date;

/**
 * Created by Aaron on 11/9/2015.
 */

public class Alert {
    private static Context ctx;
    DatabaseOp db = new DatabaseOp(ctx);
    Alert(Context c){
        ctx = c;
    }
    //plays the user notification sound
    public void playNotification(){
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(ctx,notification);
        r.play();
    }
//I'm trying to create the text notification that the user will see
/*    public void sendNotifaction() {
        MediaPlayer mp = new MediaPlayer();

        new NotificationCompat.Builder(ctx)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("KishAlert")
                .setContentText("Hello world");
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
    }

*/
}
