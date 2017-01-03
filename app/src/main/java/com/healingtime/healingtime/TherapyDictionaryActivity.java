package com.healingtime.healingtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TherapyDictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_dictionary);

/*        ListView ListView=(ListView)findViewById(R.id.listview);
        ArrayList<Listviewitem> data=new ArrayList<>();
        Listviewitem lion=new Listviewitem(R.drawable.aroma_therapy,"Lion");
        Listviewitem tiger=new Listviewitem(R.drawable.aroma_therapy,"Tiger");
        Listviewitem dog=new Listviewitem(R.drawable.aroma_therapy,"Dog");
        Listviewitem cat=new Listviewitem(R.drawable.aroma_therapy,"Cat");
        data.add(lion);
        data.add(tiger);
        data.add(dog);
        data.add(cat);
        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.therapy_dictionary,data);
        ListView.setAdapter(adapter);*/
    }
}
