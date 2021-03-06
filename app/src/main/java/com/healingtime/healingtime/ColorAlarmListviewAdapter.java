package com.healingtime.healingtime;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.healingtime.healingtime.R.drawable.run_time_off;
import static com.healingtime.healingtime.R.drawable.run_time_on;

public class ColorAlarmListviewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ColorAlarmListviewItem> listViewItemList = new ArrayList<ColorAlarmListviewItem>() ;
    boolean alarm_onoff = false;
    // ListViewAdapter의 생성자
    public ColorAlarmListviewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.color_alarm_listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView start_ampm = (TextView) convertView.findViewById(R.id.start_ampm) ;
        TextView start_hour_min = (TextView) convertView.findViewById(R.id.start_hour_min) ;
        TextView end_ampm = (TextView) convertView.findViewById(R.id.end_ampm) ;
        TextView end_hour_min = (TextView) convertView.findViewById(R.id.end_hour_min) ;
        TextView week_sum = (TextView) convertView.findViewById(R.id.color_week_sum) ;
        ImageView color_minibox = (ImageView) convertView.findViewById(R.id.color_minibox) ;
        TextView color_desc = (TextView) convertView.findViewById(R.id.color_desc) ;
        TextView color_bright = (TextView) convertView.findViewById(R.id.color_bright) ;
        final ImageButton color_alarm_btn = (ImageButton) convertView.findViewById(R.id.color_alarm_btn) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ColorAlarmListviewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        start_ampm.setText(listViewItem.getStart_ampm());
        start_hour_min.setText(listViewItem.getStart_hour_min());
        end_ampm.setText(listViewItem.getEnd_ampm());
        end_hour_min.setText(listViewItem.getEnd_hour_min());
        week_sum.setText(listViewItem.getWeek());
        color_bright.setText(listViewItem.getBright());
        color_minibox.setImageDrawable(listViewItem.getMiniColorBox());
        color_desc.setText(listViewItem.getDesc());
        color_alarm_btn.setImageDrawable(listViewItem.getImg_btn());

        //버튼 클릭 처리
        color_alarm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "기기와 연결되지 않았습니다~\n연결 후 다시 시도하세요!", Toast.LENGTH_LONG).show();
                if(alarm_onoff == true){
                    color_alarm_btn.setImageResource(run_time_on);
                    alarm_onoff = false;
                }else if(alarm_onoff == false){
                    color_alarm_btn.setImageResource(run_time_off);
                    alarm_onoff = true;
                }
            }
        });

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem( String s_ampm, String s_hour, String s_min, String e_ampm, String e_hour, String e_min,
                         String week_sum, Integer color_bright,String color_desc, Drawable mini_color_box, Drawable icon) {
        ColorAlarmListviewItem item = new ColorAlarmListviewItem();

        item.setStart_ampm(s_ampm);
        item.setStart_hour_min(s_hour+":"+s_min);
        item.setEnd_ampm(e_ampm);
        item.setEnd_hour_min(e_hour+":"+e_min);
        item.setBright(color_bright);
        item.setWeek(week_sum);
        item.setDesc(color_desc);
        item.setMiniColorBox(mini_color_box);
        item.setImg_btn(icon);
        listViewItemList.add(item);
    }
}