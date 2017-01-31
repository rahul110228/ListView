package com.example.rahuldebmohalder.listview;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends Activity {

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o
    };

    String[] countries = new String[]{
            "The name Bangladesh was originally written as two words, Bangla Desh. ",
            "Savar labour unrest: 121 of a factory sacked ",
            "'Black day for history:' Berliners mourn victims of market attack",
            "World's most beautiful ski lodges (El Lodge, Sierra Nevada, Spain)",
            "L'Apogée: Hot tubs and other treats in Courchevel (L'Apogée, France)",
            "The Most Dangerous Countries to Travel to ",
            "America’s Biggest Health Threat Isn’t Ebola—It’s Something Much",
            "States With the Best and Worst Vaccination Rates ",
            "The Least Obese County in Every State",
            "Jet engine makers get lift from 3-D printing technology ",
            "Snapchat is now selling smart sunglasses from a smiling yellow",
            "Honda to unveil AI-driven electric car at CES ",
            "Mustafizur returns to Bangladesh ODI squad ",
            "India vs England: Virat Kohli and Co's insatiable hunger for success",
            "5 traditional Objects That Are Almost Disappearing "
    };

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        int k=2016;
        for (int i = 0; i < 15; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("cur", countries[i]);
            hm.put("releaseYear", ""+k);
            k--;
            hm.put("flag", Integer.toString(flags[i]));
            aList.add(hm);
        }

        String[] from = {"flag", "cur", "releaseYear"};

        int[] to = {R.id.image, R.id.cur, R.id.releaseYear};


        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to); // R.layout.listview_layout


        final ListView listView = (ListView) findViewById(R.id.listview);


        listView.setAdapter(adapter);
        listView.setVerticalScrollBarEnabled(false);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {

                Intent i = new Intent(getApplicationContext(), NewsActivity.class);

                int point = position;

                i.putExtra("position", Integer.toString(point));

                startActivity(i);
            }
        });
    }
}
