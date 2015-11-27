package ufcg.com.showtime.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ufcg.com.showtime.EventFragment;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;
import ufcg.com.showtime.MusicFragment;

/**
 * Created by franklin on 22/11/15.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles = {"EVENTOS", "ARTISTAS"};

    private ArrayList<Event> events;
    private ArrayList<Musico> musicos;

    public TabsAdapter(FragmentManager fm, Context context, ArrayList<Event> events, ArrayList<Musico> musicos) {
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
                return EventFragment.newInstance(events);
            case 1:
                return new MusicFragment();
        }
        return null;
    }

    @Override
    // To update fragment in ViewPager, we should override getItemPosition() method,
    // in this method, we call the fragment's public updating method.
    public int getItemPosition(Object object) {
        if (object instanceof EventFragment) {
            ((EventFragment) object).update(events);
        } else if (object instanceof MusicFragment) {
            ((MusicFragment) object).update(musicos);
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
