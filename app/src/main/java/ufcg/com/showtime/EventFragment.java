package ufcg.com.showtime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ufcg.com.showtime.Models.Event;


public class EventFragment extends Fragment {

    private Event event;

    public static EventFragment newInstance(Event event) {
        EventFragment fragmentDemo = new EventFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", event);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = getArguments().getParcelable("event");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        ImageView banner = (ImageView) v.findViewById(R.id.event_banner);
        TextView nome = (TextView) v.findViewById(R.id.event_nome);
        TextView lugar = (TextView) v.findViewById(R.id.event_lugar);
        TextView data = (TextView) v.findViewById(R.id.event_data);
        TextView hora = (TextView) v.findViewById(R.id.event_hora);

        Glide.with(banner.getContext()).load(event.getBanner()).into(banner);
        nome.setText(event.getNome());
        lugar.setText("Local: " + event.getLugar());
        String[] d = event.getData().split("-");
        String date = d[0] + "/" + d[1] + "/" + d[2];
        data.setText("Data: " + date);
        hora.setText("Hora: " + event.getHora());


        return v;
    }
}