package ufcg.com.showtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ufcg.com.showtime.Models.Musico;

public class MusicanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musican);

        TextView musican = (TextView) findViewById(R.id.tv_musican);
        TextView genre = (TextView) findViewById(R.id.tv_genre);

        Musico musico = (Musico) getIntent().getExtras().get("musican");

        musican.setText(musico.getNome());
        genre.setText(musico.getEstiloMusical());
    }
}
