package com.example.technix.webview;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.VideoView;

public class SplashScreen extends Activity {
    VideoView videoView;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoView = (VideoView) findViewById(R.id.videoView);


        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hello);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        videoView.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
       Intent myIntent   = new Intent(this, MainActivity.class);
       startActivity(myIntent);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
        finish();
    }

}