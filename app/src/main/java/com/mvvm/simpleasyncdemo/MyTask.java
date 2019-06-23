package com.mvvm.simpleasyncdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class MyTask extends AsyncTask<Void,Integer,String> {
    Context context;
    TextView StatusLable;
    Button StartDownload;
    ProgressDialog progressDialog;

    public MyTask(Context context, TextView statusLable, Button startDownload) {
        this.context = context;
        StatusLable = statusLable;
        StartDownload = startDownload;
    }

    @Override
    protected String doInBackground(Void... voids) {
        int i= 0;

        synchronized(this){

            while (i<10){

                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Download Complete....";
    }

    @Override
    protected void onPreExecute() {
       progressDialog = new ProgressDialog(context);
       progressDialog.setTitle("Download in Progress...");
       progressDialog.setMax(10);
       progressDialog.setProgress(0);
       progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       progressDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {
       StatusLable.setText(result);
       StartDownload.setEnabled(true);
       progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
       int process= values[0];
       progressDialog.setProgress(process);
       StatusLable.setText("Download in progress....");

    }
}
