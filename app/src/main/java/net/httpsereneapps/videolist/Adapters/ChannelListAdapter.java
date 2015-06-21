package net.httpsereneapps.videolist.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.httpsereneapps.videolist.Activities.VideoListActivity;
import net.httpsereneapps.videolist.Models.Channel;
import net.httpsereneapps.videolist.R;
import net.httpsereneapps.videolist.Utils.Network;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelHolder> {

    private List<Channel> channels;


    public ChannelListAdapter(List<Channel> channels){
        this.channels = channels;
    }

    @Override
    public ChannelHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final RelativeLayout item = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.channel_item, null);
        return new ChannelHolder(item);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    @Override
    public void onBindViewHolder(ChannelHolder holder, int i) {
        final Channel item = channels.get(i);
        holder.setName(item.getName());
    }

    public class ChannelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;

        public ChannelHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.channel_item_name);
            name.setOnClickListener(this);
        }

        public void setName(String nameString){
            name.setText(nameString);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(itemView.getContext(), VideoListActivity.class);
            try {
                Network.getMedia(itemView.getContext());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            itemView.getContext().startActivity(intent);
        }
    }
}
