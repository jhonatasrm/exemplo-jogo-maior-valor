package com.example.jhonatasrm.maiornumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView numero1, numero2, resultado;
    int valorGerado1, valorGerado2;
    int contador;
    int acertou;
    int errou;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = 0;
        acertou = 0;
        errou = 0;

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.resultado);
        random = new Random();

        generate();

        numero1.setText(Integer.toString(valorGerado1));
        numero2.setText(Integer.toString(valorGerado2));
    }


    public void compara1(View view) {
        if(valorGerado1 > valorGerado2){
            resultado.setText("ACERTOU !!!");
            acertou ++;
            contador = contador + 1;
        }else if (valorGerado2 > valorGerado1){
            resultado.setText("ERROU !!!");
            errou ++;
            contador = contador + 1;
        }else if (valorGerado1 == valorGerado2){
            resultado.setText("NUMEROS IGUAIS !!!");
        }else{
            return;
        }
        generate();

    }

    public void compara2(View view) {

        if(valorGerado2 > valorGerado1){
            resultado.setText("ACERTOU !!!");
            acertou ++;
            contador = contador + 1;
        }else if(valorGerado1 > valorGerado2 ){
            resultado.setText("ERROU !!!");
            errou ++;
            contador = contador + 1;
        }else if (valorGerado1 == valorGerado2){
            resultado.setText("NUMEROS IGUAIS !!!");
        }else{
            return;
        }
        generate();
    }

    public void generate(){

        if(contador == 10){
            resultado.setText("Você acertou "+acertou+" e errou "+errou);
            contador = 0;
            errou = 0;
            acertou = 0;
        }
        valorGerado1 = random.nextInt(100);
        valorGerado2 = random.nextInt(100);

        numero1.setText(Integer.toString(valorGerado1));
        numero2.setText(Integer.toString(valorGerado2));
    }
}