package com.example.junaedmohammed.wordexplorer;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.junaedmohammed.wordexplorer.ui.MainActivity;

import java.net.MalformedURLException;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    CheckBox notification;
    CheckBox antonym;
    CheckBox enable_auto_search;
    CheckBox example;
    CheckBox word_of_day;


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        notification = (CheckBox) v.findViewById(R.id.notification_bar);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (notification.isChecked())
                {
                    notificationBar();
                }
                else
                {
                    CancelNotificationBar();
                    Toast.makeText(getContext(), "Notification Closed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return v;
    }

    public void notificationBar(){

        NotificationCompat.Builder notification =(NotificationCompat.Builder) new NotificationCompat.Builder(getContext())
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.dictionary_icon))
                .setContentTitle("Word Explorer")
                .setContentText("To remove go to Settings of the dictionary");

        Intent i = new Intent(getContext(), MainActivity.class);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getContext());
        taskStackBuilder.addParentStack(MainActivity.class);
        taskStackBuilder.addNextIntent(i);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(100, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(getContext().NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification.build());

    }

    public void CancelNotificationBar()
    {
        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(getContext().NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
    }

}
