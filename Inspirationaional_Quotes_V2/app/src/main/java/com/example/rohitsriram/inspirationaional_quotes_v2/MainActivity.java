package com.example.rohitsriram.inspirationaional_quotes_v2;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;


/**
 * This sample demonstrates how to schedule an alarm that causes a service to
 * be started. This is useful when you want to schedule alarms that initiate
 * long-running operations, such as retrieving a daily forecast.
 * This particular sample retrieves content from the Google home page once a day and
 * checks it for the search string "doodle". If it finds this string, that indicates
 * that the page contains a custom doodle instead of the standard Google logo.
 */
public class MainActivity extends Activity {
    SampleAlarmReceiver alarm = new SampleAlarmReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarm.setAlarm(this);

        TextView textView = (TextView)findViewById(R.id.textView);

        textView.setText(randomizer());

    }


    public String randomizer(){
        Resources res = getResources();
        String[] Quotes = res.getStringArray(R.array.Quotes);
        Random random = new Random();
        //creates a method of the Random Class
        int randomNumber = random.nextInt(Quotes.length);
        //variable randomNumber is assigned a random number from 1-3
        String Quote = Quotes[randomNumber];
        //the string variable Quote has a string from the array Quotes. The quote that is chosen is the one whose index number matches the random number chosen
        return Quote;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Menu options to set and cancel the alarm.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // When the user clicks START ALARM, set the alarm.
            case R.id.start_action:

                return true;
            // When the user clicks CANCEL ALARM, cancel the alarm.
            case R.id.cancel_action:
                alarm.cancelAlarm(this);
                return true;
        }
        return false;
    }
}
