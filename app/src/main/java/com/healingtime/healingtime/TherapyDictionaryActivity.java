package com.healingtime.healingtime;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TherapyDictionaryActivity extends AppCompatActivity {
    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_dictionary);

/*        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.aroma_description);
            }
        }, (1000));*/

        ListView listview ;
        AromaListViewAdapter adapter;

        // Adapter 생성
        adapter = new AromaListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.aroma_listview);
        listview.setAdapter(adapter);

        // 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aroma_basil), "Basil", "Ocimum basilicum") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aroma_bergamot_calabrian), "Bergamot - Calabrian", "Citrus bergamia ") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aroma_cedarwood_atlas), "Cedarwood Atlas", "Cedrus atlantica") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aroma_citronella_ceylon), "Citronella Ceylon", "Cymbopogon nardus") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.aroma_clary_sage), "Clary Sage", "Salvia sclarea");

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                AromaListViewItem item = (AromaListViewItem) parent.getItemAtPosition(position);
                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawable = item.getIcon();

                Intent intent = new Intent(getApplicationContext(), AromaDescriptionActivity.class);
                intent.putExtra("titleStr", titleStr);
                startActivity(intent);
                //finish();
            }
        }) ;
    }
}
