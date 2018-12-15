package com.example.famtanakit.exitpoll.model;

import java.util.Locale;

public class Pollitem {
    public final long _id;
    public final String num_poll;
    public final String image_poll;

    public Pollitem(long id, String num_poll, String image_poll) {
        this._id = id;
        this.num_poll = num_poll;
        this.image_poll = image_poll;
    }
    public  String toString(){
        String str = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this.num_poll
        );
        return  str;
    }
}
