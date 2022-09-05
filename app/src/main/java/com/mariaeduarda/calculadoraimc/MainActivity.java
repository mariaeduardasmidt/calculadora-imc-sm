package com.mariaeduarda.calculadoraimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mariaeduarda.calculadoraimc.R;

public class MainActivity extends AppCompatActivity {
    private Button btnCalcular;
    private EditText edtAltura, edtPeso;
    private TextView imcResultado, imcClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        edtAltura = findViewById(R.id.edtAltura);
        edtPeso = findViewById(R.id.edtPeso);
        imcResultado = findViewById(R.id.numResultado);
        imcClassificacao = findViewById(R.id.txtClassificacao);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double imc = peso/(altura*altura);

                imcResultado.setText(String.format("%.2f", imc));

                if(imc > 16 && imc < 16.9){
                    imcClassificacao.setText("IMC muito abaixo do peso, cuidado!");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                else if(imc > 17 && imc < 18.4){
                    imcClassificacao.setText("Você está abaixo do peso.");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                else if(imc > 18.5 && imc < 24.9){
                    imcClassificacao.setText("Peso normal.");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                else if(imc > 25 && imc < 29.9){
                    imcClassificacao.setText("IMC acima do peso.");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                else if(imc > 30 && imc < 34.9){
                    imcClassificacao.setText("Atenção, obesidade Grau I.");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                else if(imc > 35 && imc < 40) {
                    imcClassificacao.setText("Atenção, obesidade Grau II.");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                else if(imc > 40){
                    imcClassificacao.setText("Obesidade Grau III, cuidado!");
                    imcClassificacao.setTextColor(Color.rgb(0, 0, 0));
                }
                }catch(Exception e){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("Atenção! Insira as informações corretamente. \n " + e);
                    dialog.setNeutralButton("OK", null);
                    dialog.show();
                }
            }
        });
    }
}