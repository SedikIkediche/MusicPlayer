package com.seddik.android.ikediche.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    public static final String SONG_NAME = "song_name";
    public static final String SONG_AUTHOR = "song_author";

    private ConstraintLayout constraintLayout;
    private Toolbar libraryToolbar;
    private SongAdapter LibrarySongAdapter;
    private ListView libraryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        initializeFields();

        setSupportActionBar(libraryToolbar);

        constraintLayout.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        ViewCompat.setOnApplyWindowInsetsListener(libraryToolbar, new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {

                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) libraryToolbar.getLayoutParams();

                layoutParams.topMargin = insets.getSystemWindowInsetTop();

                libraryToolbar.setLayoutParams(layoutParams);

                return insets;
            }
        });

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Shawn Mendes", "If I Can't Have You", R.drawable.disc));
        songs.add(new Song("Blanco Brown", "The Git Up", R.drawable.disc));
        songs.add(new Song("Taylor Swift", "You Need To Calm Down", R.drawable.disc));
        songs.add(new Song("Lil Tecca", "Ran$om", R.drawable.disc));
        songs.add(new Song("Lewis Capaldi", "Someone You Loved", R.drawable.disc));
        songs.add(new Song("Blake Shelton", "God's Country", R.drawable.disc));
        songs.add(new Song("Halsey", "Without Me", R.drawable.disc));
        songs.add(new Song("Sam Smith", "How Do You Sleep?", R.drawable.disc));
        songs.add(new Song("Ava Max", "Sweet But Psycho", R.drawable.disc));
        songs.add(new Song("Katy Perry", "Never Really Over", R.drawable.disc));
        songs.add(new Song("Morgan Wallen", "Whiskey Glasses", R.drawable.disc));
        songs.add(new Song("NLE Choppa", "Shotta Flow", R.drawable.disc));
        songs.add(new Song("Luke Bryan", "Knockin' Boots", R.drawable.disc));
        songs.add(new Song("Chris Young", "Raised On Country", R.drawable.disc));

        LibrarySongAdapter = new SongAdapter(this, songs);

        libraryListView.setAdapter(LibrarySongAdapter);

        libraryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent nowPlayingIntent = new Intent(LibraryActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra(SONG_NAME, songs.get(position).getmSongName());
                nowPlayingIntent.putExtra(SONG_AUTHOR, songs.get(position).getmSongAuthor());
                startActivity(nowPlayingIntent);
            }
        });
    }

    /**
     * this method initialize our fields
     */
    private void initializeFields() {
        libraryToolbar = findViewById(R.id.tool_bar);
        constraintLayout = findViewById(R.id.main_container);
        libraryListView = findViewById(R.id.list_view);
    }
}
