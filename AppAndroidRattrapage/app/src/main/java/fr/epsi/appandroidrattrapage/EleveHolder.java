package fr.epsi.appandroidrattrapage;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.epsi.appandroidrattrapage.entity.Convocation;
import retrofit2.Call;

public class EleveHolder extends RecyclerView.ViewHolder {

    public ImageView photoEleve;
    public TextView prenomEleve;
    public TextView nomEleve;
    public Button button;

    public EleveHolder(@NonNull View itemView) {
        super(itemView);
        this.photoEleve = itemView.findViewById(R.id.photoEleveCell);
        this.prenomEleve = itemView.findViewById(R.id.prenomEleveCell);
        this.nomEleve = itemView.findViewById(R.id.nomEleveCell);
        this.button = itemView.findViewById(R.id.buttonDevoirRendu);


    }
}
