package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

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

        ImageView logo = findViewById(R.id.logoMainActivity);
        logo.setImageResource(R.drawable.mortarboard_fill);

        String email = emailMainActivity.getText().toString();
        String password = passwordMainActivity.getText().toString();

        Intent navigationToListRattrapage = new Intent(this, ListeRattrapageActivity.class);

        if(!email.equals("") && !password.equals("")) {
            CallApi callApi = new CallApi();
            Call<Personne> callPersonne = callApi.connexion(email, password);
            callPersonne.enqueue(new Callback<Personne>() {
                @Override
                public void onResponse(Call<Personne> call, Response<Personne> response) {
                    if(response.code() == 200) {
                        if (Objects.equals(response.body().getRole(), "surveillant")) {
                            message.setText("Connecté !");
                            navigationToListRattrapage.putExtra("personne", response.body());
                            startActivity(navigationToListRattrapage);
                        } else {
                            message.setText("Vous n'êtes pas surveillant !");
                        }
                    }
                }

                @Override
                public void onFailure(Call<Personne> call, Throwable t) {
                    message.setText("Erreur lors de la connexion");
                }
            });
        }
        else{
            message.setText("Entrer un email ET un password correct");
        }
    }
}