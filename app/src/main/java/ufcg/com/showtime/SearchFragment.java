package ufcg.com.showtime;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ufcg.com.showtime.Adapters.EventAdapter;
import ufcg.com.showtime.Adapters.MusicAdapter;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;

public class SearchFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;
    private List<Event> events;
    private List<Musico> musics;

    public static SearchFragment newInstance(ArrayList<Event> events, ArrayList<Musico> musics) {
        SearchFragment fragmentDemo = new SearchFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("events", events);
        args.putParcelableArrayList("musics", musics);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        events = getArguments().getParcelableArrayList("events");
        musics = getArguments().getParcelableArrayList("musics");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = null;
//        if (events.isEmpty() || musics.isEmpty()) {
            v = inflater.inflate(R.layout.fragment_search, container, false);
            recyclerView = (RecyclerView) v.findViewById(R.id.search);
//            if (events.isEmpty()) {

                recyclerView.setHasFixedSize(true);

                LinearLayoutManager llm = new LinearLayoutManager(getActivity());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(llm);

                MusicAdapter adapter = new MusicAdapter(getActivity(), musics);
                adapter.setRecycleViewOnCLickListenerHack(this);
                recyclerView.setAdapter(adapter);
//            } else {
//                recyclerView.setHasFixedSize(true);
//
//                LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//                llm.setOrientation(LinearLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(llm);
//
//                EventAdapter adapter = new EventAdapter(getActivity(), events);
//                adapter.setRecycleViewOnCLickListenerHack(this);
//                recyclerView.setAdapter(adapter);
//            }
//        } else {
//            v = inflater.inflate(R.layout.double_search, container, false);
//            recyclerView = (RecyclerView) v.findViewById(R.id.search_event);
//            recyclerView.setHasFixedSize(true);
//
//            LinearLayoutManager llm_event = new LinearLayoutManager(getActivity());
//            llm_event.setOrientation(LinearLayoutManager.VERTICAL);
//            recyclerView.setLayoutManager(llm_event);
//
//            EventAdapter adapter_event = new EventAdapter(getActivity(), events.subList(0,2));
//            adapter_event.setRecycleViewOnCLickListenerHack(this);
//            recyclerView.setAdapter(adapter_event);
//
//            recyclerView = (RecyclerView) v.findViewById(R.id.search_music);
//            recyclerView.setHasFixedSize(true);
//
//            LinearLayoutManager llm_music = new LinearLayoutManager(getActivity());
//            llm_music.setOrientation(LinearLayoutManager.VERTICAL);
//            recyclerView.setLayoutManager(llm_music);
//
//            MusicAdapter adapter_music = new MusicAdapter(getActivity(), musics.subList(0,2));
//            adapter_music.setRecycleViewOnCLickListenerHack(this);
//            recyclerView.setAdapter(adapter_music);
//        }
        return v;
    }

    public void onClicK (View v) {
//        if (v.getId() == R.id.events) {
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            SearchFragment latestGamesFragment = SearchFragment.newInstance((ArrayList)events, new ArrayList<Musico>());
//
//            fragmentTransaction.replace(R.id.vp_tabs, latestGamesFragment);
//            fragmentTransaction.commit();
//        } else if (v.getId() == R.id.musics) {
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            SearchFragment latestGamesFragment = SearchFragment.newInstance(new ArrayList<Event>(), (ArrayList)musics);
//
//            fragmentTransaction.replace(R.id.vp_tabs, latestGamesFragment);
//            fragmentTransaction.commit();
//        }
    }

    @Override
    public void onClickListener(View v, final int position) {
        //ação ao clickar
    }
}
