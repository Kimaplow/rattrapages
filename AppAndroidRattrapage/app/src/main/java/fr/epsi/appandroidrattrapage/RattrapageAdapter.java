package fr.epsi.appandroidrattrapage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.codeMatiere.setText(listRattrapage[position].getCodeMatiere());
        holder.matiere.setText(listRattrapage[position].getMatiere());
        holder.professeur.setText(listRattrapage[position].getProfesseur());
        holder.salle.setText(listRattrapage[position].getSalle());
        holder.date.setText(listRattrapage[position].getDate());
        holder.heure.setText(listRattrapage[position].getHeure());
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
