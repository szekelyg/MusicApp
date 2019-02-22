package com.gmstr.appmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mGallery;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;
    private ListView myListView;

    private int[] mImgIds = new int[]{R.drawable.album_cover_1,R.drawable.album_cover_2,R.drawable.album_cover_3,R.drawable.album_cover_4,R.drawable.album_cover_5,R.drawable.album_cover_6,R.drawable.album_cover_7,R.drawable.album_cover_8};
    private String[] albums = new String[]{"Danger Doom","Devils Gun","Saudade","Magdalena","Pink Floyd","Queen","Kinns","Danger Doom"};
    private String[] bands = new String[]{"Vikings","Revolver","Kinns","Strange,free,enemy","Rock Covers","Bohemian Rhapsody","Saudade","Someting else"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGallery = findViewById(R.id.id_gallery);
        myListView = findViewById(R.id.albums_list_id);

        ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this,albums,bands,mImgIds);
        myListView.setAdapter(listViewAdapter);

        mInflater = LayoutInflater.from(this);

        initView();

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
                myIntent.putExtra("album_title",albums[position]);
                myIntent.putExtra("band",bands[position]);
                myIntent.putExtra("image",mImgIds[position]);
                myIntent.putExtra("singers","Jim Box, Loren Tezler, Mack Intosh, Vala My");
                myIntent.putExtra("details","Saudade a deep emotional state of nostalgic or profound melancholic longing for an absent something or someone that one loves. Moreover, it often carries a repressed knowledge that the object of longing might never return");
                startActivity(myIntent);
            }
        });

    }

    private void initView()
    {
        for (int i = 0; i < mImgIds.length; i++)
        {
            View view = mInflater.inflate(R.layout.gallery_item, mGallery, false);
            ImageView img = view.findViewById(R.id.gallery_item_image_id);
            img.setImageResource(mImgIds[i]);

            mGallery.addView(view);
        }



    }
}
