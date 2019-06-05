package com.example.mp3_player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Muzyka> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Muzyka("House of Cards","KSHMR ft. Sidnie Tipton",R.raw.house_of_cards));
        arrayList.add(new Muzyka("Mandala","KSHMR & MARNIK",R.raw.mandala));
        arrayList.add(new Muzyka("Allstar","Smash Mouth",R.raw.allstar));
        arrayList.add(new Muzyka("Come and get your love","Redbone",R.raw.come_and_get_your_love));
        arrayList.add(new Muzyka("In the Shadows","The Rasmus",R.raw.in_the_shadows));
        arrayList.add(new Muzyka("What is Love","Haddaway",R.raw.what_is_love));

        adapter = new CustomMusicAdapter(this, R.layout.activity_songlist_item, arrayList);
        songList.setAdapter(adapter);
    }
}
