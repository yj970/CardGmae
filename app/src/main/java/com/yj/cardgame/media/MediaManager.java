package com.yj.cardgame.media;

import android.media.MediaPlayer;

import com.yj.cardgame.APP;
import com.yj.cardgame.R;

/**
 * Created by yangjie on 2018/7/22.
 */

public class MediaManager {
    static MediaPlayer bgMediaPlayer;
    static MediaPlayer Attach1Player;

    public static void onStart() {
        playBgMusic();
    }

    public static void playAttack1() {
        if (Attach1Player == null) {
            Attach1Player = MediaPlayer.create(APP.getContext(), R.raw.attack_1);
        }
        Attach1Player.start();
    }

    public static void playBgMusic() {
        bgMediaPlayer = MediaPlayer.create(APP.getContext(), R.raw.bg);
        bgMediaPlayer.setLooping(true);
        bgMediaPlayer.start();
    }

    public static void onDestroy() {
        destroyBgMusic();
    }

    public static void onRestart() {
        restartBgMusic();
    }

    public static void onPause() {
        pauseBgMusic();
    }

    private static void pauseBgMusic() {
        if (bgMediaPlayer != null) {
            bgMediaPlayer.pause();
        }
    }

    private static void restartBgMusic() {
        if (bgMediaPlayer != null) {
            bgMediaPlayer.start();
        }
    }

    public static void destroyBgMusic() {
        if (bgMediaPlayer != null) {
            bgMediaPlayer.stop();
            bgMediaPlayer = null;
        }
    }

}
