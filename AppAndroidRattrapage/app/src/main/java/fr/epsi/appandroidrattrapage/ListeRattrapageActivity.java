package fr.epsi.appandroidrattrapage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ListeRattrapageActivity extends AppCompatActivity implements OnClickRattrapageListener{

    private RecyclerView rattrapageRecyclerview;
    private RecyclerView.Adapter rattrapageAdapter;
    private RecyclerView.LayoutManager rattrapageLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rattrapage);

        rattrapageRecyclerview = findViewById(R.id.rattrapagesRecyclerView);
        rattrapageRecyclerview.setHasFixedSize(true);

        rattrapageLayoutManager = new LinearLayoutManager(getBaseContext());
        rattrapageRecyclerview.setLayoutManager(rattrapageLayoutManager);

        //todo appel api

        Rattrapage[] listRattrapage = {new Rattrapage("UE1", "Mathématique", "Dupont", "B12", "01/01/2023", "08:00"),
                new Rattrapage("UE1", "Mathématique", "Dupont", "B12", "01/01/2023", "08:00"),
                new Rattrapage("UE1", "Mathématique", "Dupont", "B12", "01/01/2023", "08:00"),
                new Rattrapage("UE1", "Mathématique", "Dupont", "B12", "01/01/2023", "08:00"),
                new Rattrapage("UE1", "Mathématique", "Dupont", "B12", "01/01/2023", "08:00"),
                new Rattrapage("UE1", "Mathématique", "Dupont", "B12", "01/01/2023", "08:00"),
        };

        rattrapageAdapter = new RattrapageAdapter(listRattrapage, this);
        rattrapageRecyclerview.setAdapter(rattrapageAdapter);

    }

    @Override
    public void showRattrapage(Rattrapage rattrapage) {
        Intent navigationToShowRattrapage = new Intent(this, ShowRattrapageActivity.class);
        navigationToShowRattrapage.putExtra("rattrapage", rattrapage);
        startActivity(navigationToShowRattrapage);
    }
}