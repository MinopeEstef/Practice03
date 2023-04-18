package com.example.practice03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupOperacion;
    EditText value;
    Button buttonConverter;
    TextView result;
    double response;
    String medida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupOperacion = findViewById(R.id.radioGroupOperacion);
        value = findViewById(R.id.value);
        buttonConverter = findViewById(R.id.buttonConverter);
        result = findViewById(R.id.result);

        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double num = Double.parseDouble(value.getText().toString());
                if(num.isNaN()){
                    result.setText("No ingreso dato");
                    return;
                }
                switch (radioGroupOperacion.getCheckedRadioButtonId()) {
                    case R.id.radioButtonMK:
                        response = num / 1000;
                        medida = "KM";
                        break;
                    case R.id.radioButtonKM:
                        response = num * 1000;
                        medida = "M";
                        break;
                    default:
                        result.setText("No ha seleccionado una opción");
                        return;
                }
                result.setText(getResult(response,medida));
            }
        });


    }
    private String getResult(Object resultado,Object medida) {
        final String TXT_RESULTADO = "El resultado es: %s %s ";
        return String.format(TXT_RESULTADO, resultado,medida);
    }

}