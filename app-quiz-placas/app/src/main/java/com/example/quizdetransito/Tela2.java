package com.example.quizdetransito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2 extends AppCompatActivity {
    private int contador = 1;
    static int pontos;

    TextView txtPergunta;
    ImageView imgvPlaca;
    Button btnSair2, btnPlaca1, btnPlaca2, btnPlaca3, btnPlaca4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtPergunta = findViewById(R.id.txtPergunta);
        imgvPlaca = findViewById(R.id.imgvPlaca);
        btnSair2 = findViewById(R.id.btnSair2);
        btnPlaca1 = findViewById(R.id.btnPlaca1);
        btnPlaca2 = findViewById(R.id.btnPlaca2);
        btnPlaca3 = findViewById(R.id.btnPlaca3);
        btnPlaca4 = findViewById(R.id.btnPlaca4);

        atualizarTela();
    }

    public void Sair(View view) {
        finish();
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Tela2.pontos = pontos;
    }

    private void atualizarTela() {
        switch (contador) {
            case 1:
                txtPergunta.setText("Q1 - Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placalombada);
                btnPlaca1.setText("Lombada");
                btnPlaca2.setText("Ponte");
                btnPlaca3.setText("Curva perigosa");
                btnPlaca4.setText("Sinalização de curva");
                break;
            case 2:
                txtPergunta.setText("Q2 - Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placa_txt);
                btnPlaca1.setText("Semáforo à frente");
                btnPlaca2.setText("Cruzamento à frente");
                btnPlaca3.setText("Pode estacionar");
                btnPlaca4.setText("Atenção semáforo");
                break;
            case 3:
                txtPergunta.setText("Q3 - Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placaproibidoestacionar);
                btnPlaca1.setText("Estreitamento de carros");
                btnPlaca2.setText("Proibido atravessar");
                btnPlaca3.setText("Proibido estacionar");
                btnPlaca4.setText("Trânsito à frente");
                break;
            case 4:
                txtPergunta.setText("Q4 - Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placaestreitamento);
                btnPlaca1.setText("Ponte à frente");
                btnPlaca2.setText("Declive acentuado");
                btnPlaca3.setText("Estreitamento de pista");
                btnPlaca4.setText("Redução de velocidade");
                break;
            case 5:
                txtPergunta.setText("Q5 - Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.placapassagem);
                btnPlaca1.setText("Passagem de pedestres");
                btnPlaca2.setText("Atropelamento de pedestres");
                btnPlaca3.setText("Passagem de carros");
                btnPlaca4.setText("Estreitamento de pedestres");
                break;
            case 6:
                Intent it = new Intent(getApplicationContext(), TelaResultado.class);
                startActivity(it);
                finish();
                break;
        }
    }

    public void Escolha1(View view) {
        if (verificarResposta(1)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    public void Escolha2(View view) {
        if (verificarResposta(2)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    public void Escolha3(View view) {
        if (verificarResposta(3)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    public void Escolha4(View view) {
        if (verificarResposta(4)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    private boolean verificarResposta(int escolha) {
        switch (contador) {
            case 1:
                return escolha == 1;
            case 2:
                return escolha == 1;
            case 3:
                return escolha == 3;
            case 4:
                return escolha == 3;
            case 5:
                return escolha == 1;
            default:
                return false;
        }
    }
}