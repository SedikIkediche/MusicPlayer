package com.seddik.android.ikediche.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        Song currentItem = getItem(position);

        AppCompatImageView songImage = listItemView.findViewById(R.id.song_image);
        songImage.setImageResource(currentItem.getmSongImage());

        TextView songName = listItemView.findViewById(R.id.song_name);
        songName.setText(currentItem.getmSongName());

        TextView songAuthor = listItemView.findViewById(R.id.song_author);
        songAuthor.setText(currentItem.getmSongAuthor());

        return listItemView;
    }
}
