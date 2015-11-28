package ufcg.com.showtime.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import ufcg.com.showtime.EventListFragment;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;
import ufcg.com.showtime.MusicListFragment;

/**
 * Created by franklin on 22/11/15.
 */
public class TabsMainAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles = {"EVENTOS", "MUSICOS"};

    private ArrayList<Event> events;
    private ArrayList<Musico> musicos;

    public TabsMainAdapter(FragmentManager fm, Context context, ArrayList<Event> events, ArrayList<Musico> musicos) {
        super(fm);
        this.context = context;
        this.events = events;
        this.musicos = musicos;
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return EventListFragment.newInstance(events);
            case 1:
                return MusicListFragment.newInstance(musicos);
        }
        return null;
    }

    @Override
    // To update fragment in ViewPager, we should override getItemPosition() method,
    // in this method, we call the fragment's public updating method.
    public int getItemPosition(Object object) {
        if (object instanceof EventListFragment) {
            ((EventListFragment) object).update(events);
        } else if (object instanceof MusicListFragment) {
            ((MusicListFragment) object).update(musicos);
        }
        return super.getItemPosition(object);
    }

    public void setEvents (ArrayList<Event> events) {
        this.events = events;
    }

    public void setMusicos (ArrayList<Musico> musicos) {
        this.musicos = musicos;
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
