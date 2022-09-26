package fr.epsi.appandroidrattrapage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.epsi.appandroidrattrapage.entity.Eleve;

public class EleveAdapter extends RecyclerView.Adapter<EleveHolder> {

    private Eleve[] listEleves;

    public EleveAdapter(Eleve[] listEleves){
        this.listEleves = listEleves;
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
        //Picasso

    }

    @Override
    public int getItemCount() {
        return this.listEleves.length;
    }
}
