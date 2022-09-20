package fr.epsi.appandroidrattrapage;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RattrapageHolder extends RecyclerView.ViewHolder {

    public TextView codeMatiere;
    public TextView matiere;
    public TextView professeur;
    public TextView salle;
    public TextView date;
    public TextView heure;

    public RattrapageHolder(@NonNull View itemView){
        super(itemView);
        this.codeMatiere = itemView.findViewById(R.id.codeMatiereCell);
        this.matiere = itemView.findViewById(R.id.matiereCell);
        this.professeur = itemView.findViewById(R.id.professeurCell);
        this.salle = itemView.findViewById(R.id.salleCell);
        this.date = itemView.findViewById(R.id.dateCell);
        this.heure = itemView.findViewById(R.id.heureCell);
    }

}
