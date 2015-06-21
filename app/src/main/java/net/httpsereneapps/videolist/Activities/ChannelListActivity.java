package net.httpsereneapps.videolist.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.httpsereneapps.videolist.Adapters.ChannelListAdapter;
import net.httpsereneapps.videolist.Models.Channel;
import net.httpsereneapps.videolist.R;
import net.httpsereneapps.videolist.Utils.DB;

import java.util.List;

public class ChannelListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChannelListAdapter adapter;
    List<Channel> channels;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);
        recyclerView = (RecyclerView) findViewById(R.id.channelList);

        toolbar = (Toolbar) findViewById(R.id.toolbar_layout);

        setSupportActionBar(toolbar);

        channels = DB.getChannelList();
        adapter = new ChannelListAdapter(channels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_channel_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
