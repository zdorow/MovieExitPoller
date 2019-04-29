package com.example.worldcom.movieexitpoller.Activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.worldcom.movieexitpoller.R;
import com.example.worldcom.movieexitpoller.Room.Response;
import com.example.worldcom.movieexitpoller.Room.ResponseRoomDatabase;

import java.util.HashMap;
import java.util.Map;

public class SurveyActivity extends AppCompatActivity {

    // Constants for the notification actions buttons.
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.example.worldcom.movieexitpoller.ACTION_UPDATE_NOTIFICATION";
    // Notification channel ID.
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    // Notification ID.
    private static final int NOTIFICATION_ID = 0;

    private NotificationManager mNotifyManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    Intent intentMovies = new Intent(SurveyActivity.this, MainActivity.class);;
                    startActivity(intentMovies);
                    return true;
                case R.id.navigation_stats:
                    Intent intentStats = new Intent(SurveyActivity.this, StatsActivity.class);
                    startActivity(intentStats);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        createNotificationChannel();
        final ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(SurveyActivity.this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final Integer movieID = getIntent().getIntExtra("MOVIE_ID", 0);
        Log.i("Movie ID", "The movie number has been set to " + movieID);

        final Intent intentSurvey = new Intent(SurveyActivity.this, StatsActivity.class);
        final Button submitButton = findViewById(R.id.submitButton);
        final RadioGroup question1 = findViewById(R.id.radioGroup1);
        final RadioGroup question2 = findViewById(R.id.radioGroup2);
        final RadioGroup question3 = findViewById(R.id.radioGroup3);
        final RadioGroup question4 = findViewById(R.id.radioGroup4);
        final RadioGroup question5 = findViewById(R.id.radioGroup5);
        final RadioGroup question6 = findViewById(R.id.radioGroup6);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(     question1.getCheckedRadioButtonId() == -1 ||
                        question2.getCheckedRadioButtonId() == -1 ||
                        question3.getCheckedRadioButtonId() == -1 ||
                        question4.getCheckedRadioButtonId() == -1 ||
                        question5.getCheckedRadioButtonId() == -1 ||
                        question6.getCheckedRadioButtonId() == -1
                ) {
                    Toast.makeText(getApplicationContext(), "Please answer all the questions",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    RadioButton answer1 = findViewById(question1.getCheckedRadioButtonId());
                    Response response1 = new Response(movieID + 1, 1,
                            answerValueParser(answer1.getText().toString()));
                    insertResponse(response1, db);
                    Log.i("Response Answer Value", answerValueParser(answer1.getText().toString()).toString());

                    RadioButton answer2 = findViewById(question2.getCheckedRadioButtonId());
                    Response response2 = new Response(movieID + 1, 2,
                            answerValueParser(answer2.getText().toString()));
                    insertResponse(response2, db);
                    Log.i("Response Answer Value", answerValueParser(answer2.getText().toString()).toString());

                    RadioButton answer3 = findViewById(question3.getCheckedRadioButtonId());
                    Response response3 = new Response(movieID + 1, 3,
                            answerValueParser(answer3.getText().toString()));
                    insertResponse(response3, db);
                    Log.i("Response Answer Value", answerValueParser(answer3.getText().toString()).toString());

                    RadioButton answer4 = findViewById(question4.getCheckedRadioButtonId());
                    Response response4 = new Response(movieID + 1, 4,
                            answerValueParser(answer4.getText().toString()));
                    insertResponse(response4, db);
                    Log.i("Response Answer Value", answerValueParser(answer4.getText().toString()).toString());

                    RadioButton answer5 = findViewById(question5.getCheckedRadioButtonId());
                    Response response5 = new Response(movieID + 1, 5,
                            answerValueParser(answer5.getText().toString()));
                    insertResponse(response5, db);
                    Log.i("Response Answer Value", answerValueParser(answer5.getText().toString()).toString());

                    RadioButton answer6 = findViewById(question6.getCheckedRadioButtonId());
                    Response response6 = new Response(movieID + 1, 6,
                            answerValueParser(answer6.getText().toString()));
                    insertResponse(response6, db);
                    Log.i("Response Answer Value", answerValueParser(answer6.getText().toString()).toString());

                    sendNotification();

                    intentSurvey.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentSurvey);
                }
            }
        });
    }

    public static void insertResponse(final Response response, final ResponseRoomDatabase db) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Log.i("RECENT INSERT", response.getMovieId().toString() + response.getQuestionId().toString() + response.getQuestionAnswer().toString());
                db.responseDao().insert(response);
                return null;
            }
        }.execute();
    }

    public Integer answerValueParser(String answerValue){
        Map<String, Integer> hm = new HashMap<>();
        hm.put("very unlikely", 1);
        hm.put("unlikely", 2);
        hm.put("maybe", 3);
        hm.put("likely", 4);
        hm.put("very likely", 5);
        return hm.get(answerValue);
    }

    public void sendNotification() {

        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast(this,
                NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();

        notifyBuilder.addAction(R.drawable.filmreel,
                getString(R.string.survey_sucess_message), updatePendingIntent);

        // Deliver the notification.
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());

    }
    private NotificationCompat.Builder getNotificationBuilder() {

        // Set up the pending intent that is delivered when the notification
        // is clicked.
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity
                (this, NOTIFICATION_ID, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        // Build the notification with all of the parameters.
        return new NotificationCompat
                .Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(getString(R.string.survey_sucess))
                .setSmallIcon(R.drawable.filmreel)
                .setAutoCancel(true).setContentIntent(notificationPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
    }

    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotifyManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            getString(R.string.notification_channel_name),
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    (getString(R.string.notification_channel_description));

            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

}
