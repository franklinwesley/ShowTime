package ufcg.com.showtime;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import ufcg.com.showtime.Adapters.TabsMainAdapter;
import ufcg.com.showtime.Data.MySQLiteOpenHelper;
import ufcg.com.showtime.Extras.SlidingTabLayout;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;


public class MainActivity extends AppCompatActivity {

    private MaterialSearchView searchView;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private TabsMainAdapter adapter;
    private boolean search = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);

        MySQLiteOpenHelper bd = new MySQLiteOpenHelper(this);
        bd.inserirEvento("SHOW DO ANGRA EM CAMPINA GRANDE", "04-12-2015", "21:00", "Ventura Recepções (Aula Extra Music)", "http://scontent.xx.fbcdn.net/hphotos-xaf1/v/t1.0-0/c170.0.200.200/p200x200/1796506_852376334881263_8282178809894950046_n.jpg?oh=3ec85cba29d882c482472d21af56315a&oe=56891072");
        bd.inserirEvento("Forró das Antigas", "07-12-2015", "21:00", "Spazzio", "http://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpl1/v/t1.0-9/p720x720/12294663_960350437333590_6274618701354522479_n.jpg?oh=0aa033eaf35d56f5ece9b3dbe9181103&oe=56E8716D&__gda__=1457818692_627f0659707dbb3cf3247a38e1705d16");
        bd.inserirEvento("Mato Seco em Campina Grande", "04-12-2015", "20:00", "Vibe Universitária", "http://festaseshows.com.br/wp-content/themes/festaseshows/timthumb.php?src=https://festaseshows.com.br/wp-content/uploads/2012/09/mato-seco.jpg&h=160&w=160&zc=1");
        bd.inserirEvento("Banda Vibrações em Campina Grande", "04-12-2015", "21:30", "Inove Recepções", "http://festaseshows.com.br/wp-content/themes/festaseshows/timthumb.php?src=https://festaseshows.com.br/wp-content/uploads/2015/08/vibra%C3%A7oes-perfil.jpg&h=160&w=160&zc=1");
        bd.inserirEvento("O Rappa", "05-12-2015", "20:00", "Centro de Eventos César Rosalém", "http://s3-sa-east-1.amazonaws.com/blueticket/images/imagens/eventos3/15719.jpg");
        ArrayList<Event> events = bd.recuperarEventos();
        List<String> p1 = new ArrayList<String>();
        p1.add("James Hetfield");
        p1.add("Lars Ulrich");
        p1.add("Robert Trujillo");
        p1.add("Kirk Hammett");
        bd.inserirMusico("Metallica", p1, "http://perso.wanadoo.es/thesentinel2002/banner_metallica.jpg", "Rock Roll", 10);
        List<String> p2 = new ArrayList<String>();
        p2.add("Klaus Meine");
        p2.add("Rudolf Schenker");
        p2.add("Matthias Jabs");
        p2.add("James Kottak");
        p2.add("Paweł Mąciwoda");
        p2.add("Michael Schenker");
        p2.add("Herman Rarebell");
        bd.inserirMusico("Scorpions", p2, "http://i306.photobucket.com/albums/nn250/Nycce/scorpions-banner.jpg", "Rock Roll", 8);
        List<String> p3 = new ArrayList<String>();
        p3.add("Saulo Fernandes");
        bd.inserirMusico("Saulo Fernandes", p3, "http://www.odiariodaregiao.com/wp-content/uploads/2012/02/saulo.jpg", "Axe", 1);
        List<String> p4 = new ArrayList<String>();
        p1.add("Luan Santana");
        bd.inserirMusico("Luan Santana", p4, "http://4.bp.blogspot.com/_AjLELYzxkoE/TUDhI9NBLOI/AAAAAAAAAE4/XIas8-6Bkhs/s1600/luan-santana-banner.jpg", "Sertanejo", 2);
        List<String> p5 = new ArrayList<String>();
        p5.add("Corey Taylor");
        p5.add("Mick Thomson");
        p5.add("James Root");
        p5.add("Shawn Crahan");
        p5.add("Sid Wilson");
        p5.add("Jay Weinberg");
        p5.add("Craig Jones");
        p5.add("Chris Fehn");
        p5.add("Alessandro Venturella");
        bd.inserirMusico("Slipknot", p5, "https://sidemad.files.wordpress.com/2012/06/banner-slipknot.jpg", "Rock Roll", 7);
        ArrayList<Musico> musicos = bd.recuperarMusicos();
        bd.close();

        //search
        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                MySQLiteOpenHelper bd = new MySQLiteOpenHelper(getApplication());
                ArrayList<Event> events = bd.searchEvent(query);
                ArrayList<Musico> musicos = bd.searchMusic(query);
                bd.close();
                adapter.setEvents(events);
                adapter.setMusicos(musicos);
                notifyViewPagerDataSetChanged();
                viewPager.setAdapter(adapter);
                slidingTabLayout.setViewPager(viewPager);
                search = true;
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Historico de buscas do usuario
                return false;
            }
        });

        searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        SearchAdapter adapter = new SearchAdapter();
        searchView.setAdapter(adapter);
    }

    private void notifyViewPagerDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    protected void onStart() {
        MySQLiteOpenHelper bd = new MySQLiteOpenHelper(getApplication());
        ArrayList<Event> events = bd.recuperarEventos();
        ArrayList<Musico> musicos = bd.recuperarMusicos();
        bd.close();
        viewPager = (ViewPager) findViewById(R.id.vp_tabs);
        adapter = new TabsMainAdapter(getSupportFragmentManager(), this, events, musicos);
        viewPager.setAdapter(adapter);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        slidingTabLayout.setViewPager(viewPager);
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        }
        if (search) {
            MySQLiteOpenHelper bd = new MySQLiteOpenHelper(getApplication());
            ArrayList<Event> events = bd.recuperarEventos();
            ArrayList<Musico> musicos = bd.recuperarMusicos();
            bd.close();
            adapter.setEvents(events);
            adapter.setMusicos(musicos);
            notifyViewPagerDataSetChanged();
            viewPager.setAdapter(adapter);
            slidingTabLayout.setViewPager(viewPager);
            search = false;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private class SearchAdapter extends BaseAdapter implements Filterable {

        private ArrayList<String> data;

        private String[] typeAheadData;

        LayoutInflater inflater;

        public SearchAdapter() {
            inflater = LayoutInflater.from(MainActivity.this);
            data = new ArrayList<String>();
//            typeAheadData = getResources().getStringArray(R.array.state_array_full);
            typeAheadData = new String[] {};
        }


        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (!TextUtils.isEmpty(constraint)) {
                        // Retrieve the autocomplete results.
                        List<String> searchData = new ArrayList<>();

                        for (String str : typeAheadData) {
                            if (str.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                                searchData.add(str);
                            }
                        }

                        // Assign the data to the FilterResults
                        filterResults.values = searchData;
                        filterResults.count = searchData.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results.values != null) {
                        data = (ArrayList<String>) results.values;
                        notifyDataSetChanged();
                    }
                }
            };
            return filter;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder mViewHolder;

            if (convertView == null) {
                convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                mViewHolder = new MyViewHolder(convertView);
                convertView.setTag(mViewHolder);
            } else {
                mViewHolder = (MyViewHolder) convertView.getTag();
            }

            String currentListData = (String) getItem(position);

            mViewHolder.textView.setText(currentListData);

            return convertView;
        }


        private class MyViewHolder {
            TextView textView;

            public MyViewHolder(View convertView) {
                textView = (TextView) convertView.findViewById(android.R.id.text1);
            }
        }
    }
}
