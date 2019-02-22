package com.gmstr.appmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView album_title;
    private TextView band;
    private ImageView big_image;
    private TextView singers;
    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        album_title = findViewById(R.id.album_title_id);
        band = findViewById(R.id.band_id);
        big_image = findViewById(R.id.big_image_id);
        singers = findViewById(R.id.singers_id);
        details = findViewById(R.id.song_details);

        Bundle mBundle = getIntent().getExtras();

        if(mBundle != null) {
            album_title.setText(mBundle.getString("album_title"));
            band.setText(mBundle.getString("band"));
            big_image.setImageResource(mBundle.getInt("image"));
            singers.setText(mBundle.getString("singers"));
            details.setText(mBundle.getString("details"));
        }

    }
}
