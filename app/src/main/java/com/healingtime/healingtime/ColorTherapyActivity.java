package com.healingtime.healingtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.healingtime.healingtime.R.drawable.color_therapy_off;
import static com.healingtime.healingtime.R.drawable.color_therapy_on;

public class ColorTherapyActivity extends AppCompatActivity {
    boolean light_onoff = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colortherapy_main);

        final ImageButton color_therapy_onoff_btn = (ImageButton) findViewById(R.id.color_therapy_onoff_btn);
        color_therapy_onoff_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
                if(light_onoff == true){
                    color_therapy_onoff_btn.setImageResource(color_therapy_off);
                    light_onoff = false;
                }else if(light_onoff == false){
                    color_therapy_onoff_btn.setImageResource(color_therapy_on);
                    light_onoff = true;
                }
            }
        });

        ImageButton color_therapy_timeset_btn = (ImageButton) findViewById(R.id.color_therapy_timeset_btn);
        color_therapy_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ColorSettingsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout color_therapy_bottom_to_color_therapy = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_color_therapy);
        color_therapy_bottom_to_color_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_aroma_therapy = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_aroma_therapy);
        color_therapy_bottom_to_aroma_therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_settings = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_settings);
        color_therapy_bottom_to_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        LinearLayout color_therapy_bottom_to_therapy_dictionary = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_therapy_dictionary);
        color_therapy_bottom_to_therapy_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
