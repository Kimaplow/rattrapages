package fr.epsi.appandroidrattrapage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import fr.epsi.appandroidrattrapage.entity.Eleve;

public class EleveAdapter extends RecyclerView.Adapter<EleveHolder> {

    private Eleve[] listEleves;
    private OnClickButtonEleveListener listener;
    private long idRattrapage;

    public EleveAdapter(Eleve[] listEleves, OnClickButtonEleveListener listener, long idRattrapage){
        this.listEleves = listEleves;
        this.listener = listener;
        this.idRattrapage = idRattrapage;
    }

    @NonNull
    @Override
    public EleveHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eleve_list_cell, parent, false);
        return new EleveHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EleveHolder holder, int position) {
        holder.nomEleve.setText(listEleves[position].getNom());
        holder.prenomEleve.setText(listEleves[position].getPrenom());
        Picasso.get().load("http://192.168.1.60:8080/photos/scatcat.png").into(holder.photoEleve);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setElevePresent(idRattrapage, listEleves[position].getIdEleve());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listEleves.length;
    }
}
