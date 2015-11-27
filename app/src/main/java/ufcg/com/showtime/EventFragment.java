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
import ufcg.com.showtime.Data.MySQLiteOpenHelper;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;


public class EventFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;
    private List<Event> events;
    private EventAdapter adapter;

    public static EventFragment newInstance(ArrayList<Event> events) {
        EventFragment fragmentDemo = new EventFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("events", events);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        events = getArguments().getParcelableArrayList("events");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.events);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        adapter = new EventAdapter(getActivity(), events);
        adapter.setRecycleViewOnCLickListenerHack(this);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClickListener(View v, int position) {
        //ação ao clickar
    }

    public void update(ArrayList<Event> events) {
        this.events = events;
        adapter.notifyDataSetChanged();
    }
}