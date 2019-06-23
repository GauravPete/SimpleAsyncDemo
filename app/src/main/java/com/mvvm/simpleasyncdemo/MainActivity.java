package com.mvvm.simpleasyncdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView StatusLable;
    Button StartDownload;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusLable = findViewById(R.id.txtStatusText);
        StartDownload = findViewById(R.id.btnStartDownload);

        StartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask(context,StatusLable,StartDownload);
                myTask.execute();
                StartDownload.setEnabled(false);
            }
        });


    }
}
