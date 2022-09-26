package fr.epsi.appandroidrattrapage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EleveHolder extends RecyclerView.ViewHolder {

    public ImageView photoEleve;
    public TextView prenomEleve;
    public TextView nomEleve;

    public EleveHolder(@NonNull View itemView) {
        super(itemView);
    }
}
