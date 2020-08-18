package com.example.calculargorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText value, person;
    private TextView textPorcentagemValue, textGorjeta, textTotal, textTotalPerson;
    private SeekBar seekbar;

    double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = findViewById(R.id.value);
        person = findViewById(R.id.person);
        textPorcentagemValue = findViewById(R.id.porcentagem_value);
        textGorjeta = findViewById(R.id.gorjeta);
        textTotal = findViewById(R.id.total);
        textTotalPerson = findViewById(R.id.total_person);
        seekbar = findViewById(R.id.seekBar);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagemValue.setText(Math.round(porcentagem) +"%");

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    public void calcular() {


        String valueUser = value.getText().toString();
        String personNumber = person.getText().toString();

        if((valueUser == null || valueUser.equals("")) || (personNumber == null || personNumber.equals(""))  ){

            Toast.makeText(this, "Por gentileza infoem os campos", Toast.LENGTH_SHORT).show();

        }else{

            double valueType = Double.parseDouble(valueUser);

            double gorjeta = valueType * (porcentagem * 0.01) ;

            double valueTotal = valueType + gorjeta;

            double valuePerson = valueTotal / Double.parseDouble(personNumber);

            textGorjeta.setText(String.format("R$: %.2f",gorjeta));

            textTotal.setText(String.format("R$: %.2f",valueTotal));

            textTotalPerson.setText(String.format("R$: %.2f", valuePerson));
        }


    }
}
