package com.example.aula07;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgMaquina, imgPedra, imgPapel, imgTesoura, imgInt, imgInt2, imgFem, imgMasc, imgPlayer;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMaquina = findViewById(R.id.imgMaquina);
        imgMaquina = findViewById(R.id.imgMaquina);
        txtResultado = findViewById(R.id.txtResultado);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);
        imgInt = findViewById(R.id.imgInt);
        imgInt2 = findViewById(R.id.imgInt2);
        imgFem = findViewById(R.id.imgFem);
        imgMasc = findViewById(R.id.imgMasc);
        imgPlayer = findViewById(R.id.ImgPlayer);


        imgMasc.setOnClickListener(v -> escolher("MASCULINO"));
        imgFem.setOnClickListener(v -> escolher("FEMININO"));

        imgPedra.setOnClickListener(v -> jogar("pedra"));
        imgPapel.setOnClickListener(v -> jogar("papel"));
        imgTesoura.setOnClickListener(v -> jogar("tesoura"));

    }

    public void jogar(String escolhaUsuario) {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaMaquina = opcoes[numero];

        switch (escolhaUsuario) {
            case "pedra":
                imgInt2.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgInt2.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgInt2.setImageResource(R.drawable.tesoura);
                break;
        }

        switch (escolhaMaquina) {
            case "pedra":
                imgInt.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgInt.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgInt.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaUsuario.equals(escolhaMaquina)) {
            txtResultado.setText("Empate!");
        } else if ((escolhaUsuario.equals("pedra") && escolhaMaquina.equals("tesoura")) ||
                (escolhaUsuario.equals("papel") && escolhaMaquina.equals("pedra")) ||
                (escolhaUsuario.equals("tesoura") && escolhaMaquina.equals("papel"))) {
            txtResultado.setText("Você ganhou!");
        } else {
            txtResultado.setText("Você perdeu!");
        }
    }

    public void escolher(String escolhaPersonagem) {

        switch (escolhaPersonagem) {
            case "MASCULINO":
                imgPlayer.setImageResource(R.drawable.usuario_masc);
                break;
            case "FEMININO":
                imgPlayer.setImageResource(R.drawable.usuario_fem);
                break;
        }
    }
}