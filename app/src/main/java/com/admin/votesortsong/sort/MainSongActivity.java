package com.admin.votesortsong.sort;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.admin.votesortsong.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainSongActivity extends Activity {


    private List<MusicBean> mSongs;

    private SortSongsAdapter mSongsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    private List<MusicBean> getAll() {
        List<MusicBean> songs = new ArrayList<>();
        for(int i=0;i<10;i++) {
          songs.add(new MusicBean(1234+i,"Song" + i,"A" + i,true,"0", R.drawable.like));
        }
        return songs;
    }



}
