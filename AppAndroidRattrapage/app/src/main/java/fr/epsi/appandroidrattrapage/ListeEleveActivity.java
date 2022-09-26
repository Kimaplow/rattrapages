package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fr.epsi.appandroidrattrapage.entity.Eleve;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeEleveActivity extends AppCompatActivity {

    private RecyclerView eleveRecyclerView;
    private RecyclerView.Adapter eleveAdapter;
    private RecyclerView.LayoutManager eleveLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_eleve);

        eleveRecyclerView = findViewById(R.id.eleveRecyclerView);
        eleveRecyclerView.setHasFixedSize(true);

        eleveLayoutManager = new LinearLayoutManager(getBaseContext());
        eleveRecyclerView.setLayoutManager(eleveLayoutManager);

        Eleve[] listEleves = {};

        eleveAdapter = new EleveAdapter(listEleves);
        eleveRecyclerView.setAdapter(eleveAdapter);

        CallApi callApi = new CallApi();
        Call<Eleve[]> callEleve = callApi.getEleves(1);
        callEleve.enqueue(new Callback<Eleve[]>() {
            @Override
            public void onResponse(Call<Eleve[]> call, Response<Eleve[]> response) {
                System.out.println("OK");
                eleveAdapter = new EleveAdapter(listEleves);
                eleveRecyclerView.setAdapter(eleveAdapter);
            }

            @Override
            public void onFailure(Call<Eleve[]> call, Throwable t) {
                System.out.println("NON");
                System.out.println(t.getMessage());
            }
        });

    }
}