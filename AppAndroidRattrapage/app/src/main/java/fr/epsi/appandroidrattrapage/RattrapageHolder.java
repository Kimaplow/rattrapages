package fr.epsi.appandroidrattrapage;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RattrapageHolder extends RecyclerView.ViewHolder {

    public TextView codeMatiere;
    public TextView profSalle;
    public TextView dateHeure;

    public RattrapageHolder(@NonNull View itemView){
        super(itemView);
        this.codeMatiere = itemView.findViewById(R.id.codeMatiereCell);
        this.profSalle = itemView.findViewById(R.id.profSalleCell);
        this.dateHeure = itemView.findViewById(R.id.dateHeureCell);
    }

}
