package ufcg.com.showtime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ufcg.com.showtime.Adapters.EventAdapter;
import ufcg.com.showtime.Adapters.MusicAdapter;
import ufcg.com.showtime.Data.MySQLiteOpenHelper;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Musico;


public class MusicFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        MySQLiteOpenHelper bd = new MySQLiteOpenHelper(getContext());

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
        final List<Musico> musics = bd.recuperarMusicos();
        bd.close();

        recyclerView = (RecyclerView) v.findViewById(R.id.events);
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                final MusicAdapter adapter = (MusicAdapter) recyclerView.getAdapter();

                if (musics.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    //carragar mais jogos

                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        MusicAdapter adapter = new MusicAdapter(getActivity(), musics);
        adapter.setRecycleViewOnCLickListenerHack(this);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClickListener(View v, int position) {
        //ação ao clickar
    }

    public void update(ArrayList<Musico> musicos) {
//        this.musicos = musicos;
//        adapter.notifyDataSetChanged();
    }
}
