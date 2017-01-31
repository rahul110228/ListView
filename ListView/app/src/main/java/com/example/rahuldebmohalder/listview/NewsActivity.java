package com.example.rahuldebmohalder.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class NewsActivity extends ListActivity {


    ArrayList<HashMap<String, String>> tracksList;



    String album_id, album_name;

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

    // Array of strings to store currencies
    String[] currency = new String[]{
            "Starting in the 1950s, Bengali nationalists used the term in political rallies in East Pakistan. The term Bangla is a major name for both the Bengal region and the Bengali language. The earliest references to the term date to the Nesari plate in 805 AD. The term \"Vangaladesa\" is found in South Indian records in the 11th century. Three of Asia's largest rivers, the Ganges (locally known as the Padma), the Brahmaputra (locally known as the Jamuna) and the Meghna, flow through Bangladesh and form the fertile Bengal delta—the largest delta in the world.\n",
            "An apparel factory today sacked 121 “troublemakers” and pasted their photographs on the notice board as labour unrest in the industrial belt of Savar continues for the 11th straight day today. Windy Apparels Limited, from where the agitation allegedly began and spread to elsewhere, had sacked the 121 workers, a local correspondent reports from the spot. Meanwhile, three more factories were closed today for agitation in the industrial belt raising the tally to 59, putting livelihoods of about 1.51 lakh workers in jeopardy.",
            "Streets that would normally be bustling with shoppers and friends meeting over steaming mugs of mulled wine five days before Christmas are eerily quiet.The cordoned-off roads are empty of traffic, save for several police vans and the black saloon cars of visiting dignitaries. Stalls are shuttered and the handful of people wandering about appear shell-shocked, talking in hushed tones of the previous night's horrific events. It's odd to see the market boarded up and empty when it should be full of life and of people celebrating. Instead of fairy lights, many stalls have red memorial candles used at grave sites on their front counter.",
            "Set 7,000 feet above the main Sierra Nevada ski resort village -- and just 90 minutes from the Malaga coast -- this picturesque lodge is worth visiting for the views alone. From every angle, you can enjoy sweeping panoramas of the Sierra Nevada mountains and on a clear day, you can see Africa in the distance. The lodge itself is equally beautiful, built with Finnish timber logs and tricked out with stylish, alpine-chic decor -- think antler chandeliers, leather Chesterfields and cowhide rugs. Other hotel highlights include a ski-in, ski-out rental shop that makes hitting the slopes easy, and a scenic hot tub perfect for enjoying a mug of mulled wine après--ski.",
            "Perched atop a former Olympic ski jump, L'Apogée has the most prestigious address in the ritzy winter playground of Courchevel. With its ski-in, ski-out facilities, the lodge offers access to some of Courchevel's highest slopes right at its doorstep. Unlike the flashy, over-the-top hotels Courchevel is known for, L'Apogée is refreshingly discreet with its timbered interiors, muted modern furnishings and intimate boutique feel (there are just 53 rooms). Not that it's any less luxurious -- opened in 2013, the hotel cost a whopping $100 million and is kitted out with a Sisley spa, two restaurants and a cigar lounge.",
            "From the terror attacks in Nice, France to the ongoing spread of the Zika virus, the past year has been a dizzying one in terms of violence and disease outbreaks throughout the world. These factors, among others, increase the likelihood travelers will be required to stay up to date on travel safety advisories. Using 2016 data from the Canadian government and The Global Health Data Exchange, HealthGrove, a health visualization site by Graphiq, created an ascending list of the most dangerous countries to travel to.",
            "There’s been no shortage of health-related news lately. Ebola remains a serious threat, especially in West African nations Liberia, Sierra Leone, and Guinea, where there have been 13,540 total cases (7,702 laboratory-confirmed cases) and 4,941 deaths as of October 29, 2014 (last updated October 31). With the first (and so far only) U.S. fatality, media outlets and everyday Americans have worked themselves into a frenzy , a reaction that is prompting a swift response imploring people not to overreact. To date, there have been four confirmed cases of Ebola in the U.S.",
            "The anti-vaccination movement is not a new trend. Parents have been objecting vaccinations since the Victorian era. Back in 1840, when the first Vaccination Act was passed, families who did not vaccinate their children were fined. Activists were outraged, claiming that the law infringed on a family’s privacy and personal decisions. Today, modern anti-vaccination activists (also known as AVers) take to social media sites to express their frustration with mandated vaccines. Meanwhile, most of America is still vaccinating their kids, and wondering why some people aren’t. According to the Center for Disease Control and Prevention (CDC), 3.3% of California kindergarteners were allowed to skip vaccinations due to personal or religious beliefs.",
            "The obesity epidemic gripping America hasn’t quite loosened its claws, but new survey data shows some promise. According to the CDC National Health and Nutrition Examination Survey, youth obesity rates have leveled off and the rise of adult obesity has slowed. Among youth, obesity rates have stagnated around 17 percent since 2008. With this in mind, the experts at HealthGrove, a health research site powered by Graphiq, found the least obese county in every state. Using data from the Centers for Disease Control and Prevention, they ranked the counties in each state based on the percent of their population between the ages of six and 29 that was obese at the time of most recent data collection (2013). In the case of ties, states with the larger number of obese people ranked higher.",
            "There are few industries that haven't been shaken up by the game-changing potential of 3-D printing, and aviation is no exception. While it may be fun to imagine manufacturers spitting out planes at the touch of a button, the reality is more low key, though no less revolutionary. As is usually the case with aviation, it is all kicking off with a jet engine. Engine maker CFM nternational, a joint venture between GE Aviation and the French company Snecma, has created the LEAP engine -- an acronym for \"leading edge aviation propulsion\" that the company hopes reflects just how innovative the new aircraft component is.",
            "napchat unveiled a new line of funky sunglasses with a built-in wireless video camera in September, marking its first big move from apps to hardware. At the same time, the company renamed itself Snap Inc. Now those glasses, called Spectacles, are finally going on sale for $129.99, but there's a catch. The company is only selling the glasses from unusual anthropomorphic vending machines called Snapbots, which look more than a little bit like Minions.",
            "TOKYO -- Honda Motor is set to unveil an electric concept car piloted by artificial intelligence at the International Consumer Electronics Show in Las Vegas in January, marking the Japanese automaker's first appearance at the show since 2007. Described as an \"automated EV commuter vehicle,\" the self-driving NeuV will be equipped with an AI system the company calls the \"emotion engine,\" that will be able to react to the driver's conversations and feelings. The emotion engine was developed by Japanese telecoms giant SoftBank Group",
            "Mustafizur Rahman is among five entrants to Bangladesh's 15-member ODI squad for the first game against New Zealand in Christchurch on December 26. Fast bowler Rubel Hossain has also returned, while Mehedi Hasan, Tanbir Hayder and Subashis Roy have earned maiden call-ups. Nasir Hossain, Shafiul Islam (hamstring injury), Al-Amin Hossain and Taijul Islam have been left out.",
            "No sooner had Ravindra Jadeja got Jake Ball caught at gully on Day 5 of the final Test at Chennai than Karun Nair, who took the catch, ran towards the stumps, uprooted one and set off in a wild celebration. It was perhaps fitting that the two best players of the match were involved in the wicket that sealed the deal for India.",
            "Bengali culture and tradition are basically the reflection of our rural settings. Rural lifestyles, crop- production, vehicles, machineries, food, religious beliefs and the nature are the vivid elements of our folk culture. Here are five such traditional objects that are disappearing with time.\n",
    };

    private GoogleApiClient client;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsshow);

        Intent in = getIntent();
        int point = Integer.parseInt(in.getStringExtra(("position")));

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        int k = 2016;
        for (int i = 0; i < 15; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", "" + countries[i]);
            hm.put("cur", "" + currency[i]);
            String s = "\n"+Integer.toString(k)+"\n"; //"\n" + k + "\n"
            hm.put("releaseYear", s);
            k--;

            hm.put("flag", Integer.toString(flags[i]));
            aList.add(hm);
        }


        String[] from = {"flag", "txt", "cur", "releaseYear"};

        int[] to = {R.id.feedImage1, R.id.txtTitleMsg, R.id.txtStatusMsg, R.id.txtUrl};

      /*  View view= LayoutInflater.from(this).inflate(R.layout.activity_fullnews,null);

        TextView myTextView = (TextView)view.findViewById(R.id.txtStatusMsg);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"times.ttf");
        myTextView.setTypeface(typeFace);*/



        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_fullnews, from, to); // R.layout.listview_layout




        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        getListView().setSelection(point);



        listView.setVerticalScrollBarEnabled(false);



 /*       RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
       *//* MyAdapter adapter = new MyAdapter();*//*
        //recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter));
        recyclerView.setAdapter(adapter);*/

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("News Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

}
