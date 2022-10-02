package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import fr.epsi.appandroidrattrapage.entity.Eleve;
import fr.epsi.appandroidrattrapage.entity.Rattrapage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowRattrapageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rattrapage);

        Rattrapage rattrapage = (Rattrapage) getIntent().getSerializableExtra("rattrapage");

        TextView titleShowRattrapage = findViewById(R.id.titleShowRattrapage);
        TextView matiereShowRattrapage = findViewById(R.id.matiereShowRattrapage);
        TextView profSalleShowRattrapage = findViewById(R.id.profSalleShowRattrapage);
        TextView dateHeureShowRattrapage = findViewById(R.id.dateHeureShowRattrapage);
        TextView dureeShowRattrapage = findViewById(R.id.dureeShowRattrapage);
        TextView nbrEleveShowRattrapage = findViewById(R.id.nbrEleveShowRattrapage);
        TextView tempsRestantShowRattrapage = findViewById(R.id.tempsRestantShowRattrapage);

        titleShowRattrapage.setText(new StringBuilder().append("Rattrapage n°")
                .append(rattrapage.getIdRattrapage()).toString());

        matiereShowRattrapage.setText(new StringBuilder().append(rattrapage.getMatiere().getCode())
                .append(" - ")
                .append(rattrapage.getMatiere().getLibelle()).toString());

        profSalleShowRattrapage.setText(new StringBuilder().append(rattrapage.getPersonne().getPrenom())
                .append(" ")
                .append(rattrapage.getPersonne().getNom())
                .append(" - Salle ")
                .append(rattrapage.getSalle().getNom()));

        dateHeureShowRattrapage.setText(new StringBuilder().append(rattrapage.getDate().substring(8,10))
                .append("/")
                .append(rattrapage.getDate().substring(5,7))
                .append(" - ")
                .append(rattrapage.getHeure().substring(0, 5)));

        int heure = rattrapage.getDuree() / 60;
        int min = rattrapage.getDuree() - (60*heure);
        if(min != 0){
            dureeShowRattrapage.setText(heure + "h" + min);
            tempsRestantShowRattrapage.setText("Temps restant : 0" + heure + ":" + min + "00");
        }
        else{
            dureeShowRattrapage.setText(heure + "h");
            tempsRestantShowRattrapage.setText("Temps restant : 0" + heure + ":00:00");
        }


        if(!Objects.equals(rattrapage.getEtat(), "Non effectué")){
            Button btnEffectue = findViewById(R.id.buttonEffectueShowRattrapage);
            btnEffectue.setEnabled(false);
        }

    }

    public void clickButtonEleve(View v){
        Intent navigationToListEleve = new Intent(this, ListeEleveActivity.class);
        Rattrapage rattrapage = (Rattrapage) getIntent().getSerializableExtra("rattrapage");
        navigationToListEleve.putExtra("idRattrapage", rattrapage.getIdRattrapage());
        startActivity(navigationToListEleve);
    }

    public void clickButtonChrono(View v){

    }

    public void clickButtonSujet(View v){
        Rattrapage rattrapage = (Rattrapage) getIntent().getSerializableExtra("rattrapage");
        CallApi callApi = new CallApi();
        Call<Rattrapage> callRattrapage = callApi.setRattrapageEffectue(rattrapage.getIdRattrapage());
        callRattrapage.enqueue(new Callback<Rattrapage>() {
            @Override
            public void onResponse(Call<Rattrapage> call, Response<Rattrapage> response) {
                if(response.code() == 200){
                    Button btnEffectue = findViewById(R.id.buttonEffectueShowRattrapage);
                    btnEffectue.setEnabled(false);
                    rattrapage.setEtat("Effectué mais non noté");
                }
            }

            @Override
            public void onFailure(Call<Rattrapage> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }



}