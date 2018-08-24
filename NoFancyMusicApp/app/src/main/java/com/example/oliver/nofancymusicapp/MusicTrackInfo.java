package com.example.oliver.nofancymusicapp;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
public class MusicTrackInfo {
    ArrayList<MusicInfo> musicInfo;
    public MusicTrackInfo(Context co) {
        musicInfo = new ArrayList<>();
        musicInfo.add(new MusicInfo("Lying From You", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("Hit the Floor", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("Somewhere I Belong", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("Foreword", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("Faint", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("breaking The Habit", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("Numb", "Linkin Park", R.drawable.linkin_park));
        musicInfo.add(new MusicInfo("Do Or Die", "30 seconds to mars", R.drawable.second));
        musicInfo.add(new MusicInfo("Edge Of The Earth", "30 seconds to mars", R.drawable.second));
        musicInfo.add(new MusicInfo("R-Evolve", "30 seconds to mars", R.drawable.second));
        musicInfo.add(new MusicInfo("The Story", "30 seconds to mars", R.drawable.second));
        musicInfo.add(new MusicInfo("This Is War", "30 seconds to mars", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
        musicInfo.add(new MusicInfo("Hurricane", "akar", R.drawable.second));
    }
    ArrayList<MusicInfo> findArtists() {
        ArrayList<MusicInfo> artists = new ArrayList<>();
        boolean equal = false;
        for (int i = 0; i < musicInfo.size(); i++) {
            if (artists.size() < 1) {
                artists.add(musicInfo.get(0));
            }
            for (int j = 0; j < artists.size(); j++) {
                if (!(artists.get(j).getmArtisticName().equalsIgnoreCase(musicInfo.get(i).getmArtisticName()))) {
                    equal = true;
                    Log.i("ifcase", "findArtists: first if");
                } else {
                    equal = false;
                }
            }
            if (equal) {
                artists.add((musicInfo.get(i)));
                equal = false;
                Log.i("ifcase", "findArtists: second if");
            }
        }
        return artists;
    }
    ArrayList<MusicInfo> findCurrentMusic(String trackName) {
        ArrayList<MusicInfo> currentMusic = new ArrayList<>();
        for (int i = 0; i < musicInfo.size(); i++) {
            if (trackName.equalsIgnoreCase(musicInfo.get(i).getmTrackName().toString())) {
                currentMusic.add(musicInfo.get(i));
                break;
            }
        }
        return currentMusic;
    }
    ArrayList<MusicInfo> findSongsForArtists(String artName) {
        ArrayList<MusicInfo> trackA = new ArrayList<>();
        for (int i = 0; i < musicInfo.size(); i++) {
            if (musicInfo.get(i).getmArtisticName().toString().equalsIgnoreCase(artName)) {
                trackA.add(musicInfo.get(i));
            }
        }
        return trackA;
    }
}
