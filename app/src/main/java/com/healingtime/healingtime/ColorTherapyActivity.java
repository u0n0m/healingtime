package com.healingtime.healingtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ColorTherapyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colortherapy_main);

        ImageButton color_therapy_onoff_btn = (ImageButton) findViewById(R.id.color_therapy_onoff_btn);
        color_therapy_onoff_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        ImageView color_therapy_timeset_btn = (ImageView) findViewById(R.id.color_therapy_timeset_btn);
        color_therapy_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_color_therapy = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_color_therapy);
        color_therapy_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_aroma_therapy = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_aroma_therapy);
        color_therapy_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_settings = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_settings);
        color_therapy_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_therapy_dictionary = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_therapy_dictionary);
        color_therapy_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
