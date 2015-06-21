package net.httpsereneapps.videolist.Utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonElement;

import java.io.UnsupportedEncodingException;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Marek Ovečka on 21/06/15.
 */
public class Network {

    public static void getMedia(Context context) throws UnsupportedEncodingException {
        ApiInterface apiInterface = getInterface(context);
        apiInterface.getChannel(new Callback<JsonElement>(){
            @Override
            public void success(JsonElement response, retrofit.client.Response response2) {
                Log.d("JsonObject", response.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Body fail",error.toString());
            }
        });
    }
    private static ApiInterface getInterface(Context context){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://www.googleapis.com/youtube/v3")
                .build();
        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return restAdapter.create(ApiInterface.class);
    }
}
