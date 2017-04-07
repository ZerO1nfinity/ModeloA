package com.zero.modeloa.view;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zero.modeloa.R;

public class PictureDetailActivity extends AppCompatActivity {
    ImageView img_picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar("",true);

        img_picture = (ImageView) findViewById(R.id.img_picture);

        Picasso.with(this).load("http://media.tumblr.com/2e1cbacfc100ea973bae8d2035820178/tumblr_inline_mw68fdmWbL1sp7s5w.png").into(img_picture);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.TRANSPARENT);

            Fade fade = new Fade();
            fade.setDuration(500);
            getWindow().setEnterTransition(new Fade());
        }
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);

    }
}
