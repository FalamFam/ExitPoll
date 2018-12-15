package com.example.famtanakit.exitpoll.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.famtanakit.exitpoll.R;
import com.example.famtanakit.exitpoll.model.Pollitem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PollAdapter extends ArrayAdapter<Pollitem> {

    private Context mContext;
    private int mResource;
    private List<Pollitem> pollItemList;


    public PollAdapter(@NonNull Context Context, int resource,@NonNull List<Pollitem> pollItemList) {
        super(Context,resource,pollItemList);
        this.mContext = mContext;
        this.mResource = mResource;
        this.pollItemList = pollItemList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView chordTextView = view.findViewById(R.id.poll_text_view);
        ImageView imageView = view.findViewById(R.id.image_view);

        Pollitem pollItem = pollItemList.get(position);
        String num_poll = pollItem.num_poll ;
        String image = pollItem.image_poll;

        chordTextView.setText(String.valueOf(num_poll));

        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(image);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }
}
