package com.example.lascosasquenovemos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PruebaEscribirBD extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_escribir_bd);

        FirebaseDatabase mDatabaseInstance = FirebaseDatabase.getInstance(getString(R.string.firebase_realtime_database_URL));
        mDatabaseInstance.setPersistenceEnabled(true);
        mDatabase = mDatabaseInstance.getReference();

        EditText tNombre = findViewById(R.id.texto_nombre);
        EditText tDescripcion = findViewById(R.id.texto_descripcion);
        Button bContinuar = findViewById(R.id.boton_continuar);
        Button validar = findViewById(R.id.boton_validar);

        validar.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        mDatabase.child(String.valueOf(tNombre.getText())).setValue(String.valueOf(tDescripcion.getText())).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("firebase", e.getLocalizedMessage());
                            }
                        });
                    }
                });

        bContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(PruebaEscribirBD.this, PruebaLeerBD.class);
                startActivity(intent);
            }
        });

    }


}