package net.httpsereneapps.videolist.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Marek Ovečka on 20/06/15.
 */
public class Channel extends RealmObject {

    @PrimaryKey
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
