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
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.healingtime.healingtime.R.drawable.color_blue;
import static com.healingtime.healingtime.R.drawable.color_green;
import static com.healingtime.healingtime.R.drawable.color_orange;
import static com.healingtime.healingtime.R.drawable.color_red;
import static com.healingtime.healingtime.R.drawable.color_therapy_off;
import static com.healingtime.healingtime.R.drawable.color_therapy_on;
import static com.healingtime.healingtime.R.drawable.color_yellow;
import static com.healingtime.healingtime.R.drawable.run_time_on;

public class ColorTherapyActivity extends AppCompatActivity {
    boolean light_onoff = false;
    private Integer color_type = 1; //Color 종류 1.RED 2. Orange 3.Yellow 4.Green 5.Blue 6.USER
    private Integer color_bright = 5;
    RadioGroup color_radio_group1, color_radio_group2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colortherapy_main);

        color_radio_group1 = (RadioGroup) findViewById(R.id.color_radio_group1);
        color_radio_group2 = (RadioGroup) findViewById(R.id.color_radio_group2);
        color_radio_group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.color_box1:
                        color_type = 1;
                        color_radio_group2.clearCheck();
                        break;
                    case R.id.color_box2:
                        color_type = 2;
                        color_radio_group2.clearCheck();
                        break;
                    case R.id.color_box3:
                        color_type = 3;
                        color_radio_group2.clearCheck();
                        break;
                    default:
                        //Toast.makeText(getApplicationContext(), "radio btn select plz", Toast.LENGTH_SHORT).show();
                }
            }
        });
        color_radio_group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.color_box4:
                        color_type = 4;
                        color_radio_group1.clearCheck();
                        break;
                    case R.id.color_box5:
                        color_type = 5;
                        color_radio_group1.clearCheck();
                        break;
                    case R.id.color_box6:
                        color_type = 6;
                        color_radio_group1.clearCheck();
                        break;
                    default:
                        //Toast.makeText(getApplicationContext(), "radio btn select plz", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //밝기 값을 textview에 설정
        SeekBar seekbar_bright = (SeekBar) findViewById(R.id.seekbar_bright);
        seekbar_bright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int bright, boolean fromUser){
                color_bright = bright;
                TextView seekbar_bright_value = (TextView) findViewById(R.id.seekbar_bright_value);
                seekbar_bright_value.setText(color_bright.toString());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });

        final ImageButton color_therapy_lighton_now_btn = (ImageButton) findViewById(R.id.color_therapy_lighton_now_btn);
        color_therapy_lighton_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
                if(light_onoff == true){
                    color_therapy_lighton_now_btn.setImageResource(color_therapy_off);
                    light_onoff = false;
                    int week_sum_temp = 0x2A;
                    byte week_sum = (byte)week_sum_temp;
                    int color_bright_now_temp = color_bright;
                    byte color_bright_now = (byte) color_bright_now_temp;
                    int lighton_now_temp = (0x20 | color_type);
                    byte lighton_now = (byte) lighton_now_temp;
                    int finchk = 254;   byte fin = (byte)finchk;
                    byte [] lighton_pkt = {0x10, 0x11, 0x00, 0x00, 0x00, 0x00, week_sum, color_bright_now, 0x00, 0x00, 0x00, lighton_now, fin};
                    try {
                        ((MainActivity) MainActivity.mContext).mOutputStream.write(lighton_pkt);
                    }catch(Exception  e){
                        e.printStackTrace();
                    }
                }else if(light_onoff == false){
                    color_therapy_lighton_now_btn.setImageResource(color_therapy_on);
                    light_onoff = true;
                    int week_sum_temp = 0x2A;
                    byte week_sum = (byte)week_sum_temp;
                    int lighton_now_temp = (0x30 | color_type);
                    byte lighton_now = (byte) lighton_now_temp;
                    int color_bright_now_temp = color_bright;
                    byte color_bright_now = (byte) color_bright_now_temp;
                    int finchk = 254;   byte fin = (byte)finchk;
                    byte [] lighton_pkt = {0x10, 0x11, 0x00, 0x00, 0x00, 0x00, week_sum, color_bright_now, 0x00, 0x00, 0x00, lighton_now, fin};
                    try {
                        ((MainActivity) MainActivity.mContext).mOutputStream.write(lighton_pkt);
                    }catch(Exception  e){
                        e.printStackTrace();
                    }
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

/*        LinearLayout color_therapy_bottom_to_color_therapy = (LinearLayout) findViewById(R.id.color_therapy_bottom_to_color_therapy);
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
        });*/

        //하단 바 클릭 이벤트 처리
        LinearLayout link_color_therapy = (LinearLayout)findViewById(R.id.link_color_therapy);
        link_color_therapy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), ColorTherapyActivity.class);
