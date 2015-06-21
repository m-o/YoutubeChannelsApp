package net.httpsereneapps.videolist.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.httpsereneapps.videolist.Adapters.VideoListAdapter;
import net.httpsereneapps.videolist.Models.Video;
import net.httpsereneapps.videolist.R;
import net.httpsereneapps.videolist.Utils.DB;

import java.util.List;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class VideoListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VideoListAdapter adapter;
    List<Video> videos;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        recyclerView = (RecyclerView) findViewById(R.id.video_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        videos = DB.getVideoList();
        adapter = new VideoListAdapter(videos);
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
