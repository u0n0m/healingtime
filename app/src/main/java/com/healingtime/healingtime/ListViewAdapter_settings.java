package com.healingtime.healingtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter_settings extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<WorldPopulation> worldpopulationlist = null;
    private ArrayList<WorldPopulation> arraylist;


    public ListViewAdapter_settings(Context context, List<WorldPopulation> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<WorldPopulation>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView aroma_name;
        TextView aroma_sub_name;
        ImageView icon;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public WorldPopulation getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.aroma_name = (TextView) view.findViewById(R.id.rank);
            holder.aroma_sub_name = (TextView) view.findViewById(R.id.country);
            holder.icon = (ImageView) view.findViewById(R.id.aroma_icon_main);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.aroma_name.setText(worldpopulationlist.get(position).getAroma_name());
        holder.aroma_sub_name.setText(worldpopulationlist.get(position).getAroma_sub_name());
        holder.icon.setImageResource(worldpopulationlist.get(position).getIcon());
/*
        private String aroma_extract_part;
        private String aroma_extract_method;
        private String aroma_country_origin;
        private String aroma_detailed_instructions;
        private String aroma_color;
        private String aroma_blending_oil;
        private String aroma_history;
        private String aroma_caution;*/


        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SharedPreferences sp_aroma_settings = mContext.getSharedPreferences("AromaSettings", Context.MODE_PRIVATE); // 설정 정보 읽어오기
                SharedPreferences.Editor editor = sp_aroma_settings.edit(); //sharedPreference 내용 수정

                editor.putString("aroma_a_name", worldpopulationlist.get(position).getAroma_name()); //아로마 A구간 설정 패킷의 Data7 필드 저장(아로마종류)
                editor.commit();
                //Toast.makeText(mContext, "SharedPrefrences Test + putString Data : " + worldpopulationlist.get(position).getAroma_name(), Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, "설정되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        }
        else
        {
            for (WorldPopulation wp : arraylist)
            {
                if (wp.getAroma_name().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}