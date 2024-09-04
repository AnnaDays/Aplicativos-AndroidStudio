package com.example.quizdebandeiras;

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

public class Resultado extends AppCompatActivity {

    private Button btnSair3, btnReiniciar;
    private TextView txtPontos, txtUsuario;
    private ImageView imgvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgvResultado = findViewById(R.id.imgvResultado);
        btnSair3 = findViewById(R.id.btnSair3);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        txtPontos = findViewById(R.id.txtPontos);
        txtUsuario = findViewById(R.id.txtUsuario);

        // Recupera os dados passados pela Intent
        Intent intent = getIntent();
        int pontos = intent.getIntExtra("pontos", 0);
        String nomeUsuario = intent.getStringExtra("NomeUsuario");

        // Define o texto com a quantidade de pontos e o nome do usuário
        txtPontos.setText("Acertos: " + pontos);
        txtUsuario.setText(nomeUsuario);

        // Define a imagem com base na quantidade de pontos
        if (pontos >= 5) {
            imgvResultado.setImageResource(R.drawable.ana_sorrindo); // Imagem feliz
        } else {
            imgvResultado.setImageResource(R.drawable.anachorando); // Imagem triste
        }

        // Configura o listener do botão "Sair"
        btnSair3.setOnClickListener(view -> finish());

        // Configura o listener do botão "Reiniciar"
        btnReiniciar.setOnClickListener(view -> {
            Intent restartIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(restartIntent);
            finish();
        });
    }
    }
