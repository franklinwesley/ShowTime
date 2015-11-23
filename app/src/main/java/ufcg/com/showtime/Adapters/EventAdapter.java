package ufcg.com.showtime.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ufcg.com.showtime.Helpers.ImageHelper;
import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.R;

/**
 * Created by franklin on 21/11/15.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>  {
    private Context context;
    private List<Event> events;
    private LayoutInflater layoutInflater;
    private RecycleViewOnCLickListenerHack recycleViewOnCLickListenerHack;
    private float scale;
    private int width;
    private int heigth;

    public EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.scale = this.context.getResources().getDisplayMetrics().density;
        this.width = this.context.getResources().getDisplayMetrics().widthPixels - (int)(14 * scale + 0.5f);
        this.heigth = (width / 16) * 9;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);

        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        Event event = events.get(position);
        holder.name.setText(event.getNome());
        holder.lugar.setText(event.getLugar());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//        holder.imagePhoto.setImage(event.getBanner());
        } else {
//            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id da imagem);
//            bitmap.createScaledBitmap(bitmap, width, heigth, false);
//            bitmap = ImageHelper.getRoundedCornerBitmap(context, bitmap, 10, width, heigth, false, false, true, true);
//            holder.imagePhoto.setImageBitmap(bitmap);
        }
    }

    private Bitmap image (byte[] binario) {
        return BitmapFactory.decodeByteArray(binario, 0, binario.length);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setRecycleViewOnCLickListenerHack (RecycleViewOnCLickListenerHack r) {
        this.recycleViewOnCLickListenerHack = r;
    }

    public void addListGame(Event event, int position) {
        events.add(event);
        notifyItemInserted(position);
    }

    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        TextView lugar;
        ImageView imagePhoto;

        public EventViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.event_name);
            lugar = (TextView) itemView.findViewById(R.id.event_lugar);
            imagePhoto = (ImageView) itemView.findViewById(R.id.event_photo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (recycleViewOnCLickListenerHack != null) {
                recycleViewOnCLickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}