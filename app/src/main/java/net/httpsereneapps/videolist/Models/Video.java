package net.httpsereneapps.videolist.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class Video extends RealmObject {

    @PrimaryKey
    private String name;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
