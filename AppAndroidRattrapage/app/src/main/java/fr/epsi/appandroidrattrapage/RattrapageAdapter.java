package fr.epsi.appandroidrattrapage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.epsi.appandroidrattrapage.entity.Rattrapage;

public class RattrapageAdapter extends RecyclerView.Adapter<RattrapageHolder> {

    private Rattrapage[] listRattrapage;
    private OnClickRattrapageListener listener;

    public RattrapageAdapter(Rattrapage[] listRattrapage, OnClickRattrapageListener listener){
        this.listRattrapage = listRattrapage;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RattrapageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rattrapage_list_cell, parent, false);
        return new RattrapageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RattrapageHolder holder, int position) {
        holder.codeMatiere.setText(new StringBuilder().append(listRattrapage[position].getMatiere().getCode())
                .append(" - ")
                .append(listRattrapage[position].getMatiere().getLibelle()).toString());

        holder.profSalle.setText(new StringBuilder().append(listRattrapage[position].getPersonne().getPrenom())
                .append(" ")
                .append(listRattrapage[position].getPersonne().getNom())
                .append(" - Salle ")
                .append(listRattrapage[position].getSalle().getNom()));


        holder.dateHeure.setText(new StringBuilder().append(listRattrapage[position].getDate().substring(8,10))
                .append("/")
                .append(listRattrapage[position].getDate().substring(5,7))
                .append(" - ")
                .append(listRattrapage[position].getHeure().substring(0, 5)));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.showRattrapage(listRattrapage[holder.getAdapterPosition()]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listRattrapage.length;
    }
}
