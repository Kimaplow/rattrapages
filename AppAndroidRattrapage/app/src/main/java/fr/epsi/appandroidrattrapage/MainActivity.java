package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fr.epsi.appandroidrattrapage.entity.Personne;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView message = findViewById(R.id.messageConnexionMainActivity);
        message.setText("");
    }

    public void clickButtonMainActivity(View v){

        TextView message = findViewById(R.id.messageConnexionMainActivity);

        EditText emailMainActivity = findViewById(R.id.emailMainActivity);
        EditText passwordMainActivity = findViewById(R.id.passwordMainActivity);

        String email = emailMainActivity.getText().toString();
        String password = passwordMainActivity.getText().toString();

        Intent navigationToListRattrapage = new Intent(this, ListeRattrapageActivity.class);

        if(!email.equals("") && !password.equals("")) {
            CallApi callApi = new CallApi();
            Call<Personne> callPersonne = callApi.connexion(email, password);
            callPersonne.enqueue(new Callback<Personne>() {
                @Override
                public void onResponse(Call<Personne> call, Response<Personne> response) {
                    System.out.println(response.code());
                    if(response.code() == 200){
                        message.setText("Connecté !");
                        navigationToListRattrapage.putExtra("personne", response.body());
                        startActivity(navigationToListRattrapage);
                    }
                }

                @Override
                public void onFailure(Call<Personne> call, Throwable t) {
                    message.setText("Erreur lors de la connexion");
                    System.out.println("NON");
                }
            });
        }
        else{
            message.setText("Entrer un email ET un password correct");
        }
    }
}