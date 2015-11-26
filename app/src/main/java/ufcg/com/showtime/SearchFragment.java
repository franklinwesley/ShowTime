package ufcg.com.showtime;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;

public class SearchFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;
    private List<Event> events;
    private List<Musico> musics;

    public static SearchFragment newInstance(List<Event> events, List<Musico> musics) {
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
        View v = inflater.inflate(R.layout.fragment_search, container, false);


        return v;
    }

    @Override
    public void onClickListener(View v, final int position) {
        //ação ao clickar
    }

    private void recycleView  (View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                GameListAdapter adapter = (GameListAdapter) recyclerView.getAdapter();

                if (games.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    //carragar mais jogos
                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        GameListAdapter adapter = new GameListAdapter(getActivity(), games);
        adapter.setRecycleViewOnCLickListenerHack(this);
        recyclerView.setAdapter(adapter);
    }
}
