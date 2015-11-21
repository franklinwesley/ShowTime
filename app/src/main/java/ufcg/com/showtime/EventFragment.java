package ufcg.com.showtime;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ufcg.com.showtime.Adapters.EventAdapter;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;


public class EventFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        final List<Event> events = new ArrayList<>();

        recyclerView = (RecyclerView) v.findViewById(R.id.events);
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                final EventAdapter adapter = (EventAdapter) recyclerView.getAdapter();

                if (events.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    //carragar mais jogos

                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        EventAdapter adapter = new EventAdapter(getActivity(), events);
        adapter.setRecycleViewOnCLickListenerHack(this);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClickListener(View v, int position) {
        //ação ao clickar
    }
}
