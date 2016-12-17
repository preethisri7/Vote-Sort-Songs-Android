package com.admin.votesortsong.sort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.admin.votesortsong.R;
import java.util.ArrayList;
import java.util.List;

public class MainSongActivity extends AppCompatActivity  {



    private List<Song> mSongs;

    private SortSongsAdapter mSongsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSongs = getAll();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(getLayoutManager());
        mSongsAdapter = new SortSongsAdapter(this, mSongs);
        recyclerView.setAdapter(mSongsAdapter);


    }

    private RecyclerView.LayoutManager getLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }

    private List<Song> getAll() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("1", "Song aa",R.drawable.like));
        songs.add(new Song("2", "Song bb",R.drawable.like));
        songs.add(new Song("9", "Song cc",R.drawable.like));
        songs.add(new Song("10", "Song dd",R.drawable.like));
        songs.add(new Song("13", "Song ee",R.drawable.like));
        songs.add(new Song("4", "Song ff",R.drawable.like));
        songs.add(new Song("21", "Song gg",R.drawable.like));
        songs.add(new Song("3", "Song hh",R.drawable.like));
        songs.add(new Song("6", "Song 00",R.drawable.like));
        songs.add(new Song("5", "Song xx",R.drawable.like));
        return songs;
    }



}
