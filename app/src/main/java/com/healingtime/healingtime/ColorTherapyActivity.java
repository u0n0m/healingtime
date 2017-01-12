package com.healingtime.healingtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import static com.healingtime.healingtime.R.drawable.color_therapy_off;
import static com.healingtime.healingtime.R.drawable.color_therapy_on;
import static com.healingtime.healingtime.R.drawable.run_time_on;

public class ColorTherapyActivity extends AppCompatActivity {
    boolean light_onoff = false;
    boolean alarm_onoff = false;
    //static final String [] color_therapy_alarm ;

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

    @Override
    protected void onResume() {
        super.onResume();

        String start_ampm = "오전", end_ampm ="오후";
        //ListView listview ;
        // Adapter 생성
        ColorAlarmListviewAdapter adapter;
        adapter = new ColorAlarmListviewAdapter() ;
        final ListView color_therapy_alarm_listview = (ListView) findViewById(R.id.color_therapy_alarm_listview);
        color_therapy_alarm_listview.setAdapter(adapter);


        SharedPreferences sp_color_settings = getApplicationContext().getSharedPreferences("ColorSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
        Integer color_order = sp_color_settings.getInt("color_order", 0);

        String [] colorAlarmSettings = {"ColorSettings1", "ColorSettings2","ColorSettings3", "ColorSettings4","ColorSettings5", "ColorSettings6"};

        if(color_order > 0  ) {
            for(int i=1; i <= color_order;i++){
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences(colorAlarmSettings[i-1], Context.MODE_PRIVATE); // 설정 정보 읽어오기
                Integer start_hour = sp_color_setting.getInt("start_hour", 1);  //시작시
                Integer start_minute = sp_color_setting.getInt("start_minute", 2); //시작분
                Integer end_hour = sp_color_setting.getInt("end_hour", 3); //종료시
                Integer end_minute = sp_color_setting.getInt("end_minute", 4); //종료분
                Integer week_sum = sp_color_setting.getInt("week_sum", 5); //분사 주기(요일)
                String week_sum_string = sp_color_setting.getString("week_sum_string", "월");
                Integer color_bright = sp_color_setting.getInt("color_bright", 7); // 향기종류. 사용안함
                Integer color_type = sp_color_setting.getInt("color_type", 8); // 잔여량
                String color_name = sp_color_setting.getString("color_name", "설정값 없음");

                if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
                else if(start_hour <= 12)  {start_ampm = "오전"; }
                if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
                else if(end_hour <= 12)  {end_ampm = "오전"; }

                adapter.addItem(start_ampm.toString(), start_hour.toString(), start_minute.toString(), end_ampm.toString(), end_hour.toString()
                        , end_minute.toString(), week_sum_string, color_bright, color_name, ContextCompat.getDrawable(this, run_time_on));
             }
//            adapter.addItem("오전", "7", "30", "오후", "2", "10", "월.수.금.", 7, "Orange", ContextCompat.getDrawable(this, R.drawable.run_time_on));
//            adapter.addItem("오전", "8", "30", "오후", "2", "10", "화.목.토.", 5, "Yello", ContextCompat.getDrawable(this, R.drawable.run_time_on));
        }
        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.

        color_therapy_alarm_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ColorAlarmListviewItem item = (ColorAlarmListviewItem) parent.getItemAtPosition(position) ;

//                String titleStr = item.getTitle() ;
//                String descStr = item.getDesc() ;

                // TODO : use item data.
            }
        }) ;
    }
}
