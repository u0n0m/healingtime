package com.healingtime.healingtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by scr44 on 2017-01-11.
 */

public class AromaTherapySettingActivity extends AppCompatActivity {

    ListView list;
    ListViewAdapter_settings adapter;
    EditText editsearch;
    Aromalist_data aromalist_data = new Aromalist_data();
    /*String[] aroma_name;
    String[] aroma_sub_name;
    String[] aroma_extract_part;
    String[] aroma_extract_method;
    String[] aroma_country_origin;
    String[] aroma_detailed_instructions;
    String[] aroma_color;
    String[] aroma_blending_oil;
    String[] aroma_history;
    String[] aroma_caution;
    int[] icon;*/
    int position;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aromatherapy_setting);

        list = (ListView) findViewById(R.id.aroma_setting_listview);

        for (int i = 0; i < aromalist_data.aroma_name.length; i++)
        {
            WorldPopulation wp = new WorldPopulation(aromalist_data.icon[i], aromalist_data.aroma_name[i], aromalist_data.aroma_sub_name[i], aromalist_data.aroma_extract_part[i], aromalist_data.aroma_extract_method[i],
                    aromalist_data.aroma_country_origin[i], aromalist_data.aroma_detailed_instructions[i], aromalist_data.aroma_color[i], aromalist_data.aroma_blending_oil[i], aromalist_data.aroma_history[i], aromalist_data.aroma_caution[i]);
            //population[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter_settings(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        editsearch = (EditText) findViewById(R.id.aroma_setting_search);




        // Locate the EditText in listview_main.xml


        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });

        editsearch.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    editsearch.setVisibility(View.INVISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    return true;
                }
                return false;
            }
        });

        editsearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editsearch.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });


    }
}
