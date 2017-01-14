package com.healingtime.healingtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import static com.healingtime.healingtime.R.drawable.run_time_on;

public class AromaTherapyActivity extends AppCompatActivity {
    boolean run_time_a_onoff = true, run_time_b_onoff = true, run_time_c_onoff = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aromatherapy_main);

        ImageView aroma_therapy_aroma_set_btn = (ImageView) findViewById(R.id.aroma_therapy_aroma_set_btn);
        aroma_therapy_aroma_set_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AromaSelectActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        ImageView aroma_therapy_aroma_remaining_btn = (ImageView) findViewById(R.id.aroma_therapy_aroma_remaining_btn);
        aroma_therapy_aroma_remaining_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), AromaRemainActivity.class);
                startActivity(intent);
            }
        });
        ImageView aroma_therapy_spray_btn = (ImageView) findViewById(R.id.aroma_therapy_spray_btn);
        aroma_therapy_spray_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "분사버튼 터치됨!", Toast.LENGTH_SHORT).show();
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

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        super.onResume();

        String start_ampm = "오전", end_ampm ="오후";
        //ListView listview ;
        // Adapter 생성
        aromaAlarmListviewAdapter adapter;
        adapter = new aromaAlarmListviewAdapter() ;
        final ListView aroma_therapy_alarm_listview = (ListView) findViewById(R.id.aroma_therapy_alarm_listview);
        aroma_therapy_alarm_listview.setAdapter(adapter);

        SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
        Integer aroma_order = sp_aroma_settings.getInt("aroma_order", 0);

        String [] aromaAlarmSettings = {"aromaSettings1", "aromaSettings2","aromaSettings3", "aromaSettings4","aromaSettings5", "aromaSettings6", "aromaSettings7", "aromaSettings8", "aromaSettings9", "aromaSettings10"};

        if(aroma_order > 0  ) {
            for(int i=1; i <= aroma_order;i++){
                SharedPreferences sp_aroma_setting = getApplicationContext().getSharedPreferences(aromaAlarmSettings[i-1], Context.MODE_PRIVATE); // 설정 정보 읽어오기
                Integer aroma_type = sp_aroma_setting.getInt("aroma_type", 0);  //예약된 아로마 구간(A->0x02, B->0x03, C->0x04)
                Integer start_hour = sp_aroma_setting.getInt("start_hour", 1);  //시작 시
                Integer start_minute = sp_aroma_setting.getInt("start_minute", 2); //시작 분
                Integer end_hour = sp_aroma_setting.getInt("end_hour", 3); //종료 시
                Integer end_minute = sp_aroma_setting.getInt("end_minute", 4); //종료 분
                Integer week_sum = sp_aroma_setting.getInt("week_sum", 5); //분사 주기(요일)
                Integer repeat_cycle = sp_aroma_setting.getInt("repeat_cycle", 6); // 분사 주기(분)
                Integer remain_amount = sp_aroma_setting.getInt("remain_amount", 7); //잔여량
                //Integer spray_now = sp_aroma_setting.getInt("spray_now", 8);

                //24시 형식의 시간값을 오전/오후 형식으로 변경
                if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
                else if(start_hour <= 12)  {start_ampm = "오전"; }
                if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
                else if(end_hour <= 12)  {end_ampm = "오전"; }

                //작동 요일 값(비트)을 문자열로 변경
                byte sunday_bit = 0x40 , monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
                String week_sum_string = "";
                if((week_sum & sunday_bit) == 0x40 ) { week_sum_string += "일."; }
                if((week_sum & monday_bit) == 0x20 ) { week_sum_string += "월."; }
                if((week_sum & tuesday_bit) == 0x10 ) { week_sum_string += "화."; }
                if((week_sum & wednesday_bit) == 0x08 ) { week_sum_string += "수."; }
                if((week_sum & thursday_bit) == 0x04 ) { week_sum_string += "목."; }
                if((week_sum & friday_bit) == 0x02 ) { week_sum_string += "금."; }
                if((week_sum & saturday_bit) == 0x01 ) { week_sum_string += "토."; }

                adapter.addItem(aroma_type, start_ampm.toString(), start_hour.toString(), start_minute.toString(), end_ampm.toString(), end_hour.toString(), end_minute.toString()
                        , week_sum_string, repeat_cycle, remain_amount, ContextCompat.getDrawable(this, run_time_on));
            }
        }

        aroma_therapy_alarm_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ColorAlarmListviewItem item = (ColorAlarmListviewItem) parent.getItemAtPosition(position) ;
            }
        }) ;
    }
}
