package com.example.gogreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements Runnable {

      Button mbSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbSkip = findViewById(R.id.bSkip);
        mbSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });


        new Thread(this).start();

    }


    public void run() {
        try {

            Thread.sleep(5000);
            SharedPreferences preferences = getSharedPreferences("count", 0); // 存在则打开它，否则创建新的Preferences
            int count = preferences.getInt("count", 0); // 取出数据


            if (count == 0) {
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent1);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent2);
            }
            finish();


            SharedPreferences.Editor editor = preferences.edit();

            editor.putInt("count", 1); // 存入数据

            editor.commit();
        } catch (InterruptedException e) {

        }

    }
}


