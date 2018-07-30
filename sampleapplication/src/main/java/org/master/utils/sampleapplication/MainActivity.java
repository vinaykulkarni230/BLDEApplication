package org.master.utils.sampleapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn,toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        toast = findViewById(R.id.toast);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast toast = Toast.makeText(MainActivity.this, "Toast message", Toast.LENGTH_SHORT);
                toast.setGravity( Gravity.CENTER,0,0);
                toast.show();*/

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_done,
                        (ViewGroup)findViewById(R.id.custom_toast));
                Toast toast = new Toast(MainActivity.this);
                toast.setView(view);
                toast.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });
    }

    private void notification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_action_notification);
        builder.setContentTitle("Notification");
        builder.setContentText("A new message came");
        long[] v = {500,1000};
        builder.setVibrate(v);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);
        Intent intent = new Intent(this,NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Intent doneIntent = new Intent(this,DoneActivity.class);
        PendingIntent dPI = PendingIntent.getActivity(this,1,doneIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.addAction(R.drawable.ic_action_done,"Done",dPI);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
