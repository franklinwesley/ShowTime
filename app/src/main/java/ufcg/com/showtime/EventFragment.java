package ufcg.com.showtime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ufcg.com.showtime.Adapters.EventAdapter;
import ufcg.com.showtime.Data.MySQLiteOpenHelper;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;


public class EventFragment extends Fragment implements RecycleViewOnCLickListenerHack {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        MySQLiteOpenHelper bd = new MySQLiteOpenHelper(getContext());
        bd.inserirEvento("SHOW DO ANGRA EM CAMPINA GRANDE", "04-12-2015", "21:00", "Ventura Recepções (Aula Extra Music)", "https://scontent.xx.fbcdn.net/hphotos-xaf1/v/t1.0-0/c170.0.200.200/p200x200/1796506_852376334881263_8282178809894950046_n.jpg?oh=3ec85cba29d882c482472d21af56315a&oe=56891072");
        bd.inserirEvento("Forró das Antigas", "07-12-2015", "21:00", "Spazzio", "https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpl1/v/t1.0-9/p720x720/12294663_960350437333590_6274618701354522479_n.jpg?oh=0aa033eaf35d56f5ece9b3dbe9181103&oe=56E8716D&__gda__=1457818692_627f0659707dbb3cf3247a38e1705d16");
        bd.inserirEvento("Mato Seco em Campina Grande", "04-12-2015", "20:00", "Vibe Universitária", "https://festaseshows.com.br/wp-content/themes/festaseshows/timthumb.php?src=https://festaseshows.com.br/wp-content/uploads/2012/09/mato-seco.jpg&h=160&w=160&zc=1");
        bd.inserirEvento("Banda Vibrações em Campina Grande", "04-12-2015", "21:30", "Inove Recepções", "https://festaseshows.com.br/wp-content/themes/festaseshows/timthumb.php?src=https://festaseshows.com.br/wp-content/uploads/2015/08/vibra%C3%A7oes-perfil.jpg&h=160&w=160&zc=1");
        bd.inserirEvento("O Rappa", "05-12-2015", "20:00", "Centro de Eventos César Rosalém", "https://s3-sa-east-1.amazonaws.com/blueticket/images/imagens/eventos3/15719.jpg");
        final List<Event> events = bd.recuperarEventos();

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
