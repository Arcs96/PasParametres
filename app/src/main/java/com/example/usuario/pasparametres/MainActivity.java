package com.example.usuario.pasparametres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_TEXT = 0;
    private EditText edit1;
    private Button boton1;
    private TextView texto2;
    private RadioGroup radioGroup;
    private RadioButton rFemella, rMascle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText) findViewById(R.id.editText);
        texto2 = (TextView) findViewById(R.id.textView5);
        radioGroup = (RadioGroup) findViewById(R.id.sexe);
        rFemella = (RadioButton) findViewById(R.id.radio_femella);
        rMascle = (RadioButton) findViewById(R.id.radio_mascle);
        boton1 = (Button) findViewById(R.id.button);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActivity1(v, edit1.getText().toString());
            }
        });

        if (savedInstanceState != null) {
            String retorna = savedInstanceState.getString("RETORNA");
            boolean boton = savedInstanceState.getBoolean("BOTON");
            boolean nom = savedInstanceState.getBoolean("NOM");
            boolean grup = savedInstanceState.getBoolean("GRUP");
            boolean mascle = savedInstanceState.getBoolean("MASCLE");
            boolean femella = savedInstanceState.getBoolean("FEMELLA");
            if (boton == false)
                boton1.setEnabled(false);
            if (nom == false)
                edit1.setEnabled(false);

            /*if (grup == false)
                radioGroup.setEnabled(false);
            if (mascle == false)
                rFemella.setEnabled(false);
            if (femella == false)
                rMascle.setEnabled(false);*/

            texto2.setText(retorna);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( requestCode == REQUEST_TEXT ){
            if ( resultCode == MainActivity.RESULT_OK ){
                String ed = data.getStringExtra("txtEdad");
                int edad = Integer.parseInt(ed);
                if((edad>18) && (edad<25)) {
                    texto2.setText("Com que tens " + edad + " anys, ja eres major d´edat");
                }
                if((edad>=25) && (edad<35)) {
                    texto2.setText("Com que tens " + edad + " anys, estas en la flor de la vida");
                }
                if(edad>=35) {
                    texto2.setText("Com que tens " + edad + " anys, ai ai ai...");
                }
                desactivar();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("RETORNA", texto2.getText().toString());
        outState.putBoolean("BOTON", boton1.isEnabled());
        outState.putBoolean("EDITNOM", edit1.isEnabled());
        /*outState.putBoolean("GRUP", radioGroup.isEnabled());
        outState.putBoolean("MASCLE", rMascle.isEnabled());
        outState.putBoolean("FEMELLA", rFemella.isEnabled());*/
        super.onSaveInstanceState(outState);
    }

    public void lanzarActivity1(View v, String edit){
        Intent i = new Intent(this, Main2Activity.class);
        if (edit.equals("") || edit.equals(null))
            i.putExtra("txtNom", "TEXTO VACÍO");
        else
            i.putExtra("txtNom", edit);
        startActivityForResult(i,REQUEST_TEXT);
    }

    public void desactivar(){
        boton1.setEnabled(false);
        edit1.setEnabled(false);
        radioGroup.setEnabled(false);
        rMascle.setEnabled(false);
        rFemella.setEnabled(false);
    }

}
