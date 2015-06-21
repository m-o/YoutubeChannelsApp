package net.httpsereneapps.videolist.Utils;

import com.google.gson.JsonElement;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Marek Ovečka on 21/06/15.
 */
public interface ApiInterface {

    @GET("/channels?id=UCnMVQqR2n9n9uOwvyjdxsHQ&key=AIzaSyByWn-AM6cGNtU6FBwNfheUiVTyytJojQk&part=contentDetails&part=auditDetails,contentDetails,id,snippet,topicDetails")
    public void getChannel(Callback<JsonElement> callback);
}
