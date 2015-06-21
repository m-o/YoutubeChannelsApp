package net.httpsereneapps.videolist.Utils;

import android.content.Context;

import net.httpsereneapps.videolist.App;
import net.httpsereneapps.videolist.Models.Channel;
import net.httpsereneapps.videolist.Models.Video;
import net.httpsereneapps.videolist.R;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class DB {

    public static List<Channel> getChannelList() {
        RealmResults<Channel> channels = App.getRealm().where(Channel.class).findAll();
        return channels;
    }

    public static boolean hasChannels() {
        return getChannelList().size() > 0 ? true : false;
    }

    public static void addChannels(Context context) {
        if (!hasChannels()) {
            String[] channelTexts = context.getResources().getStringArray(R.array.channels);
            Realm realm = App.getRealm();
            for (String channel : channelTexts) {
                realm.beginTransaction();
                Channel realmChannel = realm.createObject(Channel.class);
                realmChannel.setName(channel);
                realm.commitTransaction();
            }
        }
    }

    public static List<Video> getVideoList() {
        RealmResults<Video> videos = App.getRealm().where(Video.class).findAll();
        return videos;
    }

    public static boolean hasVideos() {
        return getVideoList().size() > 0 ? true : false;
    }

    public static void addVideos(Context context) {
        if (!hasVideos()) {
            String[] videos = context.getResources().getStringArray(R.array.videos);
            Realm realm = App.getRealm();
            for (String video : videos) {
                realm.beginTransaction();
                Video realmVideo = realm.createObject(Video.class);
                realmVideo.setName(video);
                realm.commitTransaction();
            }
        }
    }

    public static void deleteVideos(Context context) {
        Realm realm = App.getRealm();
        realm.beginTransaction();
        realm.clear(Video.class);
        realm.commitTransaction();
    }
}
