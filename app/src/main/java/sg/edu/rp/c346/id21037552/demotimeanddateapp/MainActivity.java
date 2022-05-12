package sg.edu.rp.c346.id21037552.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    //Declaring of variables
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //2 - bridge UI with controller
    dp = findViewById(R.id.datePicker);
    tp = findViewById(R.id.timePicker);
    btnDisplayDate = findViewById(R.id.buttonDisplayDate);
    btnDisplayTime = findViewById(R.id.buttonDisplayTIme);
    tvDisplay = findViewById(R.id.textViewDisplay);
    btnReset = findViewById(R.id.buttonReset);

    //3 - set event listener
        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Time is";
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                if (min < 10 ) {
                    msg = msg + hour + ":0" + min;
                } else {
                    msg = msg + hour + ":" + min;
                }
                tvDisplay.setText(msg);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Date is ";
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                msg = msg + day + "/" + month + "/" + year;
                tvDisplay.setText(msg);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dp.updateDate(2020,0,0+1);
               tp.setCurrentHour(0);
               tp.setCurrentMinute(0);
            }
        });

    }
}