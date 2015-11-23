package ufcg.com.showtime.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ufcg.com.showtime.BlankFragment;

/**
 * Created by franklin on 22/11/15.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles = {"EVENTOS", "ARTISTAS"};

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                //TODO aba
//                return new BlankFragment();
            case 1:
                //TODO aba
//                return new BlankFragment();
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
