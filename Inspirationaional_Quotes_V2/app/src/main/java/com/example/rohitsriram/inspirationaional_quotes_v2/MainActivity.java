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

        TextView textView = (TextView) findViewById(R.id.textView);

        DailyQuote dq = new DailyQuote(getResources().getStringArray(R.array.Quotes));
        textView.setText(dq.getDailyQuote());

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
