package ufcg.com.showtime.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import ufcg.com.showtime.EventFragment;
import ufcg.com.showtime.EventListFragment;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;
import ufcg.com.showtime.MusicListFragment;

/**
 * Created by franklin on 22/11/15.
 */
public class TabsEventAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles = {"SOBRE", "ARTISTAS"};
    private ArrayList<Musico> musicos;
    private Event event;

    public TabsEventAdapter(FragmentManager fm, Context context, Event event, ArrayList<Musico> musicos) {
        super(fm);
        this.context = context;
        this.musicos = musicos;
        this.event = event;
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return EventFragment.newInstance(event);
            case 1:
                return MusicListFragment.newInstance(musicos);
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
