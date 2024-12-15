package com.example.sunday;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.sunday.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding ay;

    MediaPlayer mp;
    String MY_VIDEO = "https://www.ebookfrenzy.com/android_book/movie.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.POST_NOTIFICATIONS},
                1);

        mp= MediaPlayer.create(this,R.raw.abc);

        ay = DataBindingUtil.setContentView(this,R.layout.activity_main);

        ay.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ay.editTextText.getText().toString();
//                Toast.makeText(MainActivity.this, s,
//                        Toast.LENGTH_SHORT).show();
                ay.textView.setText(ay.editTextText.getText().toString());

                Intent abc = new Intent(MainActivity.this,MainActivity2.class);
                abc.putExtra("a",s);

                startActivity(abc);
            }
        });

        ay.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder art = new AlertDialog.Builder(MainActivity.this);
                art.setTitle("Today is learning day");
                art.setMessage("Sunday also we will learn");
                art.setIcon(android.R.drawable.star_big_on);
                art.setPositiveButton("Positive",null);
                art.setNegativeButton("Neg",null);
                art.setNeutralButton("SDM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "sdm got clicked !", Toast.LENGTH_SHORT).show();
                    }
                });
                art.show();

            }
        });

        ay.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shownofn();

            }
        });

        ay.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        ay.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        ay.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp= MediaPlayer.create(MainActivity.this,R.raw.abc);
            }
        });

        ay.videobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ay.videoView.setVideoPath(MY_VIDEO);
                ay.videoView.setMediaController(new MediaController(MainActivity.this));
                ay.videoView.start();
            }
        });

    }

    public void shownofn() {
        NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this, channelId)
                .setLargeIcon(BitmapFactory.decodeResource(MainActivity.this.getResources(), android.R.drawable.star_big_on))
                .setSmallIcon(android.R.drawable.star_big_on).setContentTitle("You can also 'Learn Android'")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture( BitmapFactory.decodeResource(MainActivity.this.getResources(),android.R.drawable.star_big_on)))
                .setContentText("Contact AndroidManifester today!!");

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}