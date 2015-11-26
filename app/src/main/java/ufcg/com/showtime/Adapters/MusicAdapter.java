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

import com.bumptech.glide.Glide;

import java.util.List;

import ufcg.com.showtime.Interfaces.RecycleViewOnCLickListenerHack;
import ufcg.com.showtime.Models.Event;
import ufcg.com.showtime.Models.Musico;
import ufcg.com.showtime.R;

/**
 * Created by franklin on 21/11/15.
 */
public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder>  {
    private Context context;
    private List<Musico> musics;
    private LayoutInflater layoutInflater;
    private RecycleViewOnCLickListenerHack recycleViewOnCLickListenerHack;
    private float scale;
    private int width;
    private int heigth;
    public MusicAdapter(Context context, List<Musico> musics) {
        this.context = context;
        this.musics = musics;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.scale = this.context.getResources().getDisplayMetrics().density;
        this.width = this.context.getResources().getDisplayMetrics().widthPixels - (int)(14 * scale + 0.5f);
        this.heigth = (width / 16) * 9;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        MusicViewHolder musicViewHolder = new MusicViewHolder(view);

        return musicViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {

        Musico music = musics.get(position);
        holder.name.setText(music.getNome());
        holder.estilo.setText(music.getEstiloMusical());

        Glide.with(holder.imagePhoto.getContext()).load(music.getBanner()).into(holder.imagePhoto);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            holder.imagePhoto.setImage(event.getBanner());
//        } else {
//            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id da imagem);
//            bitmap.createScaledBitmap(bitmap, width, heigth, false);
//            bitmap = ImageHelper.getRoundedCornerBitmap(context, bitmap, 10, width, heigth, false, false, true, true);
//            holder.imagePhoto.setImageBitmap(bitmap);
//        }
    }

    private Bitmap image (byte[] binario) {
        return BitmapFactory.decodeByteArray(binario, 0, binario.length);
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public void setRecycleViewOnCLickListenerHack (RecycleViewOnCLickListenerHack r) {
        this.recycleViewOnCLickListenerHack = r;
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        TextView estilo;
        ImageView imagePhoto;

        public MusicViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            estilo = (TextView) itemView.findViewById(R.id.text);
            imagePhoto = (ImageView) itemView.findViewById(R.id.photo);

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