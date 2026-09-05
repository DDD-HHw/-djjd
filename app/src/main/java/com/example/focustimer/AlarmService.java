package com.example.focustimer;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
public class AlarmService extends Service {
    private static final String CHANNEL_ID = "focus_channel";
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "专注计时", NotificationManager.IMPORTANCE_LOW);
            getSystemService(NotificationManager.class).createNotificationChannel(channel);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("专注进行中")
                .setContentText("计时器正在后台运行")
                .setSmallIcon(android.R.drawable.ic_menu_timer)
                .build();
        startForeground(1, notification);
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) { return null; }
}
