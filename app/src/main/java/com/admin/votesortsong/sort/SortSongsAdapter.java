package com.admin.votesortsong.sort;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.admin.votesortsong.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortSongsAdapter extends RecyclerView.Adapter<SortSongsAdapter.SongViewHolder> {

  private String LOG_TAG="Shh_SortSongsAdapter";



    protected static class SongViewHolder extends RecyclerView.ViewHolder {

        View layout;
        TextView vote,title,artist;
        ImageView img;

        public SongViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            vote = (TextView) itemView.findViewById(R.id.songVote);
            title = (TextView) itemView.findViewById(R.id.songTitle);
            artist = (TextView) itemView.findViewById(R.id.songArtist);
            img = (ImageView) itemView.findViewById(R.id.imageView);

        }

    }

    private LayoutInflater mLayoutInflater;

   Map<String, String> map = new HashMap<String, String>();

    private SortedList <MusicBean> mSongs;

    public SortSongsAdapter(Context context, List<MusicBean> songs) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mSongs = new SortedList<>(MusicBean.class, new SongListCallback());
        mSongs.addAll(songs);
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.songitem, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SongViewHolder viewHolder, final int position) {
        final MusicBean song = mSongs.get(position);
        viewHolder.vote.setText(Integer.toString(song.getVotes()));
        viewHolder.title.setText(song.getMusicTitle());
        viewHolder.img.setImageResource(R.drawable.like);
        viewHolder.artist.setText(song.getArtist());





      final String title = viewHolder.title.getText().toString();
      final int img = R.drawable.like;
      final long musicID = song.getMusicID();
      final String artist = song.getArtist();
      final boolean playlist = song.isInPlayist();



      viewHolder.img.setOnClickListener(new View.OnClickListener() {

        int count = song.getVotes();
        public void onClick(View view) {
        if (count == 0) {
          count = count + 1;
          viewHolder.vote.setText("" + count);
         // String voteCount = viewHolder.vote.getText().toString();
          MusicBean song = new MusicBean(musicID,title,artist,playlist,count);
          mSongs.updateItemAt(position, song);
          notifyDataSetChanged();
          map.put(Long.toString(musicID),Integer.toString(count));
          //System.out.println(map);
          Log.d(LOG_TAG,"The map is"+map.toString());

        }
        }

      });
    }

    /**
     updates on song list changes.
     */
    private class SongListCallback extends SortedList.Callback<MusicBean> {

        @Override
        public int compare(MusicBean s1, MusicBean s2) {
          int val1=Integer.valueOf(s1.getVotes());
          int val2=Integer.valueOf(s2.getVotes());
          return val2 > val1 ? 1 : (val2 < val1 ? -1 : 0);


          //  return Integer.valueOf(s2.getVote().compareTo(s1.getVote()));
        }

        @Override
        public void onInserted(int position, int count) {
            notifyItemInserted(position);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRemoved(position);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
        }

        @Override
        public void onChanged(int position, int count) {
        }

        @Override
        public boolean areContentsTheSame(MusicBean oldItem, MusicBean newItem) {
            return false;
        }

        @Override
        public boolean areItemsTheSame(MusicBean item1, MusicBean item2) {
            return false;
        }

    }

}
