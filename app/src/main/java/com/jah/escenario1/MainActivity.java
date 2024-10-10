package com.jah.escenario1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgContenido;
    RadioButton rbNombres, rbCiudades, rbDeportes;
    Spinner spLista;
    ArrayAdapter<CharSequence> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rgContenido = findViewById(R.id.rgContenido);
        rbNombres = findViewById(R.id.rbNombres);
        rbCiudades = findViewById(R.id.rbCiudades);
        rbDeportes = findViewById(R.id.rbDeportes);
        spLista = findViewById(R.id.spLista);

        rbNombres.setChecked(true);

        adaptador = ArrayAdapter.createFromResource(this, R.array.nombres, android.R.layout.simple_spinner_dropdown_item);
        spLista.setAdapter(adaptador);


        rgContenido.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if(checkedId != -1){
                if(rbNombres.isChecked())
                    adaptador = ArrayAdapter.createFromResource(this, R.array.nombres, android.R.layout.simple_spinner_dropdown_item);
                else if(rbCiudades.isChecked())
                    adaptador = ArrayAdapter.createFromResource(this, R.array.ciudades, android.R.layout.simple_spinner_dropdown_item);
                else
                    adaptador = ArrayAdapter.createFromResource(this, R.array.deportes, android.R.layout.simple_spinner_dropdown_item);
            }else{
                System.err.println("ERROR: Debes marcar una de las tres opciones");
            }

            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spLista.setAdapter(adaptador);
        });


        spLista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}