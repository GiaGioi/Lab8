package zedcodecom.giagioi.lab8;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity {

    private Button btnPlay;
    private MediaPlayer mediaPlayer;
    String source = "http://data31.chiasenhac.com/downloads/1974/5/1973435-cbfa9dec/128/Anh%20Dang%20O%20Dau%20Day%20Anh%20-%20Huong%20Giang%20[128kbps_MP3].mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        btnPlay = findViewById(R.id.btnPlay);
        mediaPlayer = new MediaPlayer();

//        set data
        mediaPlayer = MediaPlayer.create(this, Uri.parse(source));

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    btnPlay.setText("Play");
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mediaPlayer.setDataSource(source);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                    btnPlay.setText("Play");
                }

            }
        });
    }

    public class PlayMusic extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.reset();
            }
            return null;
        }
    }
}
