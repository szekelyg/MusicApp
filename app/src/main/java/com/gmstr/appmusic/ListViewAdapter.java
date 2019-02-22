package com.gmstr.appmusic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter extends ArrayAdapter<String> {

    private String[] albums;
    private String[] bands;
    private int[] mImgIds;
    private Context context;

    public ListViewAdapter(Context context, String[] albums, String[] bands, int[] mImgIds){

        super(context,R.layout.list_row);

        this.context = context;
        this.albums = albums;
        this.bands = bands;
        this.mImgIds = mImgIds;
    }

    @Override
    public int getCount() {
        return albums.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row, parent, false);

            mViewHolder.album_title = convertView.findViewById(R.id.album_title);
            mViewHolder.band = convertView.findViewById(R.id.band_id);
            mViewHolder.album_image = convertView.findViewById(R.id.list_image_id);

            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.album_title.setText(albums[position]);
        mViewHolder.album_image.setImageResource(mImgIds[position]);
        mViewHolder.band.setText(bands[position]);

        return convertView;
    }
    
    class ViewHolder{
            TextView album_title;
            TextView band;
            ImageView album_image;
    }

}
