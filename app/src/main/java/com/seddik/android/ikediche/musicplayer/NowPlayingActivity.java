package com.seddik.android.ikediche.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NowPlayingActivity extends AppCompatActivity {

    private TextView songName;
    private TextView songAuthor;
    private Toolbar nowPlayingToolbar;
    private ConstraintLayout nowPlayingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        initializeFields();

        nowPlayingToolbar = findViewById(R.id.now_playing_toolbar);
        setSupportActionBar(nowPlayingToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nowPlayingContainer.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        ViewCompat.setOnApplyWindowInsetsListener(nowPlayingToolbar, new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {

                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) nowPlayingToolbar.getLayoutParams();

                layoutParams.topMargin = insets.getSystemWindowInsetTop();

                nowPlayingToolbar.setLayoutParams(layoutParams);

                return insets;
            }
        });

        Intent nowPlayingIntent = getIntent();
        if (nowPlayingIntent != null) {
            songName.setText(nowPlayingIntent.getStringExtra(LibraryActivity.SONG_NAME));
            songAuthor.setText(nowPlayingIntent.getStringExtra(LibraryActivity.SONG_AUTHOR));
        }
    }

    /**
     * this method initialize our fields
     */
    private void initializeFields() {
        songName = findViewById(R.id.song_name_text_view);
        songAuthor = findViewById(R.id.song_author_text_view);
        nowPlayingContainer = findViewById(R.id.now_playing_container);
    }
}
