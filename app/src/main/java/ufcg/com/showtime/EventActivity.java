package ufcg.com.showtime;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import ufcg.com.showtime.Adapters.TabsEventAdapter;
import ufcg.com.showtime.Adapters.TabsMainAdapter;
import ufcg.com.showtime.Data.MySQLiteOpenHelper;
import ufcg.com.showtime.Extras.SlidingTabLayout;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;

public class EventActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private TabsEventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Event event = getIntent().getExtras().getParcelable("event");
        MySQLiteOpenHelper bd = new MySQLiteOpenHelper(this);
        ArrayList<Musico> musicos = bd.recuperarMusicos(event.getNome());
        bd.close();
        viewPager = (ViewPager) findViewById(R.id.vp_tabs_event);
        adapter = new TabsEventAdapter(getSupportFragmentManager(), this, event, musicos);
        viewPager.setAdapter(adapter);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs_event);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        slidingTabLayout.setViewPager(viewPager);
    }
}
