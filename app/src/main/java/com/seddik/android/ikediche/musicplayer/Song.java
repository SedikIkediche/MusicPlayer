package com.seddik.android.ikediche.musicplayer;

public class Song {

    private String mSongAuthor;
    private String mSongName;
    private int mSongImage;

    public Song() {
    }

    public Song(String mSongAuthor, String mSongName, int mSongImage) {
        this.mSongAuthor = mSongAuthor;
        this.mSongName = mSongName;
        this.mSongImage = mSongImage;
    }

    public String getmSongAuthor() {
        return mSongAuthor;
    }

    public String getmSongName() {
        return mSongName;
    }

    public int getmSongImage() {
        return mSongImage;
    }
}
