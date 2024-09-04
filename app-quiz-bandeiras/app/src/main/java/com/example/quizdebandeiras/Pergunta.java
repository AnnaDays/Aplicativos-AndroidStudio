package com.example.quizdebandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta extends AppCompatActivity {
    private int pergunta = 1;
    private int pontos = 0;
    private String nomeUsuario;

    private TextView txtPergunta;
    private ImageView imgvBandeira;
    private RadioButton rdbOpcao1, rdbOpcao2, rdbOpcao3, rdbOpcao4;
    public Button btnResponder, btnSair2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        txtPergunta = findViewById(R.id.txtPergunta);
        imgvBandeira = findViewById(R.id.imgvBandeira);
        rdbOpcao1 = findViewById(R.id.rdbOpcao1);
        rdbOpcao2 = findViewById(R.id.rdbOpcao2);
        rdbOpcao3 = findViewById(R.id.rdbOpcao3);
        rdbOpcao4 = findViewById(R.id.rdbOpcao4);
        btnResponder = findViewById(R.id.btnResponder);
        btnSair2 = findViewById(R.id.btnSair2);

        // Recupera o nome do usuário passado pela Intent
        Intent intent = getIntent();
        nomeUsuario = intent.getStringExtra("NomeUsuario");

        btnResponder.setOnClickListener(this::proximaBandeira);
        btnSair2.setOnClickListener(v -> {
            pontos = 0;
            pergunta = 1;
            finish();
        });

        atualizarPergunta();
    }

    private void proximaBandeira(View view) {
        if (!rdbOpcao1.isChecked() && !rdbOpcao2.isChecked() && !rdbOpcao3.isChecked() && !rdbOpcao4.isChecked()) {
            Toast.makeText(this, "Por favor, selecione uma resposta", Toast.LENGTH_SHORT).show();
            return;
        }

        if (verificarRespostaCorreta()) {
            pontos++;
        }

        pergunta++;
        if (pergunta > 10) {
            Intent it = new Intent(getApplicationContext(), Resultado.class);
            it.putExtra("pontos", pontos);
            it.putExtra("NomeUsuario", nomeUsuario); // Passa o nome do usuário
            startActivity(it);
            finish();
        } else {
            atualizarPergunta();
        }
    }

    private boolean verificarRespostaCorreta() {
        switch (pergunta) {
            case 1: return rdbOpcao1.isChecked(); // Correto: Estados Unidos da America
            case 2: return rdbOpcao3.isChecked(); // Correto: China
            case 3: return rdbOpcao4.isChecked(); // Correto: Canadá
            case 4: return rdbOpcao1.isChecked(); // Correto: Itália
            case 5: return rdbOpcao4.isChecked(); // Correto: Groenlândia
            case 6: return rdbOpcao4.isChecked(); // Correto: Macedônia do Norte
            case 7: return rdbOpcao4.isChecked(); // Correto: Singapura
            case 8: return rdbOpcao3.isChecked(); // Correto: Rússia
            case 9: return rdbOpcao1.isChecked(); // Correto: Chipre
            case 10: return rdbOpcao1.isChecked(); // Correto: Chipre
            default: return false;
        }
    }

    private void atualizarPergunta() {
        rdbOpcao1.setChecked(false);
        rdbOpcao2.setChecked(false);
        rdbOpcao3.setChecked(false);
        rdbOpcao4.setChecked(false);

        switch (pergunta) {
            case 1:
                imgvBandeira.setImageResource(R.drawable.estados_unidos);
                txtPergunta.setText("Q1 - Qual o nome desse País?");
                rdbOpcao1.setText("Estados Unidos da America");
                rdbOpcao2.setText("Brasil");
                rdbOpcao3.setText("Estados Unidos");
                rdbOpcao4.setText("Estados Unidos do Brasil");
                break;
            case 2:
                imgvBandeira.setImageResource(R.drawable.china);
                txtPergunta.setText("Q2 - Qual o nome desse País?");
                rdbOpcao1.setText("Hong Kong");
                rdbOpcao2.setText("Seoul");
                rdbOpcao3.setText("China");
                rdbOpcao4.setText("Ásia");
                break;
            case 3:
                imgvBandeira.setImageResource(R.drawable.canada);
                txtPergunta.setText("Q3 - Qual o nome desse País?");
                rdbOpcao1.setText("Croácia");
                rdbOpcao2.setText("Catar");
                rdbOpcao3.setText("Guatemala");
                rdbOpcao4.setText("Canadá");
                break;
            case 4:
                imgvBandeira.setImageResource(R.drawable.italia);
                txtPergunta.setText("Q4 - Qual o nome desse País?");
                rdbOpcao1.setText("Itália");
                rdbOpcao2.setText("Irlanda");
                rdbOpcao3.setText("Argentina");
                rdbOpcao4.setText("Espanha");
                break;
            case 5:
                imgvBandeira.setImageResource(R.drawable.groenlandia);
                txtPergunta.setText("Q5 - Qual o nome desse País?");
                rdbOpcao1.setText("Letônia");
                rdbOpcao2.setText("África do Sul");
                rdbOpcao3.setText("Malásia");
                rdbOpcao4.setText("Groenlândia");
                break;
            case 6:
                imgvBandeira.setImageResource(R.drawable.macedoniadonorte);
                txtPergunta.setText("Q6 - Qual o nome desse País?");
                rdbOpcao1.setText("Romênia");
                rdbOpcao2.setText("Colombia");
                rdbOpcao3.setText("Venezuela");
                rdbOpcao4.setText("Macedônia do Norte");
                break;
            case 7:
                imgvBandeira.setImageResource(R.drawable.singapura);
                txtPergunta.setText("Q7 - Qual o nome desse País?");
                rdbOpcao1.setText("Guiné");
                rdbOpcao2.setText("Camarões");
                rdbOpcao3.setText("Mali");
                rdbOpcao4.setText("Singapura");
                break;
            case 8:
                imgvBandeira.setImageResource(R.drawable.russia);
                txtPergunta.setText("Q8 - Qual o nome desse País?");
                rdbOpcao1.setText("Ucrânia");
                rdbOpcao2.setText("Suécia");
                rdbOpcao3.setText("Rússia");
                rdbOpcao4.setText("Noruega");
                break;
            case 9:
                imgvBandeira.setImageResource(R.drawable.brasil);
                txtPergunta.setText("Q9 - Qual o nome desse País?");
                rdbOpcao1.setText("Brasil");
                rdbOpcao2.setText("Chile");
                rdbOpcao3.setText("Nigéria");
                rdbOpcao4.setText("Inglaterra");
                break;
            case 10:
                imgvBandeira.setImageResource(R.drawable.chipre);
                txtPergunta.setText("Q10 - Qual o nome desse País?");
                rdbOpcao1.setText("Chipre");
                rdbOpcao2.setText("Alemanha");
                rdbOpcao3.setText("França");
                rdbOpcao4.setText("Portugal");
                break;
        }
    }
}