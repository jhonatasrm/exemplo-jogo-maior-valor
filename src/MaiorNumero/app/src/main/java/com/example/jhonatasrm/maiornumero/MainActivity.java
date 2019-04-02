package com.example.jhonatasrm.maiornumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView numero1, numero2, resultado1, resultado2;
    int valorGerado1, valorGerado2;
    int contador;
    int acertou;
    int errou;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuracaoInicial();
        gerar();
    }

    // onClick compara o valor clicado com o outro
    public void compara1(View view) {
        if(valorGerado1 > valorGerado2){
            resultado1.setText(R.string.acertou);
            resultado2.setText("");
            acertou ++;
            contador = contador + 1;
        }else if (valorGerado2 > valorGerado1){
            resultado1.setText(R.string.errou);
            resultado2.setText("");
            errou ++;
            contador = contador + 1;
        }else if (valorGerado1 == valorGerado2){
            resultado1.setText(R.string.numeros_iguais);
            resultado2.setText("");
        }else{
            return;
        }
        gerar();

    }

    // onClick compara o valor clicado com o outro
    public void compara2(View view) {

        if(valorGerado2 > valorGerado1){
            resultado1.setText(R.string.acertou);
            resultado2.setText("");
            acertou ++;
            contador = contador + 1;
        }else if(valorGerado1 > valorGerado2 ){
            resultado1.setText(R.string.errou);
            resultado2.setText("");
            errou ++;
            contador = contador + 1;
        }else if (valorGerado1 == valorGerado2){
            resultado1.setText(R.string.numeros_iguais);
            resultado2.setText("");
        }else{
            return;
        }
        gerar();
    }

    //gera valor random e já verifica o número de jogadas para apresentar o número de erros e acertos
    public void gerar(){
        if(contador == 10){
            resultado1.setText(R.string.voce_acertou);
            resultado1.append(" "+ Integer.toString(acertou));
            resultado2.setText(R.string.voce_errou);
            resultado2.append(" "+ Integer.toString(errou));
            contador = 0;
            errou = 0;
            acertou = 0;
        }
        valorGerado1 = random.nextInt(100);
        valorGerado2 = random.nextInt(100);

        numero1.setText(Integer.toString(valorGerado1));
        numero2.setText(Integer.toString(valorGerado2));
    }

    //configuração inicial da tela
    public void configuracaoInicial(){
        contador = 0;
        acertou = 0;
        errou = 0;

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        resultado1 = findViewById(R.id.resultado1);
        resultado2 = findViewById(R.id.resultado2);
        random = new Random();

        numero1.setText(Integer.toString(valorGerado1));
        numero2.setText(Integer.toString(valorGerado2));
    }
}
