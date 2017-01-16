package com.healingtime.healingtime;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by scr44 on 2017-01-10.
 */

public class TherapyDictionaryColorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_dictionary_color);

        String red = "Red: 빨강";
        SpannableStringBuilder ss_red = new SpannableStringBuilder(red);
        ss_red.setSpan(new RelativeSizeSpan(1.6f), 0, 5, 0); // set size
        ss_red.setSpan(new ForegroundColorSpan(Color.WHITE), 0, red.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// set color
        TextView t_red = (TextView) findViewById(R.id.color_dictionary_red);
        t_red.setText(ss_red);

        String red_contents = "식욕과 혈압을 왕성하게 해 주는 에너지의 색으로 교감신경을 자극하고 에너지를 끌어올려 주는 역할을 한다. 이 때문에 무기력하거나 의기소침한 사람, 극심한 피로에 시달리는 사람에게 적합한 색이다. 마음이 산만해지고 답답할 때는 피해야 한다.";
        SpannableStringBuilder ss_red_contents = new SpannableStringBuilder(red_contents);
        ss_red_contents.setSpan(new RelativeSizeSpan(1.0f), 0, red_contents.length(), 0);
        ss_red_contents.setSpan(new ForegroundColorSpan(Color.rgb(207,72,62)), 0, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_red_contents.setSpan(new ForegroundColorSpan(Color.rgb(207,72,62)), 65, 97, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_red_contents.setSpan(new ForegroundColorSpan(Color.rgb(207,72,62)), 109, 129, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView t_red_contents = (TextView)findViewById(R.id.color_dictionary_red_contents);
        t_red_contents.setText(ss_red_contents);

        String orange = "Orange : 주황";
        SpannableStringBuilder ss_orange = new SpannableStringBuilder(orange);
        ss_orange.setSpan(new RelativeSizeSpan(1.4f), 0,6, 0); // set size
        ss_orange.setSpan(new ForegroundColorSpan(Color.WHITE), 0, orange.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// set color
        TextView t_orange = (TextView) findViewById(R.id.color_dictionary_orange);
        t_orange.setText(ss_orange);
            //18,51/57,75/100,131
        String orange_contents = "빛의 파장이 비교적 깊기 때문에 아드레날린 분비를 활성화 시키고 피로와 무기력증 개선에 효과가 있다. 긍정적인 심리를 가지게 하는 주황은 기분 전환에 자주 이용되기도 하는 색으로 우울한 기분이 계속될 때, 입맛이 없을 때나 자극이 필요할 때 좋다.";
        SpannableStringBuilder ss_orange_contents = new SpannableStringBuilder(orange_contents);
        ss_orange_contents.setSpan(new RelativeSizeSpan(1.1f), 0, orange_contents.length(), 0);
        ss_orange_contents.setSpan(new ForegroundColorSpan(Color.rgb(211,128,41)), 18, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_orange_contents.setSpan(new ForegroundColorSpan(Color.rgb(211,128,41)), 57, 75, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_orange_contents.setSpan(new ForegroundColorSpan(Color.rgb(211,128,41)), 100, 131, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView t_orange_contents = (TextView)findViewById(R.id.color_dictionary_orange_contents);
        t_orange_contents.setText(ss_orange_contents);

        String yellow = "Yellow : 노랑";
        SpannableStringBuilder ss_yellow = new SpannableStringBuilder(yellow);
        ss_yellow.setSpan(new RelativeSizeSpan(1.4f), 0,6, 0); // set size
        ss_yellow.setSpan(new ForegroundColorSpan(Color.WHITE), 0, yellow.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// set color
        TextView t_yellow = (TextView) findViewById(R.id.color_dictionary_yellow);
        t_yellow.setText(ss_yellow);
        //18,51/57,75/100,131
        String yellow_contents = "친근함과 경쾌함을 가져다주는 노랑은 두뇌 활등을 자극하는 색으로 교감, 부교감 신경에 영향을 주고 신체의 모든 활동을 왕성하게 만들어 주는 효과가 있다. 밝은 에너지가 필요하거나 스스로 자존감이 낮다고 생각하는 사람에게 자신감과 낙천적인 태도를 갖게 해준다.";
        SpannableStringBuilder ss_yellow_contents = new SpannableStringBuilder(yellow_contents);
        ss_yellow_contents.setSpan(new RelativeSizeSpan(1.1f), 0, yellow_contents.length(), 0);
        ss_yellow_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#D7CF01")), 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_yellow_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#D7CF01")), 55, 80, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_yellow_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#D7CF01")), 100, 120, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView t_yellow_contents = (TextView)findViewById(R.id.color_dictionary_yellow_contents);
        t_yellow_contents.setText(ss_yellow_contents);

        String green = "Green : 초록";
        SpannableStringBuilder ss_green = new SpannableStringBuilder(green);
        ss_green.setSpan(new RelativeSizeSpan(1.4f), 0, 5, 0); // set size
        ss_green.setSpan(new ForegroundColorSpan(Color.WHITE), 0, green.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// set color
        TextView t_green = (TextView) findViewById(R.id.color_dictionary_green);
        t_green.setText(ss_green);
        //18,51/57,75/100,131
        String green_contents = "정신적인 안정과 휴식, 평화를 주는 색입니다. 신경계를 진정시켜 피로를 풀어주고 안정된 정서상태를 도와줍니다. Green은 신비로운 엽록소의 색이며 생명의 시작이자 근원의 색이기 때문에 정적, 희망, 충족의 의미를 띕니다. Green은 특히 순색성이 높아야 하는데 그러한 자연의 Green은 전세계적으로 선호되는 가장 긍정적인 색입니다. 그러나 Green에 탁한 회색이 섞이게 되면 절망적인 이미지로 급변하여 병에 걸린 식물이나 죽고 썩어가는 낙엽을 연상케 해서 절망의 서글픔과 애처로운 느낌을 줍니다. Green이 특히 색채 관리를 잘해야 하는 이유입니다.";
        SpannableStringBuilder ss_green_contents = new SpannableStringBuilder(green_contents);
        ss_green_contents.setSpan(new RelativeSizeSpan(1.1f), 0, green_contents.length(), 0);
        ss_green_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#A2CE4A")), 0, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_green_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#A2CE4A")), 83, 118, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_green_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#A2CE4A")), 125, 184, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView t_green_contents = (TextView) findViewById(R.id.color_dictionary_green_contents);
        t_green_contents.setText(ss_green_contents);

        String blue = "Blue : 파랑";
        SpannableStringBuilder ss_blue = new SpannableStringBuilder(blue);
        ss_blue.setSpan(new RelativeSizeSpan(1.4f), 0, 4, 0); // set size
        ss_blue.setSpan(new ForegroundColorSpan(Color.WHITE), 0, blue.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// set color
        TextView t_blue = (TextView) findViewById(R.id.color_dictionary_blue);
        t_blue.setText(ss_blue);
        //18,51/57,75/100,131
        String blue_contents = "정적인 남성의 이미지를 지닌 수축적이며 내공적인 색상입니다. Blue는 대기 중이나 강과 바다에 가장 밝은 Light Blue에서부터 밤하늘의 Deep Blue까지 다양한 모습으로 나타납니다. Blue는 신앙적인 표정으로 인간의 마음을 움직이며, 영원의 정신적 피안으로 가이드 해주는 색입니다. 들뜬 마음을 조용히 가라앉히고 이성적인 활동을 해야 할 사람은 Blue와 친해질 필요가 있습니다. 감정에 치우쳐 흥분된 상태에서 욕설과 폭력의 광기가 돈다면 맑고 깨끗한 Blue의 후퇴적인 성질과 순종성, 경건한 신앙적 역할은 조용히, 서서히 안정을 찾는데 도움을 줍니다.";
        SpannableStringBuilder ss_blue_contents = new SpannableStringBuilder(blue_contents);
        ss_blue_contents.setSpan(new RelativeSizeSpan(1.1f), 0, blue_contents.length(), 0);
        ss_blue_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#58CCF1")), 0, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_blue_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#58CCF1")), 34, 98, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss_blue_contents.setSpan(new ForegroundColorSpan(Color.parseColor("#58CCF1")), 165, 212, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView t_blue_contents = (TextView) findViewById(R.id.color_dictionary_blue_contents);
        t_blue_contents.setText(ss_blue_contents);

        LinearLayout therapy_dictionary_aroma = (LinearLayout)findViewById(R.id.therapy_dictionary_aroma2);
        therapy_dictionary_aroma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        LinearLayout therapy_dictionary_color = (LinearLayout)findViewById(R.id.therapy_dictionary_color2);
        therapy_dictionary_color.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TherapyDictionaryColorActivity.class);
                startActivity(intent);
            }
        });

        //하단 바 클릭 이벤트 처리
        LinearLayout link_color_therapy = (LinearLayout)findViewById(R.id.link_color_therapy);
        link_color_therapy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorTherapyActivity.class);
                startActivity(intent);
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
//                Intent intent = new Intent(getApplicationContext(), TherapyDictionaryActivity.class);
//                startActivity(intent);
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
}
