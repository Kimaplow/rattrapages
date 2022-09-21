package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShowRattrapageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rattrapage);
    }

    public void clickButtonEleve(View v){
        Intent navigationToListEleve = new Intent(this, ListeEleveActivity.class);
        //navigationToListEleve.putExtra("listEleve", listeEleve);
        startActivity(navigationToListEleve);
    }

    public void clickButtonChrono(View v){

    }

    public void clickButtonSujet(View v){

    }

}