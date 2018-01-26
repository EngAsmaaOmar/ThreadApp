package com.example.omar.threadapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Activity MyActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyActivity = this;


    }
    myfristthread t1;
    myfristthread2 t2;
    public void buRun(View view) {
         t1 = new myfristthread();
        t1.start();
        t2 = new myfristthread2();
        t2.start();
    }


    public void buStop(View view) {
        t1.stop();
        t2.stop();
    }

    public void buMessage(View view) {
        Toast.makeText(this, "Thread in running", Toast.LENGTH_SHORT).show();
    }

    class myfristthread extends Thread {
        int x = 0;
        final TextView txtlat = (TextView) findViewById(R.id.show_lat);

        public void run() {
            while (true) {
                MyActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtlat.setText(String.valueOf(x));
                    }
                });
                x++;
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
        }
    }


    class myfristthread2 extends Thread {
        int x = 0;
        final TextView txtlog = (TextView) findViewById(R.id.show_log);

        public void run() {
            while (true) {
                MyActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtlog.setText(String.valueOf(x));
                    }
                });
                x++;
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
        }
    }
}
