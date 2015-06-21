package net.httpsereneapps.videolist.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.httpsereneapps.videolist.Models.Video;
import net.httpsereneapps.videolist.R;

import java.util.List;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoHolder> {
    List<Video> videos;

    public VideoListAdapter(List<Video> videos){
        this.videos = videos;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final RelativeLayout item = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_item, null);
        return new VideoHolder(item);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int i) {
        final Video item = videos.get(i);
        holder.setName(item.getName());
        holder.setImage();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public VideoHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.video_item_name);
            image = (ImageView) itemView.findViewById(R.id.video_item_image);
        }

        public void setName(String nameString){
            name.setText(nameString);
        }

        public void setImage(){
            Picasso.with(itemView.getContext()).load("http://i.imgur.com/DvpvklR.png").centerCrop().fit().into(image);
        }
    }
}
