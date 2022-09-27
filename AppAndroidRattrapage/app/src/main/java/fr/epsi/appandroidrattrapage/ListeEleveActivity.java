package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fr.epsi.appandroidrattrapage.entity.Convocation;
import fr.epsi.appandroidrattrapage.entity.Eleve;
import fr.epsi.appandroidrattrapage.entity.Rattrapage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeEleveActivity extends AppCompatActivity implements OnClickButtonEleveListener{

    private RecyclerView eleveRecyclerView;
    private RecyclerView.Adapter eleveAdapter;
    private RecyclerView.LayoutManager eleveLayoutManager;
    private OnClickButtonEleveListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_eleve);

        listener = this;

        long idRattrapage = getIntent().getExtras().getLong("idRattrapage");

        eleveRecyclerView = findViewById(R.id.eleveRecyclerView);
        eleveRecyclerView.setHasFixedSize(true);

        eleveLayoutManager = new LinearLayoutManager(getBaseContext());
        eleveRecyclerView.setLayoutManager(eleveLayoutManager);

        Eleve[] listEleves = {};

        eleveAdapter = new EleveAdapter(listEleves, listener, idRattrapage);
        eleveRecyclerView.setAdapter(eleveAdapter);

        CallApi callApi = new CallApi();
        Call<Eleve[]> callEleves = callApi.getEleves(idRattrapage);
        callEleves.enqueue(new Callback<Eleve[]>() {
            @Override
            public void onResponse(Call<Eleve[]> call, Response<Eleve[]> response) {
                if(response.code() == 200){
                    eleveAdapter = new EleveAdapter(response.body(), listener, idRattrapage);
                    eleveRecyclerView.setAdapter(eleveAdapter);
                }
            }

            @Override
            public void onFailure(Call<Eleve[]> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    @Override
    public void setElevePresent(long idRattrapage, long idEleve) {
        CallApi callApi = new CallApi();
        Call<Convocation> callConvocation = callApi.setElevePresent(idRattrapage, idEleve);
        callConvocation.enqueue(new Callback<Convocation>() {
            @Override
            public void onResponse(Call<Convocation> call, Response<Convocation> response) {
                if(response.code() == 200){
                    //truc
                }
            }

            @Override
            public void onFailure(Call<Convocation> call, Throwable t) {

            }
        });
    }
}