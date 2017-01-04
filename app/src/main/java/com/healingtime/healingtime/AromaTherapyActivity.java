package com.healingtime.healingtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AromaTherapyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aromatherapy_main);

        ImageView aroma_therapy_aroma_set_btn = (ImageView) findViewById(R.id.aroma_therapy_aroma_set_btn);
        aroma_therapy_aroma_set_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        ImageView aroma_therapy_aroma_remaining_btn = (ImageView) findViewById(R.id.aroma_therapy_aroma_remaining_btn);
        aroma_therapy_aroma_remaining_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        ImageView aroma_therapy_spray_btn = (ImageView) findViewById(R.id.aroma_therapy_spray_btn);
        aroma_therapy_spray_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        ImageView aroma_therapy_aroma_timeset_btn = (ImageView) findViewById(R.id.aroma_therapy_aroma_timeset_btn);
        aroma_therapy_aroma_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout color_box1 = (RelativeLayout) findViewById(R.id.color_box1);
        aroma_therapy_aroma_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout color_box2 = (RelativeLayout) findViewById(R.id.color_box2);
        aroma_therapy_aroma_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout color_box3 = (RelativeLayout) findViewById(R.id.color_box3);
        aroma_therapy_aroma_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
