package fr.epsi.appandroidrattrapage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

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

        rattrapageRecyclerview = findViewById(R.id.rattrapagesRecyclerView);
        rattrapageRecyclerview.setHasFixedSize(true);

        rattrapageLayoutManager = new LinearLayoutManager(getBaseContext());
        rattrapageRecyclerview.setLayoutManager(rattrapageLayoutManager);


        Rattrapage[] listRattrapage = {};

        rattrapageAdapter = new RattrapageAdapter(listRattrapage, this);
        rattrapageRecyclerview.setAdapter(rattrapageAdapter);

        CallApi callApi = new CallApi();
        Call<Rattrapage[]> callRattrapages = callApi.getRattrapages(6);
        callRattrapages.enqueue(new Callback<Rattrapage[]>() {
            @Override
            public void onResponse(Call<Rattrapage[]> call, Response<Rattrapage[]> response) {
                System.out.println("ALLO");
                rattrapageAdapter = new RattrapageAdapter(response.body(), listener);
                rattrapageRecyclerview.setAdapter(rattrapageAdapter);
            }

            @Override
            public void onFailure(Call<Rattrapage[]> call, Throwable t) {
                System.out.println("NON");
            }
        });



    }

    @Override
    public void showRattrapage(Rattrapage rattrapage) {
        Intent navigationToShowRattrapage = new Intent(this, ShowRattrapageActivity.class);
        navigationToShowRattrapage.putExtra("rattrapage", rattrapage);
        startActivity(navigationToShowRattrapage);
    }
}