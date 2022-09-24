package vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;

import controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }
    private EditText textPoids;
    private EditText textTaille;
    private EditText textAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgNormal;
    private Controle controle;

    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init()
    {
        textPoids = (EditText)findViewById(R.id.textPoids);
        textTaille = (EditText)findViewById(R.id.textTaille);
        textAge = (EditText)findViewById(R.id.textAge);
        rdHomme= (RadioButton)findViewById(R.id.rdHomme);
        lblIMG = (TextView)findViewById(R.id.lblIMG);
        imgNormal= (ImageView)findViewById(R.id.imgNormal);
        ecouteCalcul();
    }
    /**
     * écoute evenement sur button calcul
     */
   private void ecouteCalcul()
    {
        ((Button) findViewById(R.id.btncalc)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
               //Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
               int poids = 0;
               int taille = 0;
               int age = 0;
               int sexe = 0;
               //recuperation des données saisies
               try {
                   poids = Integer.parseInt(textPoids.getText().toString());
                   taille = Integer.parseInt(textTaille.getText().toString());
                   age = Integer.parseInt(textAge.getText().toString());
               }
               catch(Exception e){};
               if(rdHomme.isChecked())
               {
                   sexe =  1;
               }
               if (poids == 0 || taille == 0 || age == 0)
               {
                   Toast.makeText(MainActivity.this, "saisie incorrect" , Toast.LENGTH_SHORT).show();
               }
               else
               {
                   afficherResult(poids, taille, age, sexe);
               }
            }
        });
    }

    /**
     * afficher L'IMG de message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
        private void afficherResult(int poids, int taille, int age, int sexe)
        {
          //creation du profile et recuperation des informations
            this.controle.createProfil(poids, taille, age, sexe);
           float img =  this.controle.getImg();
           String message = this.controle.getMessage();

      //affichage
    if (message =="normale")
    {
      imgNormal.setImageResource(R.drawable.normal);
       lblIMG.setTextColor(Color.GREEN);
    }
    else{
        lblIMG.setTextColor(Color.RED);
        if(message =="trop faible")
          {
            imgNormal.setImageResource(R.drawable.maigre);
          }
        else
          {
            imgNormal.setImageResource(R.drawable.graisse);
          }

         }
         lblIMG.setText(img + ": IMG " + message);
        }
    }