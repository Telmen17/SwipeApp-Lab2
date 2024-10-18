/**
 * This is the Controller section of the app VideoAdapter class that responds and reacts
 * to every user interaction. Proper response is displayed for an action. When the screen is swiped,
 * the VideoAdapter class uses the RecyclerView to show smooth video transition.
 * @author Telmen Enkhtuvshin
 */
package com.example.swipevideolab2;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    /**
     * Constructor for the VideoAdapter class.
     * @param videoItems A list of video content item objects.
     */
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    /**
     * An overridden event listener method that sets up the layout of
     * the video once the ViewHolder has been created.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new VideoViewHolder object.
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false)
        );
    }

    /**
     * An overridden event listener method that enables the next video to be played after swiping.
     * Once the ViewHolder is stationary, the video content can be played.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    /**
     * An overridden method that returns the videoItems list size.
     * @return VideoItems list size.
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     * A VideoViewHolder class that controls how and when the video content should be played.
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView textVideoTitle1, textVideoDescription1, textVideoID;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         *A constructor that equates the fields to the User Interface elements.
         * @param itemView View class whole screen object.
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
            textVideoID = itemView.findViewById(R.id.textVideoID);
        }

        /**
         *A method that manipulates and sets the video content data to the View elements.
         * @param videoItem VideoItem class object that holds single video information.
         */
        void setVideoData(VideoItem videoItem) {
            textVideoTitle1.setText(videoItem.videoTitle);
            textVideoDescription1.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);
            textVideoID.setText("Video ID: " + videoItem.videoID);


            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                /**
                 *An overridden method that prepares the video t obe played
                 *and sets the video ratio.
                 * @param mp MediaPlayer class object that plays the video.
                 */
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if (scale >= 1f) {
                        videoView.setScaleX(scale);
                    } else {
                        videoView.setScaleY(1f / scale);
                    }
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /**
                 *An overridden event listener method that starts the MediaPlayer class mp object
                 * to start playing the video on the screen.
                 * @param mp MediaPlayer class object that controls the video to be played.
                 */
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();

                }
            });
        }
    }
}
