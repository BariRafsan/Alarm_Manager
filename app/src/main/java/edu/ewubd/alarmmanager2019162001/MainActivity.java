package edu.ewubd.alarmmanager2019162001;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText AddMinute,AddHour;
    private Button SetAlarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddMinute = findViewById(R.id.addMinute);
        AddHour = findViewById(R.id.addHour);
        SetAlarm = findViewById(R.id.setAlarmBtn);




        SetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = Integer.parseInt(AddHour.getText().toString());
                int min = Integer.parseInt(AddMinute.getText().toString());

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

                intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,min);
                ArrayList<Integer> days = new ArrayList<Integer>();
                days.add(Calendar.SATURDAY);
                days.add(Calendar.MONDAY);



                intent.putExtra(AlarmClock.EXTRA_DAYS,days);

                if (hour <=24 && min <=60) {
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}