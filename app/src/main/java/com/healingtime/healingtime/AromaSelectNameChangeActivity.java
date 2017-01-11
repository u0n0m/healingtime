package com.healingtime.healingtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class AromaSelectNameChangeActivity extends AppCompatActivity {
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aroma_select_namechange);

        SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("AromaSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
        String aroma_a_name = sp_aroma_settings.getString("aroma_a_name", "설정값 없음");
        String aroma_b_name = sp_aroma_settings.getString("aroma_b_name", "설정값 없음");
        String aroma_c_name = sp_aroma_settings.getString("aroma_c_name", "설정값 없음");

        ImageView aroma_select_image_a = (ImageView) findViewById(R.id.aroma_select_image_a);
        String resName1 = "@drawable/aroma_" + aroma_a_name;
        int resID1 = getResources().getIdentifier(resName1, "drawable", "com.healingtime.healingtime");
        aroma_select_image_a.setImageResource(resID1);
        GradientDrawable drawable= (GradientDrawable) getDrawable(R.drawable.background_rounding);
        aroma_select_image_a.setBackground(new ShapeDrawable(new OvalShape()));
        aroma_select_image_a.setClipToOutline(true);

        ImageView aroma_select_image_b = (ImageView) findViewById(R.id.aroma_select_image_b);
        String resName2 = "@drawable/aroma_" + aroma_b_name;
        int resID2 = getResources().getIdentifier(resName2, "drawable", "com.healingtime.healingtime");
        aroma_select_image_b.setImageResource(resID2);
        GradientDrawable drawable2= (GradientDrawable) getDrawable(R.drawable.background_rounding);
        aroma_select_image_b.setBackground(new ShapeDrawable(new OvalShape()));
        aroma_select_image_b.setClipToOutline(true);

        ImageView aroma_select_image_c = (ImageView) findViewById(R.id.aroma_select_image_c);
        String resName3 = "@drawable/aroma_" + aroma_c_name;
        int resID3 = getResources().getIdentifier(resName3, "drawable", "com.healingtime.healingtime");
        aroma_select_image_c.setImageResource(resID3);
        GradientDrawable drawable3= (GradientDrawable) getDrawable(R.drawable.background_rounding);
        aroma_select_image_c.setBackground(new ShapeDrawable(new OvalShape()));
        aroma_select_image_c.setClipToOutline(true);

        Button aroma_therapy_time_settings_cancel = (Button) findViewById(R.id.aroma_select_cancel);
        aroma_therapy_time_settings_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Button aroma_therapy_time_settings_save = (Button) findViewById(R.id.aroma_select_save);
        aroma_therapy_time_settings_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton aroma_therapy_radiobutton_a = (RadioButton) findViewById(R.id.aroma_therapy_radiobutton_a);
                RadioButton aroma_therapy_radiobutton_b  = (RadioButton) findViewById(R.id.aroma_therapy_radiobutton_b);
                RadioButton aroma_therapy_radiobutton_c = (RadioButton) findViewById(R.id.aroma_therapy_radiobutton_c);

                SharedPreferences sp_aroma_settings = getApplicationContext().getSharedPreferences("AromaSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
                SharedPreferences.Editor editor = sp_aroma_settings.edit(); //sharedPreference 내용 수정

                if(aroma_therapy_radiobutton_a.isChecked()){
                    editor.putString("aroma_a_name","basil"); //아로마 B구간의 향기 이름 저장
                    editor.commit();
                }
                else if(aroma_therapy_radiobutton_b.isChecked()){
                    editor.putString("aroma_b_name","bergamot_calabrian"); //아로마 B구간의 향기 이름 저장
                    editor.commit();
                }
                else if(aroma_therapy_radiobutton_c.isChecked()){
                    editor.putString("aroma_c_name","cedarwood_atlas"); //아로마 B구간의 향기 이름 저장
                    editor.commit();
                }
                onBackPressed();
            }
        });
    }
}
