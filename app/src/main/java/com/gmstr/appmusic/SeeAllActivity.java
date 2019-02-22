package com.gmstr.appmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SeeAllActivity extends AppCompatActivity {

    private ListView myListView;
    private final int[] mImgIds = new int[]{R.drawable.album_cover_1,R.drawable.album_cover_2,R.drawable.album_cover_3,R.drawable.album_cover_4,R.drawable.album_cover_5,R.drawable.album_cover_6,R.drawable.album_cover_7,R.drawable.album_cover_8};
    private final String[] albums = new String[]{"Danger Doom","Devils Gun","Saudade","Magdalena","Pink Floyd","Queen","Kinns","Danger Doom"};
    private final String[] bands = new String[]{"Vikings","Revolver","Kinns","Strange,free,enemy","Rock Covers","Bohemian Rhapsody","Saudade","Someting else"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        myListView = findViewById(R.id.albums_list_id);

        ListViewAdapter listViewAdapter = new ListViewAdapter(SeeAllActivity.this,albums,bands,mImgIds);
        myListView.setAdapter(listViewAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(SeeAllActivity.this, DetailActivity.class);
                myIntent.putExtra("album_title",albums[position]);
                myIntent.putExtra("band",bands[position]);
                myIntent.putExtra("image",mImgIds[position]);
                myIntent.putExtra("singers","Jim Box, Loren Tezler, Mack Intosh, Vala My");
                myIntent.putExtra("details","Saudade a deep emotional state of nostalgic or profound melancholic longing for an absent something or someone that one loves. Moreover, it often carries a repressed knowledge that the object of longing might never return");
                startActivity(myIntent);
            }
        });

    }
}
