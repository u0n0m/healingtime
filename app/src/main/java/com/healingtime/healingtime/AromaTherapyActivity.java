package com.healingtime.healingtime;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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
                Intent intent = new Intent(getApplicationContext(), AromaSelectActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
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
        RelativeLayout aroma_box1 = (RelativeLayout) findViewById(R.id.aroma_box1);
        aroma_box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout aroma_box2 = (RelativeLayout) findViewById(R.id.aroma_box2);
        aroma_box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
            }
        });
        RelativeLayout aroma_box3 = (RelativeLayout) findViewById(R.id.aroma_box3);
        aroma_box3.setOnClickListener(new View.OnClickListener() {
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
            Integer start_hour = sp_aroma_settings.getInt("aroma_a_data1", 1);  //시작시
            Integer start_minute = sp_aroma_settings.getInt("aroma_a_data2", 2); //시작분
            Integer end_hour = sp_aroma_settings.getInt("aroma_a_data3", 3); //종료시
            Integer end_minute = sp_aroma_settings.getInt("aroma_a_data4", 4); //종료분
            Integer cycle_week = sp_aroma_settings.getInt("aroma_a_data5", 5); //분사 주기(요일)
            String cycle_week_string = sp_aroma_settings.getString("aroma_a_data5_1", "월");
            Integer cycle_time = sp_aroma_settings.getInt("aroma_a_data6", 6); //분사주기 (분)
            Integer aroma_type = sp_aroma_settings.getInt("aroma_a_data7", 7); // 향기종료. 사용안함
            Integer aroma_remain = sp_aroma_settings.getInt("aroma_a_data8", 8); // 잔여량
            String aroma_a_name = sp_aroma_settings.getString("aroma_a_name", "설정값 없음");

            RelativeLayout aroma_box1 = (RelativeLayout) findViewById(R.id.aroma_box1);
            String resName1 = "@drawable/aroma_" + aroma_a_name;
            int resID1 = getResources().getIdentifier(resName1, "drawable", "com.healingtime.healingtime");
            aroma_box1.setBackgroundResource(resID1);

            ImageView aroma_status_image1 = (ImageView) findViewById(R.id.aroma_status_image1);
            String resName2 = "@drawable/aroma_" + aroma_a_name;
            int resID2 = getResources().getIdentifier(resName2, "drawable", "com.healingtime.healingtime");
            aroma_status_image1.setImageResource(resID2);

            RelativeLayout aroma_therapy_setting_value_a = (RelativeLayout) findViewById(R.id.aroma_therapy_setting_value_a);  //설정값 표시 화면 다시 보이게 만들기
            aroma_therapy_setting_value_a.setVisibility(View.VISIBLE);

            TextView aroma_therapy_setting_a_time = (TextView) findViewById(R.id.aroma_therapy_setting_a_time);  //설
            String start_ampm ="오전";
            String end_ampm ="오전";
            if(start_hour >= 13) { start_ampm = "오후"; start_hour -= 12;}
            if(end_hour >= 13) { end_ampm = "오후"; end_hour -= 12;}
            String set1 = start_ampm + " " + start_hour.toString() + ":" + start_minute.toString() + " ~ " + end_ampm + " " + end_hour.toString() + ":" + end_minute.toString();
            aroma_therapy_setting_a_time.setText(set1);

            TextView aroma_therapy_setting_a_aroma = (TextView) findViewById(R.id.aroma_therapy_setting_a_aroma);  //설
            String set2 = "향기이름: Basil" ;
            aroma_therapy_setting_a_aroma.setText(set2);

            TextView aroma_therapy_setting_a_repeat = (TextView) findViewById(R.id.aroma_therapy_setting_a_repeat);  //설
            String set3 = cycle_week_string + "   주기: " + cycle_time.toString() + "분";
            aroma_therapy_setting_a_repeat.setText(set3);
        }
        if(sp_aroma_settings.getBoolean("aroma_b_type", false) ) {
            Integer start_hour = sp_aroma_settings.getInt("aroma_b_data1", 1);  //시작시
            Integer start_minute = sp_aroma_settings.getInt("aroma_b_data2", 2); //시작분
            Integer end_hour = sp_aroma_settings.getInt("aroma_b_data3", 3); //종료시
            Integer end_minute = sp_aroma_settings.getInt("aroma_b_data4", 4); //종료분
            Integer cycle_week = sp_aroma_settings.getInt("aroma_b_data5", 5); //분사 주기(요일)
            String cycle_week_string = sp_aroma_settings.getString("aroma_b_data5_1", "월");
            Integer cycle_time = sp_aroma_settings.getInt("aroma_b_data6", 6); //분사주기 (분)
            Integer aroma_type = sp_aroma_settings.getInt("aroma_b_data7", 7); // 향기종료. 사용안함
            Integer aroma_remain = sp_aroma_settings.getInt("aroma_b_data8", 8); // 잔여량
            String aroma_b_name = sp_aroma_settings.getString("aroma_b_name", "설정값 없음");

            RelativeLayout aroma_box2 = (RelativeLayout) findViewById(R.id.aroma_box2);
            String resName1 = "@drawable/aroma_" + aroma_b_name;
            int resID1 = getResources().getIdentifier(resName1, "drawable", "com.healingtime.healingtime");
            aroma_box2.setBackgroundResource(resID1);

            ImageView aroma_status_image1 = (ImageView) findViewById(R.id.aroma_status_image1);
            String resName2 = "@drawable/aroma_" + aroma_b_name;
            int resID2 = getResources().getIdentifier(resName2, "drawable", "com.healingtime.healingtime");
            aroma_status_image1.setImageResource(resID2);

            RelativeLayout aroma_therapy_setting_value_b = (RelativeLayout) findViewById(R.id.aroma_therapy_setting_value_b);  //설정값 표시 화면 다시 보이게 만들기
            aroma_therapy_setting_value_b.setVisibility(View.VISIBLE);

            TextView aroma_therapy_setting_b_time = (TextView) findViewById(R.id.aroma_therapy_setting_b_time);  //설
            String start_ampm ="오전";
            String end_ampm ="오전";
            if(start_hour >= 13) { start_ampm = "오후"; start_hour -= 12;}
            if(end_hour >= 13) { end_ampm = "오후"; end_hour -= 12;}
            String set1 = start_ampm + " " + start_hour.toString() + ":" + start_minute.toString() + " ~ " + end_ampm + " " + end_hour.toString() + ":" + end_minute.toString();
            aroma_therapy_setting_b_time.setText(set1);

            TextView aroma_therapy_setting_b_aroma = (TextView) findViewById(R.id.aroma_therapy_setting_b_aroma);  //설
            String set2 = "향기이름: Basil" ;
            aroma_therapy_setting_b_aroma.setText(set2);

            TextView aroma_therapy_setting_b_repeat = (TextView) findViewById(R.id.aroma_therapy_setting_b_repeat);  //설
            String set3 = cycle_week_string + "   주기: " + cycle_time.toString() + "분";
            aroma_therapy_setting_b_repeat.setText(set3);
        }
        if(sp_aroma_settings.getBoolean("aroma_c_type", false) ) {
            Integer start_hour = sp_aroma_settings.getInt("aroma_c_data1", 1);  //시작시
            Integer start_minute = sp_aroma_settings.getInt("aroma_c_data2", 2); //시작분
            Integer end_hour = sp_aroma_settings.getInt("aroma_c_data3", 3); //종료시
            Integer end_minute = sp_aroma_settings.getInt("aroma_c_data4", 4); //종료분
            Integer cycle_week = sp_aroma_settings.getInt("aroma_c_data5", 5); //분사 주기(요일)
            String cycle_week_string = sp_aroma_settings.getString("aroma_c_data5_1", "월");
            Integer cycle_time = sp_aroma_settings.getInt("aroma_c_data6", 6); //분사주기 (분)
            Integer aroma_type = sp_aroma_settings.getInt("aroma_c_data7", 7); // 향기종료. 사용안함
            Integer aroma_remain = sp_aroma_settings.getInt("aroma_c_data8", 8); // 잔여량
            String aroma_c_name = sp_aroma_settings.getString("aroma_c_name", "설정값 없음");

            RelativeLayout aroma_box3 = (RelativeLayout) findViewById(R.id.aroma_box3);
            String resName1 = "@drawable/aroma_" + aroma_c_name;
            int resID1 = getResources().getIdentifier(resName1, "drawable", "com.healingtime.healingtime");
            aroma_box3.setBackgroundResource(resID1);

            ImageView aroma_status_image1 = (ImageView) findViewById(R.id.aroma_status_image1);
            String resName2 = "@drawable/aroma_" + aroma_c_name;
            int resID2 = getResources().getIdentifier(resName2, "drawable", "com.healingtime.healingtime");
            aroma_status_image1.setImageResource(resID2);

            RelativeLayout aroma_therapy_setting_value_c = (RelativeLayout) findViewById(R.id.aroma_therapy_setting_value_c);  //설정값 표시 화면 다시 보이게 만들기
            aroma_therapy_setting_value_c.setVisibility(View.VISIBLE);

            TextView aroma_therapy_setting_c_time = (TextView) findViewById(R.id.aroma_therapy_setting_c_time);  //설
            String start_ampm ="오전";
            String end_ampm ="오전";
            if(start_hour >= 13) { start_ampm = "오후"; start_hour -= 12;}
            if(end_hour >= 13) { end_ampm = "오후"; end_hour -= 12;}
            String set1 = start_ampm + " " + start_hour.toString() + ":" + start_minute.toString() + " ~ " + end_ampm + " " + end_hour.toString() + ":" + end_minute.toString();
            aroma_therapy_setting_c_time.setText(set1);

            TextView aroma_therapy_setting_c_aroma = (TextView) findViewById(R.id.aroma_therapy_setting_c_aroma);  //설
            String set2 = "향기이름: Basil" ;
            aroma_therapy_setting_c_aroma.setText(set2);

            TextView aroma_therapy_setting_c_repeat = (TextView) findViewById(R.id.aroma_therapy_setting_c_repeat);  //설
            String set3 = cycle_week_string + "   주기: " + cycle_time.toString() + "분";
            aroma_therapy_setting_c_repeat.setText(set3);
        }
    }

    private void ShowDialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.aroma_name_setting, null);
        final Dialog myDialog = new Dialog(this);

        myDialog.setTitle("대화상자 제목이다");
        myDialog.setContentView(dialogLayout);
        myDialog.show();

/*        Button btn_ok = (Button)dialogLayout.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button)dialogLayout.findViewById(R.id.btn_cancel);

        btn_ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //OK 누르면 할거
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myDialog.cancel();
            }
        });*/
    }
}
