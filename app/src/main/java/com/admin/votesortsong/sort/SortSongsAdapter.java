package com.admin.votesortsong.sort;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.admin.votesortsong.R;
import java.util.List;

class SortSongsAdapter extends RecyclerView.Adapter<SortSongsAdapter.SongViewHolder> {

    protected static class SongViewHolder extends RecyclerView.ViewHolder {

        View layout;
        TextView vote;
        TextView title;
        ImageView img;

        public SongViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            vote = (TextView) itemView.findViewById(R.id.songVote);
            title = (TextView) itemView.findViewById(R.id.songTitle);
            img = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }

    private LayoutInflater mLayoutInflater;

    private SortedList<Song> mSongs;

    public SortSongsAdapter(Context context, List<Song> songs) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mSongs = new SortedList<>(Song.class, new SongListCallback());
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
        final Song song = mSongs.get(position);
        viewHolder.vote.setText(song.getVote());
        viewHolder.title.setText(song.getTitle());
        viewHolder.img.setImageResource(song.getImage());

      final String title = viewHolder.title.getText().toString();
      final int img = R.drawable.like;


      viewHolder.img.setOnClickListener(new View.OnClickListener() {

        int count = Integer.valueOf(song.getVote());
        public void onClick(View view) {

          count = count + 1;
          viewHolder.vote.setText(""+count);
          String voteCount = viewHolder.vote.getText().toString();
          Song song = new Song(
            voteCount,
            title,
            img);
          mSongs.updateItemAt(position,song);
          notifyDataSetChanged();
        }

      });
    }

    /**
     updates on song list changes.
     */
    private class SongListCallback extends SortedList.Callback<Song> {

        @Override
        public int compare(Song s1, Song s2) {
          int val1=Integer.valueOf(s1.getVote());
          int val2=Integer.valueOf(s2.getVote());
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
        public boolean areContentsTheSame(Song oldItem, Song newItem) {
            return false;
        }

        @Override
        public boolean areItemsTheSame(Song item1, Song item2) {
            return false;
        }

    }

}
