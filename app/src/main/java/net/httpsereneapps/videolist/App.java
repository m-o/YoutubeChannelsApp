package net.httpsereneapps.videolist;

import android.app.Application;
import android.content.Context;

import net.httpsereneapps.videolist.Utils.DB;

import io.realm.Realm;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class App extends Application {

    private static Realm realm;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        if(null == realm) {
            realm = Realm.getInstance(this);
        }
        context = getApplicationContext();
        DB.addChannels(this);
        DB.deleteVideos(this);
        DB.addVideos(this);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        realm.close();
    }

    public static Realm getRealm(){
        return realm;
    }
}