//                startActivity(intent);
            }
        });
        LinearLayout link_aroma_therapy = (LinearLayout)findViewById(R.id.link_aroma_therapy);
        link_aroma_therapy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AromaTherapyActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout link_dictionary = (LinearLayout)findViewById(R.id.link_dictionary);
        link_dictionary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TherapyDictionaryActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout link_settings = (LinearLayout)findViewById(R.id.link_settings);
        link_settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_SHORT).show();
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

        String [] colorAlarmSettings = {"ColorSettings1", "ColorSettings2","ColorSettings3", "ColorSettings4","ColorSettings5", "ColorSettings6", "ColorSettings7", "ColorSettings8", "ColorSettings9", "ColorSettings10"};

        if(color_order > 0  ) {
            for(int i=1; i <= color_order;i++){
                SharedPreferences sp_color_setting = getApplicationContext().getSharedPreferences(colorAlarmSettings[i-1], Context.MODE_PRIVATE); // 설정 정보 읽어오기
                Integer start_hour = sp_color_setting.getInt("start_hour", 1);  //시작시
                Integer start_minute = sp_color_setting.getInt("start_minute", 2); //시작분
                Integer end_hour = sp_color_setting.getInt("end_hour", 3); //종료시
                Integer end_minute = sp_color_setting.getInt("end_minute", 4); //종료분
                Integer week_sum = sp_color_setting.getInt("week_sum", 5); //분사 주기(요일)
                Integer color_bright = sp_color_setting.getInt("color_bright", 7); // 밝기
                Integer color_type = sp_color_setting.getInt("color_type", 8); //색깔

                //24시 형식의 시간값을 오전/오후 형식으로 변경
                if(start_hour > 12) {start_hour -= 12; start_ampm = "오후"; }
                else if(start_hour <= 12)  {start_ampm = "오전"; }
                if(end_hour > 12) {end_hour -= 12; end_ampm = "오후"; }
                else if(end_hour <= 12)  {end_ampm = "오전"; }

                //작동 요일 값(비트)을 문자열로 변경
                byte montosun_bit = 0x7F; //월요일부터 일요일까지 모두 설정한 경우
                byte montosatur_bit = 0x3F; //월요일부터 토요일까지 모두 설정한 경우
                byte montofri_bit = 0x3E; //월요일부터 금요일까지 모두 설정한 경우
                byte sunday_bit = 0x40 , monday_bit = 0x20, tuesday_bit = 0x10, wednesday_bit = 0x08, thursday_bit = 0x04, friday_bit = 0x02, saturday_bit = 0x01;
                String week_sum_string = "반복: ";
                if((week_sum & sunday_bit) == 0x40 ) { week_sum_string += "일."; }
                if((week_sum & monday_bit) == 0x20 ) { week_sum_string += "월."; }
                if((week_sum & tuesday_bit) == 0x10 ) { week_sum_string += "화."; }
                if((week_sum & wednesday_bit) == 0x08 ) { week_sum_string += "수."; }
                if((week_sum & thursday_bit) == 0x04 ) { week_sum_string += "목."; }
                if((week_sum & friday_bit) == 0x02 ) { week_sum_string += "금."; }
                if((week_sum & saturday_bit) == 0x01 ) { week_sum_string += "토."; }
                week_sum_string += "요일";
                if((week_sum & montosun_bit) == 0x7F ) { week_sum_string = "반복: 월 ~ 일요일"; }
                if((week_sum & montosun_bit) == 0x3F ) { week_sum_string = "반복: 월 ~ 토요일"; }
                if((week_sum & montosun_bit) == 0x3E ) { week_sum_string = "반복: 월 ~ 금요일"; }

                String color_desc = "";
                Integer color_view = color_green;
                switch(color_type){
                    case 1:
                        color_desc = "무기력, 의기소침";
                        color_view = color_red;
                        break;
                    case 2:
                        color_desc = "피로저하, 식용상승, 기분전환";
                        color_view = color_orange;
                        break;
                    case 3:
                        color_desc = "두뇌활동 자극, 활기넘침";
                        color_view = color_yellow;
                        break;
                    case 4:
                        color_desc = "근육/눈피로, 몸의 균형";
                        color_view = color_green;
                        break;
                    case 5:
                        color_desc = "집중/창의력 향상, 마음안정";
                        color_view = color_blue;
                        break;
                }
                adapter.addItem(start_ampm.toString(), start_hour.toString(), start_minute.toString(), end_ampm.toString(), end_hour.toString(), end_minute.toString()
                        , week_sum_string, color_bright, color_desc, ContextCompat.getDrawable(this, color_view), ContextCompat.getDrawable(this, run_time_on));
             }
        }

        color_therapy_alarm_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ColorAlarmListviewItem item = (ColorAlarmListviewItem) parent.getItemAtPosition(position) ;
            }
        }) ;
    }
}
