package com.healingtime.healingtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class AromaSettingsActivity extends AppCompatActivity {
    private byte aroma_type;
    private Integer start_hour =6, start_minute=30, end_hour=19, end_minute=30;
    private Integer week_sum = 0;
    private String week_sum_string = "반복: ";
    private Integer cycle_time = 30;
    private Integer remain_amount;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_settings);

        TimePicker timepicker_starttime = (TimePicker) findViewById(R.id.timepicker_starttime);
        timepicker_starttime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker view, int  hourOfDay, int minute){
                start_hour = hourOfDay;
                start_minute = minute;
            }
        });

        TimePicker timepicker_endtime = (TimePicker) findViewById(R.id.timepicker_endtime);
        timepicker_endtime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker view, int  hourOfDay, int minute){
                end_hour = hourOfDay;
                end_minute = minute;
            }
        });

        ToggleButton aroma_toggle_sun = (ToggleButton) findViewById(R.id.aroma_toggle_sun);
        ToggleButton aroma_toggle_mon = (ToggleButton) findViewById(R.id.aroma_toggle_mon);
        ToggleButton aroma_toggle_tue = (ToggleButton) findViewById(R.id.aroma_toggle_tue);
        ToggleButton aroma_toggle_wed = (ToggleButton) findViewById(R.id.aroma_toggle_wed);
        ToggleButton aroma_toggle_thu = (ToggleButton) findViewById(R.id.aroma_toggle_thu);
        ToggleButton aroma_toggle_fri = (ToggleButton) findViewById(R.id.aroma_toggle_fri);
        ToggleButton aroma_toggle_sat = (ToggleButton) findViewById(R.id.aroma_toggle_sat);
        aroma_toggle_sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x40;
                week_sum_string += "일.";
            }
        });
        aroma_toggle_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x20;
                week_sum_string += "월.";
            }
        });
        aroma_toggle_tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x10;
                week_sum_string += "화.";
            }
        });
        aroma_toggle_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x08;
                week_sum_string += "수.";
            }
        });
        aroma_toggle_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x04;
                week_sum_string += "목.";
            }
        });
        aroma_toggle_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x02;
                week_sum_string += "금.";
            }
        });
        aroma_toggle_sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_sum += 0x01;
                week_sum_string +="토.";
            }
        });

        SeekBar seekbar_cycle_time = (SeekBar) findViewById(R.id.seekbar_cycle_time);
        seekbar_cycle_time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int time, boolean fromUser){
                cycle_time = time;
                EditText aroma_therapy_cycle_time = (EditText) findViewById(R.id.aroma_therapy_cycle_time);
                aroma_therapy_cycle_time.setText(cycle_time.toString() + "분");

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        ImageView aroma_settings_back_btn = (ImageView) findViewById(R.id.aroma_settings_back_btn);
        aroma_settings_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Button aroma_therapy_time_settings_cancel = (Button) findViewById(R.id.aroma_therapy_time_settings_cancel);
        aroma_therapy_time_settings_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Button aroma_therapy_time_settings_save = (Button) findViewById(R.id.aroma_therapy_time_settings_save);
        aroma_therapy_time_settings_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton aroma_therapy_radiobutton_a = (RadioButton) findViewById(R.id.aroma_therapy_radiobutton_a);
                RadioButton aroma_therapy_radiobutton_b  = (RadioButton) findViewById(R.id.aroma_therapy_radiobutton_b);
                RadioButton aroma_therapy_radiobutton_c = (RadioButton) findViewById(R.id.aroma_therapy_radiobutton_c);

                //기존 설정 정보 삭제(패킷으로 수신되는 내용으로 자동 갱신됨)
                SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("aromaSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
                Integer aroma_order = sp_aroma_settings.getInt("aroma_order", 0);
                //if(aroma_order == 0) {aroma_order += 1;}
                String [] aromaAlarmSettings = {"aromaSettings1", "aromaSettings2","aromaSettings3", "aromaSettings4","aromaSettings5", "aromaSettings6", "aromaSettings7", "aromaSettings8", "aromaSettings9", "aromaSettings10"};
                if(aroma_order > 0 ) {
                    for (int i = 1; i <= aroma_order; i++) {
                        SharedPreferences sp_aroma_setting = getApplicationContext().getSharedPreferences(aromaAlarmSettings[i - 1], Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp_aroma_settings.edit();
                        editor.clear();
                        editor.commit();
                    }
                    aroma_order = 0;
                    SharedPreferences.Editor editor1 = sp_aroma_settings.edit(); //sharedPreference 내용 수정
                    editor1.putInt("aroma_order", aroma_order); //칼라테라피 예약  번호
                    editor1.commit();
                }

                if(aroma_therapy_radiobutton_a.isChecked()){ aroma_type = 0x12; }
                else if(aroma_therapy_radiobutton_b.isChecked()){ aroma_type = 0x13; }
                else if(aroma_therapy_radiobutton_c.isChecked()){ aroma_type = 0x14; }

                //아로마 설정값 발향기로 전송
                int finchk = 254;
                int s_hour = start_hour, s_min=start_minute, e_hour = end_hour, e_min = end_minute, w_sum = week_sum, c_time = cycle_time;

                byte start_frame = (byte) 0x10; //프레임 시작
                byte type_frame = (byte) aroma_type;
                byte start_hour = (byte) s_hour;
                byte start_min = (byte) s_min;
                byte end_hour = (byte) e_hour;
                byte end_min = (byte) e_min;
                byte week_sum = (byte) w_sum;
                byte cycle_min = (byte) c_time;
                byte aroma_type = (byte) 0x00;  //향기종류 //현재 사용하지 않음 // 그냥 0으로 설정
                byte aroma_remain = (byte) 0xFF; // 잔여량
                byte padding = (byte) 0x00;  //단순 패딩임..
                byte fin_frame = (byte) finchk; // 프레임 종료
                byte [] aroma_set = {start_frame, type_frame, start_hour, start_min, end_hour, end_min, week_sum, cycle_min, aroma_type, aroma_remain, padding, padding, fin_frame};

                try {
                    ((MainActivity) MainActivity.mContext).mOutputStream.write(aroma_set);
                }catch(Exception  e){
                    e.printStackTrace();
                }
                onBackPressed();
            }
        });
    }
}
