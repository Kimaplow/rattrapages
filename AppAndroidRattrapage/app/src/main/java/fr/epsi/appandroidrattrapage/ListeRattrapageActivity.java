package fr.epsi.appandroidrattrapage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fr.epsi.appandroidrattrapage.entity.Personne;
import fr.epsi.appandroidrattrapage.entity.Rattrapage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeRattrapageActivity extends AppCompatActivity implements OnClickRattrapageListener{

    private RecyclerView rattrapageRecyclerview;
    private RecyclerView.Adapter rattrapageAdapter;
    private RecyclerView.LayoutManager rattrapageLayoutManager;
    private OnClickRattrapageListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rattrapage);

        listener = this;

        rattrapageRecyclerview = findViewById(R.id.rattrapagesRecyclerView);
        rattrapageRecyclerview.setHasFixedSize(true);

        rattrapageLayoutManager = new LinearLayoutManager(getBaseContext());
        rattrapageRecyclerview.setLayoutManager(rattrapageLayoutManager);

        Rattrapage[] listRattrapage = {};

        rattrapageAdapter = new RattrapageAdapter(listRattrapage, listener);
        rattrapageRecyclerview.setAdapter(rattrapageAdapter);

        Personne p = (Personne) getIntent().getSerializableExtra("personne");

        CallApi callApi = new CallApi();
        Call<Rattrapage[]> callRattrapages = callApi.getRattrapages(p.getIdPersonne());
        callRattrapages.enqueue(new Callback<Rattrapage[]>() {
            @Override
            public void onResponse(Call<Rattrapage[]> call, Response<Rattrapage[]> response) {
                rattrapageAdapter = new RattrapageAdapter(response.body(), listener);
                rattrapageRecyclerview.setAdapter(rattrapageAdapter);
            }

            @Override
            public void onFailure(Call<Rattrapage[]> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    @Override
    public void showRattrapage(Rattrapage rattrapage) {
        Intent navigationToShowRattrapage = new Intent(this, ShowRattrapageActivity.class);
        navigationToShowRattrapage.putExtra("rattrapage", rattrapage.getIdRattrapage());
        startActivity(navigationToShowRattrapage);
    }
}