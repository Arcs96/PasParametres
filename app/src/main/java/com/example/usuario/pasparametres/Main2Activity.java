package com.example.usuario.pasparametres;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button boton2;
    private TextView texto1;
    private EditText edit2;
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        texto1 = (TextView) findViewById(R.id.textView3);
        edit2 = (EditText) findViewById(R.id.editText2);
        boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActivity2(v, edit2.getText().toString());
            }
        });
        recogerExtras1();
    }

    public void recogerExtras1() {
        Bundle extras= getIntent().getExtras();
        String s= extras.getString("txtNom");
        texto1.setText("Hola "+s+", indica´ns les seguents dades:");
    }

    public void lanzarActivity2(View v, String edit){
        Intent i = new Intent(this, MainActivity.class);
        /*edad=Integer.parseInt(edit);*/
        i.putExtra("txtEdad", edit);
        setResult(MainActivity.RESULT_OK,i);
        finish();
    }
}
