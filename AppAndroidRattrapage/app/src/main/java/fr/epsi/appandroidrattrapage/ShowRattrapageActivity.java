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

        long idRattrapage = getIntent().getExtras().getLong("rattrapage");

        final Rattrapage[] rattrapage = new Rattrapage[1];

        CallApi callApi = new CallApi();
        Call<Rattrapage> callRattrapage = callApi.getRattrapage(idRattrapage);

        callRattrapage.enqueue(new Callback<Rattrapage>() {
            @Override
            public void onResponse(Call<Rattrapage> call, Response<Rattrapage> response) {
                if(response.code() == 200){
                    rattrapage[0] = response.body();

                    TextView titleShowRattrapage = findViewById(R.id.titleShowRattrapage);
                    TextView matiereShowRattrapage = findViewById(R.id.matiereShowRattrapage);
                    TextView profSalleShowRattrapage = findViewById(R.id.profSalleShowRattrapage);
                    TextView dateHeureShowRattrapage = findViewById(R.id.dateHeureShowRattrapage);
                    TextView dureeShowRattrapage = findViewById(R.id.dureeShowRattrapage);
                    TextView nbrEleveShowRattrapage = findViewById(R.id.nbrEleveShowRattrapage);
                    TextView tempsRestantShowRattrapage = findViewById(R.id.tempsRestantShowRattrapage);

                    titleShowRattrapage.setText(new StringBuilder().append("Rattrapage n°")
                            .append(rattrapage[0].getIdRattrapage()).toString());

                    matiereShowRattrapage.setText(new StringBuilder().append(rattrapage[0].getMatiere().getCode())
                            .append(" - ")
                            .append(rattrapage[0].getMatiere().getLibelle()).toString());

                    profSalleShowRattrapage.setText(new StringBuilder().append(rattrapage[0].getPersonne().getPrenom())
                            .append(" ")
                            .append(rattrapage[0].getPersonne().getNom())
                            .append(" - Salle ")
                            .append(rattrapage[0].getSalle().getNom()));

                    dateHeureShowRattrapage.setText(new StringBuilder().append(rattrapage[0].getDate().substring(8,10))
                            .append("/")
                            .append(rattrapage[0].getDate().substring(5,7))
                            .append(" - ")
                            .append(rattrapage[0].getHeure().substring(0, 5)));

                    int heure = rattrapage[0].getDuree() / 60;
                    int min = rattrapage[0].getDuree() - (60*heure);
                    if(min != 0){
                        dureeShowRattrapage.setText(heure + "h" + min);
                        tempsRestantShowRattrapage.setText("Temps restant : 0" + heure + ":" + min + "00");
                    }
                    else{
                        dureeShowRattrapage.setText(heure + "h");
                        tempsRestantShowRattrapage.setText("Temps restant : 0" + heure + ":00:00");
                    }


                    if(!Objects.equals(rattrapage[0].getEtat(), "Non effectué")){
                        Button btnEffectue = findViewById(R.id.buttonEffectueShowRattrapage);
                        btnEffectue.setEnabled(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<Rattrapage> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    public void clickButtonEleve(View v){
        Intent navigationToListEleve = new Intent(this, ListeEleveActivity.class);
        //Rattrapage rattrapage = (Rattrapage) getIntent().getSerializableExtra("rattrapage");
        long idRattrapage = getIntent().getExtras().getLong("rattrapage");
        navigationToListEleve.putExtra("idRattrapage", idRattrapage);
        startActivity(navigationToListEleve);
    }

    public void clickButtonChrono(View v){

    }

    public void clickButtonSujet(View v){
        long idRattrapage = getIntent().getExtras().getLong("rattrapage");
        CallApi callApi = new CallApi();
        Call<Rattrapage> callRattrapage = callApi.setRattrapageEffectue(idRattrapage);
        callRattrapage.enqueue(new Callback<Rattrapage>() {
            @Override
            public void onResponse(Call<Rattrapage> call, Response<Rattrapage> response) {
                if(response.code() == 200){
                    Button btnEffectue = findViewById(R.id.buttonEffectueShowRattrapage);
                    btnEffectue.setEnabled(false);
                }
            }

            @Override
            public void onFailure(Call<Rattrapage> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }





}