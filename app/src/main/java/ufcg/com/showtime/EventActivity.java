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

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


//        Event event = getIntent().getExtras().getParcelable("event");
        Event event = new Event("SHOW DO ANGRA EM CAMPINA GRANDE", "04-12-2015", "21:00", "Ventura Recepções (Aula Extra Music)", "http://scontent.xx.fbcdn.net/hphotos-xaf1/v/t1.0-0/c170.0.200.200/p200x200/1796506_852376334881263_8282178809894950046_n.jpg?oh=3ec85cba29d882c482472d21af56315a&oe=56891072");
        MySQLiteOpenHelper bd = new MySQLiteOpenHelper(this);
        ArrayList<Musico> musicos = bd.recuperarMusicos(event.getNome());
        bd.close();
        viewPager = (ViewPager) findViewById(R.id.vp_tabs);
        adapter = new TabsEventAdapter(getSupportFragmentManager(), this, event, musicos);
        viewPager.setAdapter(adapter);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        slidingTabLayout.setViewPager(viewPager);
    }
}
