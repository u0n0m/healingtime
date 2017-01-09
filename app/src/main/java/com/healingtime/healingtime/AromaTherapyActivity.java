package com.healingtime.healingtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
                Toast.makeText(getApplicationContext(), "분사버튼 터치됨!", Toast.LENGTH_SHORT).show();
                //((MainActivity)MainActivity.mContext).sendData("Aroma");
                int finchk = 254;
                byte fin = (byte)finchk;
                //byte [] color_set = {0x10, 0x11, 0x0e, 0x0a, 0x0e, 0x1e, 0x7e, 0x05, 0x02, 0x22, 0x67, 0x0a, fin};
                byte [] aroma_set = {0x10, 0x12, 0x0c, 0x2d, 0x0d, 0x00, 0x54, 0x78, 0x07, 0x00, 0x00, 0x00, fin};
                try {
                    ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
                }catch(Exception  e){
                    e.printStackTrace();
                }
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        ImageView aroma_therapy_aroma_timeset_btn = (ImageView) findViewById(R.id.aroma_therapy_aroma_timeset_btn);
        aroma_therapy_aroma_timeset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaSettingsActivity.class);
                int requestCode=1;
                startActivityForResult(intent, requestCode);
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout color_box1 = (RelativeLayout) findViewById(R.id.color_box1);
        color_box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout color_box2 = (RelativeLayout) findViewById(R.id.color_box2);
        color_box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout color_box3 = (RelativeLayout) findViewById(R.id.color_box3);
        color_box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("AromaSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
        if(sp_aroma_settings.getBoolean("aroma_a_type", false) ) {
            Integer start_hour = sp_aroma_settings.getInt("aroma_a_data1", 1);
            Integer start_minute = sp_aroma_settings.getInt("aroma_a_data2", 2);
            Integer stop_hour = sp_aroma_settings.getInt("aroma_a_data3", 3);
            Integer stop_minute = sp_aroma_settings.getInt("aroma_a_data4", 4);
            Integer cycle_week = sp_aroma_settings.getInt("aroma_a_data5", 5);
            Integer cycle_time = sp_aroma_settings.getInt("aroma_a_data6", 6);
            Integer aroma_type = sp_aroma_settings.getInt("aroma_a_data7", 7);
            Integer aroma_remain = sp_aroma_settings.getInt("aroma_a_data8", 8);

            RelativeLayout aroma_therapy_setting_value_a = (RelativeLayout) findViewById(R.id.aroma_therapy_setting_value_a);  //설정값 표시 화면 다시 보이게 만들기
            aroma_therapy_setting_value_a.setVisibility(View.VISIBLE);

            TextView aroma_therapy_setting_a_time = (TextView) findViewById(R.id.aroma_therapy_setting_a_time);  //설
            String set1 = start_hour.toString() + ":" + start_minute.toString() + "~" + stop_hour.toString() + ":" + stop_minute.toString();
            aroma_therapy_setting_a_time.setText(set1);
        }
    }
}
