/**
 * Java class that controls the main activity of the application.
 * All the view elements are initialized here and the video content items are retrieved from the
 * Firebase URL and prepared in a List.
 * @author Telmen Enkhtuvshin
 */
package com.example.swipevideolab2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * An overriding function that initializes the screen view layout and its elements.
     * @param savedInstanceState Bundle class element to create an instance of the screen object.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();
        VideoItem videoMoonLanding = new VideoItem();
        videoMoonLanding.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipe-video-app.appspot.com/o/SaveTube.io-'One%20small%20step%20for%20man'_%20Moment%20of%20Neil%20Armstrong's%20famous%20line.mp4?alt=media&token=33225f28-5409-4b1d-a187-f80b6852b0c1";
        videoMoonLanding.videoTitle = "Moon Landing";
        videoMoonLanding.videoDescription = "Neil Armstrong lands on the moon for the first time.";
        videoMoonLanding.videoID = "1";
        videoItemsList.add(videoMoonLanding);

        VideoItem videoForceOnBox3 = new VideoItem();
        videoForceOnBox3.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipe-video-app.appspot.com/o/ForceOnBox3.mp4?alt=media&token=21288b4d-9b08-42b4-8215-673f4034d2f0";
        videoForceOnBox3.videoTitle = "Force On Box 3";
        videoForceOnBox3.videoDescription = "Force acting on a box Part 3.";
        videoForceOnBox3.videoID = "2";
        videoItemsList.add(videoForceOnBox3);

        VideoItem videoForceOnBox4 = new VideoItem();
        videoForceOnBox4.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipe-video-app.appspot.com/o/ForceOnBox4.mp4?alt=media&token=59833fd3-14bc-487c-80f1-bcf792e3d134";
        videoForceOnBox4.videoTitle = "Force On Box 4";
        videoForceOnBox4.videoDescription = "Force acting on a box Part 4.";
        videoForceOnBox4.videoID = "3";
        videoItemsList.add(videoForceOnBox4);

        VideoItem videoForceOnBox5 = new VideoItem();
        videoForceOnBox5.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipe-video-app.appspot.com/o/ForceOnBox5.mp4?alt=media&token=4a5d44c5-b82c-4dc4-8737-620a626f3ae7";
        videoForceOnBox5.videoTitle = "Force On Box 5";
        videoForceOnBox5.videoDescription = "Force acting on a box Part 5.";
        videoForceOnBox5.videoID = "4";
        videoItemsList.add(videoForceOnBox5);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));



    }
}