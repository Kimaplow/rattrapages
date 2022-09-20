package fr.epsi.appandroidrattrapage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        if(!email.equals("") && !password.equals("")){
            if(email.equals("admin") && password.equals("secret")){
                message.setText("Connecté !");

                Intent navigationToListRattrapage = new Intent(this, ListeRattrapageActivity.class);
                startActivity(navigationToListRattrapage);
            }
            else{
                message.setText("Erreur lors de la connexion");
            }
        }
        else{
            message.setText("Entrer un email ET un password correct");
        }

    }
}