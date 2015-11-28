package ufcg.com.showtime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ufcg.com.showtime.Adapters.MusicAdapter;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Musico;


public class MusicListFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;
    private ArrayList<Musico> musicos;
    private MusicAdapter adapter;

    public static MusicListFragment newInstance(ArrayList<Musico> musicos) {
        MusicListFragment fragmentDemo = new MusicListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("musicos", musicos);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicos = getArguments().getParcelableArrayList("musicos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.events);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        adapter = new MusicAdapter(getActivity(), musicos);
        adapter.setRecycleViewOnCLickListenerHack(this);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onClickListener(View v, int position) {
        //ação ao clickar
    }

    public void update(ArrayList<Musico> musicos) {
        this.musicos = musicos;
        adapter.notifyDataSetChanged();
    }
}
