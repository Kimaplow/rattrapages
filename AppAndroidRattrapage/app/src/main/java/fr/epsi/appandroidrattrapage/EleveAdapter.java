package fr.epsi.appandroidrattrapage;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import fr.epsi.appandroidrattrapage.entity.Convocation;
import fr.epsi.appandroidrattrapage.entity.Eleve;

public class EleveAdapter extends RecyclerView.Adapter<EleveHolder> {

    private Convocation[] listEleves;
    private OnClickButtonEleveListener listener;

    public EleveAdapter(Convocation[] listEleves, OnClickButtonEleveListener listener){
        this.listEleves = listEleves;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EleveHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eleve_list_cell, parent, false);
        return new EleveHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EleveHolder holder, int position) {
        holder.nomEleve.setText(listEleves[position].getEleve().getNom());
        holder.prenomEleve.setText(listEleves[position].getEleve().getPrenom());
        holder.heureRendu.setText(listEleves[position].getHeureRendu());
        Picasso.get().load("http://10.60.12.60:8080/photos/scatcat.png").into(holder.photoEleve);

        if(listEleves[position].isPresent()){
            holder.button.setBackgroundColor(Color.MAGENTA);
            holder.heureRendu.setText(listEleves[position].getHeureRendu());
        }

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.setElevePresent(listEleves[position].getKey().getIdRattrapage(), listEleves[position].getKey().getIdEleve());
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listEleves.length;
    }
}
