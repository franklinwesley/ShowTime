package ufcg.com.showtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ufcg.com.showtime.Models.Musico;

public class MusicanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musican);

        Musico musico = (Musico) getIntent().getExtras().get("musican");

        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle(musico.getNome());
        setSupportActionBar(toolbar);

        TextView musican = (TextView) findViewById(R.id.tv_musican);
        TextView genre = (TextView) findViewById(R.id.tv_genre);
        ImageView banner = (ImageView) findViewById(R.id.img_banner);

        musican.setText(musico.getNome());
        genre.setText(musico.getEstiloMusical());

        Glide.with(banner.getContext()).load(musico.getBanner()).into(banner);

    }
}
