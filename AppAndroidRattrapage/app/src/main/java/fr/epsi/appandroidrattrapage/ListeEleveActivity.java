package fr.epsi.appandroidrattrapage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        Convocation[] listEleves = {};

        eleveAdapter = new EleveAdapter(listEleves, listener);
        eleveRecyclerView.setAdapter(eleveAdapter);

        CallApi callApi = new CallApi();
        Call<Convocation[]> callEleves = callApi.getEleves(idRattrapage);
        callEleves.enqueue(new Callback<Convocation[]>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Convocation[]> call, Response<Convocation[]> response) {
                if(response.code() == 200){
                    List<Convocation> listConvocations = Arrays.asList(response.body());
                    Collections.sort(listConvocations, Comparator.comparing((Convocation c) -> c.getEleve().getIdEleve()));
                    eleveAdapter = new EleveAdapter(listConvocations.toArray(new Convocation[listConvocations.size()]), listener);
                    eleveRecyclerView.setAdapter(eleveAdapter);
                }
            }

            @Override
            public void onFailure(Call<Convocation[]> call, Throwable t) {
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
                    recreate();
                }
            }

            @Override
            public void onFailure(Call<Convocation> call, Throwable t) {

            }
        });
    }
}